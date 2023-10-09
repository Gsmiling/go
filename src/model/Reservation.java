package model;

import java.util.Date;

public class Reservation extends IdentifiedObject{
    Client client;
    Room chambre;
    private Date dateArrivee;
    private Date dateDepart;
    public  Reservation(int id, Client client, Room chambre, Date dateArrivee, Date dateDepart){
        this.chambre = chambre;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.client = client;
        this.id = id;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Room getChambre() {
        return chambre;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public Integer getId() {
        return (Integer) super.getId();
    }
}
