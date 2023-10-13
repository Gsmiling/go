package provider;

import model.FidelityCard;
import model.IdentifiedObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FidelityCardProvider implements ProviderMethod {

    public static FidelityCardProvider instance;
    static private Provider provider;

    private FidelityCardProvider() {

    }

    public static FidelityCardProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new FidelityCardProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof FidelityCard)) {
            return false;
        }

        String sql = "INSERT INTO votre_table (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            FidelityCard carteDeFidelite = (FidelityCard) object;
            preparedStatement.setDate(1, carteDeFidelite.getDateIssue());
            preparedStatement.setDate(2, carteDeFidelite.getExpirationDate());
            preparedStatement.setInt(3, carteDeFidelite.getId());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof FidelityCard)) {
            return false;
        }

        String sql = "DELETE FROM votre_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            FidelityCard carteDeFidelite = (FidelityCard) object;
            preparedStatement.setInt(1, carteDeFidelite.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof FidelityCard)) {
            return false;
        }

        String sql = "UPDATE votre_table SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            FidelityCard carteDeFidelite = (FidelityCard) object;
            preparedStatement.setDate(1, carteDeFidelite.getDateIssue());
            preparedStatement.setDate(2, carteDeFidelite.getExpirationDate());
            preparedStatement.setInt(4, carteDeFidelite.getId());

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0; // Vérifie si une ligne a été mise à jour avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public IdentifiedObject getElementById(Object id) {
        if (!(id instanceof Integer)) {
            return null;
        }

        String sql = "SELECT * FROM votre_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                FidelityCard carteDeFidelite = new FidelityCard(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateIssue"),
                        resultSet.getDate("expirationDate")
                );
                return carteDeFidelite;
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
            ArrayList<FidelityCard> listeCartesDeFidelite = new ArrayList<>();

            while (resultSet.next()) {
                FidelityCard carteDeFidelite = new FidelityCard(
                        resultSet.getInt("id"),
                        resultSet.getDate("dateIsuue"),
                        resultSet.getDate("dateExpiration")
                        // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                listeCartesDeFidelite.add(carteDeFidelite);
            }

            return new ArrayList<>(listeCartesDeFidelite);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
