package model;

public class Client extends IdentifiedObject {

    private final String clientName;
    private final String firstName;
    private final int numCart;
    private final int phoneNumber;
    private final String nationality;
    private  ClientCategory clientCategory;



    public Client(int id, String nameCli, String firstName, int numCart, int phoneNumber, String nationality, ClientCategory clientCategory){
        this.clientName = nameCli;
        this.numCart = numCart;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.nationality = nationality;
        this.firstName = firstName;
        this.clientCategory = clientCategory;

    }

    public int getNumCart() {
        return numCart;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getNameCli() {
        return clientName;
    }
    public String getFirstName(){
        return firstName;
    }

    public int getNumPhone() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public ClientCategory getClientCategory() {
        return clientCategory;
    }
    public void setClientCategory(ClientCategory clientCategory) {
        this.clientCategory = clientCategory;
    }
}
