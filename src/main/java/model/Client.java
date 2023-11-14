package model;

public class Client extends IdentifiedObject {

    private final String clientName;
    private final String firstName;
    private final int numCart;
    private final int phoneNumber;
    private final String nationality;
    private  ClientCategory clientCategory;



    public Client(int id, String nomCli, String firstName, int numCart, int numeroTelephone, String nationality){
        this.clientName = nomCli;
        this.numCart = numCart;
        this.phoneNumber = numeroTelephone;
        this.id = id;
        this.nationality = nationality;
        this.firstName = firstName;

    }

    public int getNumCart() {
        return numCart;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getNomCli() {
        return clientName;
    }
    public String getFirstName(){
        return firstName;
    }

    public int getPhoneNumber() {
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
