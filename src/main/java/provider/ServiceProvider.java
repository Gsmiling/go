package provider;

import model.IdentifiedObject;
import model.Service; // Assurez-vous d'importer la classe Service ou le type d'objet approprié.

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvider implements ProviderMethod {
    public static ServiceProvider instance;
    static private Provider provider;

    private ServiceProvider() {

    }

    public static ServiceProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ServiceProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Service)) { // Assurez-vous que Service correspond au type d'objet que vous manipulez.
            return false;
        }

        String sql = "INSERT INTO service (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Service service = (Service) object;
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getDesignation());
        

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Service)) {
            return false;
        }

        String sql = "DELETE FROM service WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Service service = (Service) object;
            preparedStatement.setInt(1, service.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Service)) {
            return false;
        }

        String sql = "UPDATE service SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Service service = (Service) object;
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getDesignation());
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

        String sql = "SELECT * FROM service WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Service service = new Service(
                    resultSet.getInt("id"),
                    resultSet.getString("designation")
                    // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                return service;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM service";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Service> listeServices = new ArrayList<>();

            while (resultSet.next()) {
                Service service = new Service(
                    resultSet.getInt("id"),
                    resultSet.getString("designation")
                    // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                listeServices.add(service);
            }

            return new ArrayList<>(listeServices);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
