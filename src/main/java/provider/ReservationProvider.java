package provider;

import model.IdentifiedObject;
import model.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationProvider implements ProviderMethod {
    public static ReservationProvider instance;
    static private Provider provider;

    private ReservationProvider() {

    }

    public static ReservationProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ReservationProvider();
        }
        return instance;
    }

    @Override
    public boolean add(IdentifiedObject object) {
        if (!(object instanceof Reservation)) {
            return false;
        }

        String sql = "INSERT INTO reservation (champ1, champ2, champ3, champ4, champ5) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Reservation reservation = (Reservation) object;
            preparedStatement.setInt(1, reservation.getId());
            preparedStatement.setInt(2, reservation.getClientId());
            preparedStatement.setString(3, reservation.getChambre());
            preparedStatement.setDate(4, reservation.getDateArrivee());
            preparedStatement.setDate(5, reservation.getDateDepart());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0; // Vérifie si une ligne a été insérée avec succès
        } catch (SQLException e) {
        }

        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        if (!(object instanceof Reservation)) {
            return false;
        }

        String sql = "DELETE FROM reservation WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Reservation reservation = (Reservation) object;
            preparedStatement.setInt(1, reservation.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0; // Vérifie si une ligne a été supprimée avec succès
        } catch (SQLException e) {
        }

        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        if (!(object instanceof Reservation)) {
            return false;
        }

        String sql = "UPDATE reservation SET champ1 = ?, champ2 = ?, champ3 = ?, champ4 = ?, champ5 = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            Reservation reservation = (Reservation) object;
            preparedStatement.setInt(6, reservation.getId());
            preparedStatement.setInt(1, reservation.getClientId());
            preparedStatement.setString(2, reservation.getChambre());
            preparedStatement.setDate(3, reservation.getDateArrivee());
            preparedStatement.setDate(4, reservation.getDateDepart());

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0; // Vérifie si une ligne a été mise à jour avec succès
        } catch (SQLException e) {
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
                Reservation reservation = new Reservation(
                        resultSet.getInt("id"),
                        resultSet.getInt("client"),
                         resultSet.getString("chambre"),
                        resultSet.getDate("dateArrivee"),
                        resultSet.getDate("dateDepart")
                        // Vous pouvez ajouter d'autres champs ici selon votre modèle
                );
                return reservation;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        String sql = "SELECT * FROM reservation";

        try {
            PreparedStatement preparedStatement = provider.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Reservation> listeReservations = new ArrayList<>();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("id"),
                        resultSet.getInt("client"),
                        resultSet.getString("chambre"),
                        resultSet.getDate("dateArrivee"),
                        resultSet.getDate("dateDepart")
                );
                listeReservations.add(reservation);
            }

            return new ArrayList<>(listeReservations);
        } catch (SQLException e) {
        }

        return new ArrayList<>();
    }
}
