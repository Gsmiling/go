public class Chambre extends Categorie_chambre{

        private int numeroChambre;
        private String typeChambre;
        private double prix;
        private boolean disponible;
        public Chambre( int id, String libelle, int numeroChambre,String typeChambre,double prix)
                {
                        super(id, libelle);
                        this.numeroChambre = numeroChambre;
                        this.prix = prix;
                        this.typeChambre =typeChambre;
                }
        public int getNumeroChambre(){
                return numeroChambre;
        }
        public double getPrix(){
                return prix;
        }

}
