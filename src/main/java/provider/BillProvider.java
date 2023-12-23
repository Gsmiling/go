package provider;

import java.sql.Date;
import model.Bill; // Assurez-vous d'importer la classe Bill ou le type d'objet approprié.
import model.IdentifiedObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillProvider implements ProviderMethod {
    public static BillProvider instance;
    static private Provider provider;

    private BillProvider() {

    }

    public static BillProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new BillProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Bill)) { // Assurez-vous que Bill correspond au type d'objet que vous manipulez.
            return false;
        }

        String sql = "INSERT INTO bill (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Bill bill = (Bill) object;
            preparedStatement.setInt(1, bill.getId());
            preparedStatement.setDouble(2, bill.getAmount());
            preparedStatement.setDate(3, (Date)bill.getBillDate());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Bill)) {
            return false;
        }

        String sql = "DELETE FROM votre_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Bill bill = (Bill) object;
            preparedStatement.setInt(1, bill.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Bill)) {
            return false;
        }

        String sql = "UPDATE votre_table SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Bill bill = (Bill) object;
            preparedStatement.setInt(4, bill.getId());
            preparedStatement.setDouble(1, bill.getAmount());
            preparedStatement.setDate(2, (Date) bill.getBillDate());

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
                Bill bill = new Bill(
                    resultSet.getInt("id"),
                    resultSet.getDate("billDate"),
                        resultSet.getInt("amount")
                    // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                return bill;
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
            ArrayList<Bill> listeBills = new ArrayList<>();

            while (resultSet.next()) {
                Bill bill = new Bill(
                    resultSet.getInt("id"),
                    resultSet.getDate("billDate"),
                          resultSet.getDouble("amount")
                    // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                listeBills.add(bill);
            }

            return new ArrayList<>(listeBills);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
