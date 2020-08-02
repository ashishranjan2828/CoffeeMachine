package dbDAO;

import db.DBs;
import db.OutletToBeverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class OutletToBeveragesDAO implements IDAO<OutletToBeverages>{
    private volatile static OutletToBeveragesDAO instance = null;

    private OutletToBeveragesDAO() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static OutletToBeveragesDAO getInstance() {

        if(instance==null) {
            synchronized (OutletToBeveragesDAO.class) {

                if(instance==null) {
                    instance = new OutletToBeveragesDAO();
                }

            }
        }

        return instance;
    }


    @Override
    public void create(OutletToBeverages value) {
        DBs.outletToBeveragesList.add(value);
    }

    @Override
    public Optional<OutletToBeverages> get(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<OutletToBeverages> getAll() {
        return DBs.outletToBeveragesList;
    }

    @Override
    public List<Optional<OutletToBeverages>> getBatch(String id) {
        List<Optional<OutletToBeverages>> outLetBeveragesOptionalList = new ArrayList<>();

        for(OutletToBeverages outletToBeverages : DBs.outletToBeveragesList){
            if(outletToBeverages.getOutletId().equals(id)){
                outLetBeveragesOptionalList.add(Optional.of(outletToBeverages));
            }
        }
        return outLetBeveragesOptionalList;
    }

    @Override
    public void update(OutletToBeverages value) {

    }

    @Override
    public void delete(String id) {

    }
}
