//import model.RoomCategory;
import model.Room;
import model.Hotel;

public class TestHotel {
    public static void main(String[] args) {
        Room[]m = new Room[2];
               m[0] = new Room( 5,"suite",201,25000);
               m[1] = new Room( 6,"appartement",321,25000);
        Hotel h = new Hotel("Amnesia", "Adidogomé",14,m[0]);
       //h.accueil();
       //h.commande();
        System.out.println("Prix de la chambre : "+m[0].getPrix());
        Hotel ho = h.copie();
        ho.commande("Salt");
        //ho.getLocalisation();
       System.out.println(h.getLocalisation());
    }
} 