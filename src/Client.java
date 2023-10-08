public class Client {
    private String nomCli;
    private int numCart;
    private int numeroTelephone;
    public Client(String nomCli, int numCart, int numeroTelephone){
        this.nomCli = nomCli;
        this.numCart = numCart;
        this.numeroTelephone = numeroTelephone;

    }

    public int getNumCart() {
        return numCart;
    }

    public String getNomCli() {
        return nomCli;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }
}
