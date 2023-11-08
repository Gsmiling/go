package provider;

import model.IdentifiedObject;

import java.sql.SQLException;
import java.util.List;

public interface ProviderMethod {

    boolean add(IdentifiedObject object);
    boolean delete(IdentifiedObject object);
    boolean update(IdentifiedObject object) throws SQLException;
    IdentifiedObject getElementById(Object id);
    List<IdentifiedObject> getAll();
}
