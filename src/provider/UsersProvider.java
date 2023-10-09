package provider;

import model.IdentifiedObject;

import java.util.List;

public class UsersProvider implements ProviderMethod {
    public static UsersProvider instance;
    static  private Provider provider;

    private UsersProvider() {

    }

    public static UsersProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new UsersProvider();
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