package provider;

public class RoomProvider  {
    public static RoomProvider instance;

    private RoomProvider() {

    }

    public static RoomProvider getInstance() {
        if (instance == null) {
            instance = new RoomProvider();
        }
        return instance;
    }
}