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
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection success");
        } catch (SQLException e) {
            e.printStackTrace();
            //Cette méthode utilise la classe DriverManager de
            // JDBC pour établir une connexion à la base de données en utilisant
            // les informations de connexion spécifiées dans les variables url, username et password.
        //} catch (ClassNotFoundException e) {
           // throw new RuntimeException(e);
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

    public Connection getConnection() {
        return connection;
    }

    public static final String id = "id";
    public static final String nom = "nom";
    public final static String firstName = "firstName";
    public static final String numCart = "numCart";
    public static final String numeroTelephone = "numeroTelephone";
    public static final String nationality = "nationality";
}
