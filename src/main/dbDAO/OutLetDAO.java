package dbDAO;

import db.DBs;
import model.Outlet;

import java.util.*;

public class OutLetDAO implements IDAO<Outlet>{

    private volatile static OutLetDAO instance = null;

    private OutLetDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static OutLetDAO getInstance() {

        if(instance==null) {
            synchronized (OutLetDAO.class) {

                if(instance==null) {
                    instance = new OutLetDAO();
                }

            }
        }

        return instance;
    }

    @Override
    public void create(Outlet value) {
        DBs.outletDB.put(value.getOutletName(), value);
    }

    @Override
    public Optional<Outlet> get(String id) {
        return Optional.of(DBs.outletDB.get(id));
    }

    @Override
    public Collection<Outlet> getAll() {
        List<Outlet> outletIdList = new ArrayList<>();

        for(Map.Entry<String, Outlet> entry : DBs.outletDB.entrySet()){
            outletIdList.add(entry.getValue());
        }

        return outletIdList;
    }

    @Override
    public List<Optional<Outlet>> getBatch(String id) {
        return null;
    }

    @Override
    public void update(Outlet value) {

    }

    @Override
    public void delete(String id) {

    }
}
