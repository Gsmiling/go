package provider;

import model.Client;
import model.IdentifiedObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientProvider implements ProviderMethod {



    public static ClientProvider instance;
    static  private Provider provider;

    private ClientProvider(){

    }
    public static ClientProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ClientProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Client)) {
            return false;
        }

        String sql = "INSERT INTO client (nom, firstName, numcart, nationality, numeroTelephone, clientCategory) VALUES (?, ?, ?,?,?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, ((Client) object).getNomCli());
            preparedStatement.setString(2, ((Client) object).getFirstName());
            preparedStatement.setInt(3, ((Client) object).getNumCart());
            preparedStatement.setString(4, ((Client) object).getNationality());
            preparedStatement.setInt(5, ((Client) object).getPhoneNumber());
            preparedStatement.setString(6,((Client) object).getClientCategory().toString());
            preparedStatement.execute();
            return  true;
        } catch (SQLException e) {
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Client)) {
            return false;
        }
        String sql = "DELETE FROM client WHERE id = " + object.getId();

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.execute();
            return  true;
        } catch (SQLException e) {
        }

        return false;
    }
    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Client)) {
            return false;
        }

        String sql = "UPDATE client SET nom = ?, firstName = ?, numcart = ?, nationality = ?, numeroTelephone = ?, clientCategory = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Client client = (Client) object;
            preparedStatement.setString(1, client.getNomCli());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setInt(3, client.getNumCart());
            preparedStatement.setString(4, client.getNationality());
            preparedStatement.setInt(5, client.getPhoneNumber());
            preparedStatement.setString(6, client.getClientCategory().toString());
            preparedStatement.setInt(7, client.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0; // Vérifie si une ligne a été mise à jour avec succès
        } catch (SQLException e) {
        }

        return false;
    }

    @Override
    public IdentifiedObject getElementById(Object id) {
        Client c = null;
        String sql = "SELECT * FROM clients WHERE " + Provider.id + " = " + id;

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                c = new Client(resultSet.getInt(Provider.id),
                        resultSet.getString(Provider.nom),
                        resultSet.getString(Provider.firstName),
                        resultSet.getInt(Provider.numCart),
                        resultSet.getInt(Provider.numeroTelephone),
                        resultSet.getString(Provider.nationality));
            }
        } catch (SQLException e) {

        }
        return c;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM clients ";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Client> l = new ArrayList();
            while (resultSet.next()) {
                l.add(
                        new Client(resultSet.getInt(Provider.id),
                                resultSet.getString(Provider.nom),
                                resultSet.getString(Provider.firstName),
                                resultSet.getInt(Provider.numCart),
                                resultSet.getInt(Provider.numeroTelephone),
                                resultSet.getString(Provider.nationality))
                );
            }
        } catch (SQLException e) {
        }

        return new ArrayList<>();
    }
}
