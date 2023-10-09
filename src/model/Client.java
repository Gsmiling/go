package model;

public class Client extends IdentifiedObject {
    private String nomCli;
    private int numCart;
    private int phoneNumber;
    private String nationality;
    private String profession;




    public Client(int id, String nomCli, int numCart, int numeroTelephone, String nationality, String profession){
        this.nomCli = nomCli;
        this.numCart = numCart;
        this.phoneNumber = numeroTelephone;
        this.id = id;
        this.profession = profession;
        this.nationality = nationality;

    }

    public int getNumCart() {
        return numCart;
    }

    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }

    public String getNomCli() {
        return nomCli;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfession() {
        return profession;
    }

    public String getNationality() {
        return nationality;
    }
}
