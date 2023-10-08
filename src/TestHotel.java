public class TestHotel {
    public static void main(String[] args) {
        Categorie_chambre m[] = new Categorie_chambre[2];
               m[0] = new Chambre( 5,"suite",201,"suite",25000);
               m[1] = new Chambre( 6,"appartement",321,"suite",25000);
        Hotel h = new Hotel("Amnesia", "Adidogomé",14,m[0]);
       //h.accueil();
       //h.commande();
        System.out.println("Prix de la chambre : "+m[0].getLibelle());
        Hotel ho = h.copie();
        ho.commande("Salt");
        //ho.getLocalisation();
       System.out.println(h.getLocalisation());
    }
} 