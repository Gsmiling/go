package provider;

import model.IdentifiedObject;

import java.util.List;

public class ServiceProvider implements ProviderMethod {
    public static ServiceProvider instance;
    static  private Provider provider;

    private ServiceProvider() {

    }

    public static ServiceProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ServiceProvider();
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
