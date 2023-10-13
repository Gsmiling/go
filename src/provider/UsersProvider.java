package provider;

import model.IdentifiedObject;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersProvider implements ProviderMethod {
    public static UsersProvider instance;
    static private Provider provider;

    private UsersProvider() {

    }

    public static UsersProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new UsersProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof User)) {
            return false;
        }

        String sql = "INSERT INTO users (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            User user = (User) object;
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof User)) {
            return false;
        }

        String sql = "DELETE FROM users WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            User user = (User) object;
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof User)) {
            return false;
        }

        String sql = "UPDATE users SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            User user = (User) object;
            preparedStatement.setInt(4, user.getId());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

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
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("Name"),
                        resultSet.getString("firstName"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM Users";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<User> listUsers = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                listUsers.add(user);
            }

            return new ArrayList<>(listUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    public User getUserByLoginInfo(String username, String password) {

        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
