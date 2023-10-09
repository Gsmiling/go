package model;

public class Hotel {
    private  String nomHotel;
    private String localisation;
    private int nbreChambre;
    private RoomCategory c;

public Hotel(String nomHotel, String localisation, int nbreChambre, RoomCategory c) {
    this.nomHotel = nomHotel;
    this.c = c;
    this.localisation= localisation;
    this.nbreChambre = nbreChambre;
}
public void commande(String client){
    System.out.println("Le client "+client+" de la chambre "+c.getId()+" a commandé un poulet avec du jus frais.");
}
public void accueil(){
    System.out.println("Bonjour, vous êtes bien à l'hôtel "+nomHotel+" situé à "+localisation+"\nNous avons "+nbreChambre+" Chambres"+" avec differents caracteristiques. Nous sommes à vous.");

}
public Hotel copie(){
    Hotel s = new Hotel(nomHotel,localisation,nbreChambre,c);
    return s;
}

    public int getNbreChambre() {
        return nbreChambre;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public String getLocalisation() {
        return localisation;
    }

    public RoomCategory getC() {
        return c;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }
}
