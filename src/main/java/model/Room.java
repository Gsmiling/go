package model;

public class Room extends RoomCategory {

        private final int numeroChambre;
        private double prix;
        private boolean disponible;
        public Room(int id, int numeroChambre, double prix, String label, Location location, Characteristic characteristic, RoomType roomtype) {
                        super(id,label, location, characteristic, roomtype);
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
