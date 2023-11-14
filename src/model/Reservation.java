package model;

import java.util.Date;

public class Reservation extends IdentifiedObject{
    int clientId;
    String chambre;
    private Date dateArrivee;
    private Date dateDepart;
    private ReservationStatement reservationStatement;
    public  Reservation(int id, int clientId, String chambre, Date dateArrivee, Date dateDepart){
        this.chambre = chambre;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.clientId = clientId;
        this.id = id;
    }

    public java.sql.Date getDateArrivee() {
        return (java.sql.Date) dateArrivee;
    }

    public java.sql.Date getDateDepart() {
        return (java.sql.Date) dateDepart;
    }

    public String getChambre() {
        return chambre;
    }

    public int getClientId() {
        return clientId;
    }

    @Override
    public int getId() {

        return super.getId();
    }

    public ReservationStatement getReservationStatement() {
        return reservationStatement;
    }

    public void setReservationStatement(ReservationStatement reservationStatement) {
        this.reservationStatement = reservationStatement;
    }
}
