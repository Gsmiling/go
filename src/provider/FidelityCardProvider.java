package provider;

import model.IdentifiedObject;

import java.util.List;

public class FidelityCardProvider implements ProviderMethod {

        public static FidelityCardProvider instance;
        static  private Provider provider;

        private FidelityCardProvider(){

        }
        public static FidelityCardProvider getInstance() {
            if (instance == null) {
                provider = Provider.getInstance();
                instance = new FidelityCardProvider();
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
