package provider;

import model.IdentifiedObject;
import model.Room; // Assurez-vous d'importer la classe Room ou le type d'objet approprié.

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Characteristic;
import model.Location;
import model.RoomType;

public class RoomProvider implements ProviderMethod {
    public static RoomProvider instance;
    static private Provider provider;

    private RoomProvider() {

    }

    public static RoomProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new RoomProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Room)) { // Assurez-vous que Room correspond au type d'objet que vous manipulez.
            return false;
        }

        String sql = "INSERT INTO room (champ1, champ2, champ3) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Room room = (Room) object;
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setInt(2, room.getNumeroChambre());
            preparedStatement.setDouble(3, room.getPrix());
             preparedStatement.setString(4, room.getLabel());
            preparedStatement.setString(5, room.getLocation().toString());
            preparedStatement.setString(6, room.getCharacteristic().toString());
            preparedStatement.setString(7, room.getRoomType().toString());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Room)) {
            return false;
        }

        String sql = "DELETE FROM room WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Room room = (Room) object;
            preparedStatement.setInt(1, room.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Room)) {
            return false;
        }

        String sql = "UPDATE room SET champ1 = ?, champ2 = ?, champ3 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Room room = (Room) object;
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setInt(2, room.getNumeroChambre());
            preparedStatement.setDouble(3, room.getPrix());
            preparedStatement.setString(4, room.getLabel());
            preparedStatement.setString(5, room.getLocation().toString());
            preparedStatement.setString(6, room.getCharacteristic().toString());
            preparedStatement.setString(7, room.getRoomType().toString());
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

        String sql = "SELECT * FROM room WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Room room = new Room(
                    resultSet.getInt("id"),
                    resultSet.getInt("numeroChambre"),
                    resultSet.getDouble("prix"),
                        resultSet.getString("label"),
                        Location.fromString(resultSet.getString("location")),
                        Characteristic.fromString(resultSet.getString("characteristic")),
                        RoomType.fromString(resultSet.getString("room_type"))
                        
                    // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                return room;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM room";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Room> listeRooms = new ArrayList<>();

            while (resultSet.next()) {
                Room room = new Room(
                    resultSet.getInt("id"),
                    resultSet.getInt("numeroChambre"),
                    resultSet.getDouble("prix"),
                    resultSet.getString("label"),
                        Location.fromString(resultSet.getString("location")),
                        Characteristic.fromString(resultSet.getString("characteristic")),
                        RoomType.fromString(resultSet.getString("room_type"))
                );
                listeRooms.add(room);
            }

            return new ArrayList<>(listeRooms);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
