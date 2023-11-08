package model;

public class Room extends RoomCategory {

        private final int numeroChambre;
        private String typeChambre;
        private double prix;
        private boolean disponible;
        public Room(int id, String libelle, int numeroChambre, double prix) {
                        this.numeroChambre = numeroChambre;
                        this.prix = prix;
                }
        public int getNumeroChambre(){
                return numeroChambre;
        }
        public double getPrix(){
                return prix;
        }

}
