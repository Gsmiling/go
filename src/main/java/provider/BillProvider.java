package provider;

import model.IdentifiedObject;

import java.util.List;

public class BillProvider implements ProviderMethod{
    public static BillProvider instance;
    static  private Provider provider;

    private BillProvider() {

    }

    public static BillProvider getInstance() {
        if (instance == null) {
            provider = Provider.getInstance();
            instance = new BillProvider();
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
