package provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Provider {
    protected static boolean initialized = false;
    protected static String url = "jdbc:mysql://localhost:3306/votre_base_de_donnees";
    protected static String username = "votre_nom_utilisateur";
    protected static String password = "votre_mot_de_passe";

    private static Connection connection;

    private static final Provider instance = new Provider();

    private Provider() { // Constructeur privé pour empêcher l'instanciation directe

    }

    public static Provider getInstance() {
        if (!initialized) {
            initDb();
            initialized = true;
        }
        return instance;
    }

    public static Provider getInstance(String url, String username, String password) {
        Provider.url = url;
        Provider.username = username;
        Provider.password = password;
        return  getInstance();
    }

    public static Provider getInstance(boolean reInit) {
        if (!initialized || reInit) {
            initDb();
            initialized = true;
        }
        return instance;
    }

    public static Provider getInstance(String url, String username, String password, boolean reInit) {

        if (!initialized || reInit) {
            Provider.url = url;
            Provider.username = username;
            Provider.password = password;
        }
        return  getInstance(reInit);
    }

    protected static void initDb() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            //Cette méthode utilise la classe DriverManager de
            // JDBC pour établir une connexion à la base de données en utilisant
            // les informations de connexion spécifiées dans les variables url, username et password.
        }
    }

    public void close() throws SQLException {
        connection.close();
        initialized = false;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Provider.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Provider.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Provider.password = password;
    }

    public static Connection getConnection() {
        return connection;
    }
}
