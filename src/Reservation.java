import java.util.Date;

public class Reservation {
    Client client;
    Chambre chambre;
    private Date dateArrivee;
    private Date dateDepart;
    public  Reservation(Client client,Chambre chambre,Date dateArrivee,Date dateDepart){
        this.chambre = chambre;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.client = client;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public Client getClient() {
        return client;
    }
}
