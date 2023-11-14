package model;

public class Service extends IdentifiedObject {
    private String designation;
    public Service(int id, String designation){
        this.designation = designation;
        this.id = id;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
