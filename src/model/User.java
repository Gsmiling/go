package model;

public class User extends IdentifiedObject {
    private String name;
    private String firstName;
    private String login;
    private String password;
    private boolean admin;
    public User(int id, String name, String firstName, String login, String password){
        this.firstName = firstName;
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    @Override
    public int getId() {

        return super.getId();
    }

    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
