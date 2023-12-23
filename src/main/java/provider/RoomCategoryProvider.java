package provider;

import model.IdentifiedObject;
import model.RoomCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Characteristic;
import model.Location;
import model.RoomType;

public class RoomCategoryProvider implements ProviderMethod {
    public static RoomCategoryProvider instance;
    static private Provider provider;

    private RoomCategoryProvider() {

    }

    public static RoomCategoryProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new RoomCategoryProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof RoomCategory)) {
            return false;
        }

        String sql = "INSERT INTO room_category (label, location, characteristic, room_type) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            RoomCategory roomCategory = (RoomCategory) object;
            preparedStatement.setString(1, roomCategory.getLabel());
            preparedStatement.setString(2, roomCategory.getLocation().toString());
            preparedStatement.setString(3, roomCategory.getCharacteristic().toString());
            preparedStatement.setString(4, roomCategory.getRoomType().toString());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof RoomCategory)) {
            return false;
        }

        String sql = "DELETE FROM room_category WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            RoomCategory roomCategory = (RoomCategory) object;
            preparedStatement.setInt(1, roomCategory.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof RoomCategory)) {
            return false;
        }

        String sql = "UPDATE room_category SET label = ?, location = ?, characteristic = ?, room_type = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            RoomCategory roomCategory = (RoomCategory) object;
            preparedStatement.setInt(1, roomCategory.getId());
            preparedStatement.setString(2, roomCategory.getLabel());
            preparedStatement.setString(3, roomCategory.getLocation().toString());
            preparedStatement.setString(4, roomCategory.getCharacteristic().toString());
            preparedStatement.setString(5, roomCategory.getRoomType().toString());

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

        String sql = "SELECT * FROM room_category WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                RoomCategory roomCategory = new RoomCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("label"),
                        Location.fromString(resultSet.getString("location")),
                        Characteristic.fromString(resultSet.getString("characteristic")),
                        RoomType.fromString(resultSet.getString("room_type"))
                );
                return roomCategory;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM room_category";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<RoomCategory> listeRoomCategories = new ArrayList<>();

            while (resultSet.next()) {
                RoomCategory roomCategory = new RoomCategory(
                       resultSet.getInt("id"),
                        resultSet.getString("label"),
                        Location.fromString(resultSet.getString("location")),
                        Characteristic.fromString(resultSet.getString("characteristic")),
                        RoomType.fromString(resultSet.getString("room_type"))
                );
                listeRoomCategories.add(roomCategory);
            }

            return new ArrayList<>(listeRoomCategories);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
