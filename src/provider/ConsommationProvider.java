package provider;

import model.IdentifiedObject;

import java.util.List;

public class ConsommationProvider implements ProviderMethod {
    public static ConsommationProvider instance;
    static  private Provider provider;

    private ConsommationProvider() {

    }

    public static ConsommationProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new ConsommationProvider();
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
