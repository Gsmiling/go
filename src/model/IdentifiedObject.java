package model;

public abstract class IdentifiedObject {
    protected Object id;

    public Object getId() {
        return id;
    }
    public void setId(Object id) {
      this.id = id;
    }
}
