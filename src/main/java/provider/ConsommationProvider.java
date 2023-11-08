package provider;

import model.Consommation;
import model.IdentifiedObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsommationProvider implements ProviderMethod {
    public static ConsommationProvider instance;
    static private Provider provider;

    private ConsommationProvider() {

    }

    public static ConsommationProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ConsommationProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Consommation)) {
            return false;
        }

        String sql = "INSERT INTO votre_table (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Consommation consommation = (Consommation) object;
            preparedStatement.setInt(1, consommation.getId());
            preparedStatement.setDate(2, consommation.getDateConso());
            preparedStatement.setDouble(3, consommation.getServicePrice());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Consommation)) {
            return false;
        }

        String sql = "DELETE FROM consommation WHERE id = "+object.getId();

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Consommation consommation = (Consommation) object;
            preparedStatement.setInt(1, consommation.getId());
            preparedStatement.setDate(2, consommation.getDateConso());
            preparedStatement.setDouble(3, consommation.getServicePrice());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Consommation)) {
            return false;
        }

        String sql = "UPDATE votre_table SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Consommation consommation = (Consommation) object;


            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0; // Vérifie si une ligne a été mise à jour avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public IdentifiedObject getElementById(Object id) {
        if (!(id instanceof Integer)){
            return null;
        }
        String sql = "SELECT * FROM votre_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Consommation consommation = new Consommation(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateConso"),
                        resultSet.getDouble("servicePrice")

                        // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                return consommation;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM votre_table";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Consommation> listeConsommations = new ArrayList<>();

            while (resultSet.next()) {
                Consommation consommation = new Consommation(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateConso"),
                        resultSet.getDouble("servicePrice")
                        // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                listeConsommations.add(consommation);
            }

            return new ArrayList<>(listeConsommations);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
