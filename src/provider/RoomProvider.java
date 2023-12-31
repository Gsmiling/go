package provider;

import model.IdentifiedObject;

import java.util.List;

public class RoomProvider implements ProviderMethod {
    public static RoomProvider instance;
    static  private Provider provider;

    private RoomProvider() {

    }

    public static RoomProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new RoomProvider();
        }
        return instance;
    }


    @Override
    public boolean add(IdentifiedObject object) {
        return false;
    }

    @Override
    public boolean delete(IdentifiedObject object) {
        return false;
    }

    @Override
    public boolean update(IdentifiedObject object) {
        return false;
    }

    @Override
    public IdentifiedObject getElementById(Object id) {
        return null;
    }

    @Override
    public List<IdentifiedObject> getAll() {
        return null;
    }
}