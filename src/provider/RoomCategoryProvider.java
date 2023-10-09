package provider;

import model.IdentifiedObject;

import java.util.List;

public class RoomCategoryProvider implements ProviderMethod{
    public static RoomCategoryProvider instance;
    static  private Provider provider;

    private RoomCategoryProvider(){

    }
    public static RoomCategoryProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new RoomCategoryProvider();
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
