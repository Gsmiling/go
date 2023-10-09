package model;

public class Client extends IdentifiedObject {
    private String clientName;
    private String firstName;
    private int numCart;
    private int phoneNumber;
    private String nationality;
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
    public Integer getId() {
        return (Integer) super.getId();
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
