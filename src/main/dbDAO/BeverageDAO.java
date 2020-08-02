package dbDAO;

import db.DBs;
import db.OutletToBeverages;
import model.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BeverageDAO implements IDAO<Beverages>{

    private volatile static BeverageDAO instance = null;

    private BeverageDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static BeverageDAO getInstance() {

        if(instance==null) {
            synchronized (BeverageDAO.class) {

                if(instance==null) {
                    instance = new BeverageDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(Beverages value) {
        DBs.beveragesDB.put(value.getBeverageName(), value);
    }

    @Override
    public Optional<Beverages> get(String id) {
        return Optional.ofNullable(DBs.beveragesDB.get(id));
    }

    @Override
    public Collection<Beverages> getAll() {
        return null;
    }

    @Override
    public List<Optional<Beverages>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Beverages value) {

    }

    @Override
    public void delete(String id) {

    }
}
