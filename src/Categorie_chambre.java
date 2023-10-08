public class Categorie_chambre {
    protected int id;
    protected String libelle;
    public Categorie_chambre(int id, String libelle){
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
