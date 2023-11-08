package model;

public abstract class RoomCategory extends IdentifiedObject {
    protected String label;
    protected Location location;
    protected Characteristic characteristic;
    protected RoomType roomType;

    public Integer getId() {
        return (Integer) id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Location getLocation() {
        return location;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
