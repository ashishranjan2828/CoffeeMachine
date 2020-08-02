package beverage;

import dbDAO.BeverageDAO;
import dbDAO.IDAO;
import model.Beverages;

import java.util.Optional;

/**
 * Service which performs actions related to beverages
 * like CRUD operations on beverage data
 */
public class BeverageService {

    private volatile static BeverageService instance = null;
    private IDAO<Beverages> beveragesIDAO;

    private BeverageService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
        beveragesIDAO = BeverageDAO.getInstance();
    }

    public static BeverageService getInstance() {

        if(instance==null) {
            synchronized (BeverageService.class) {

                if(instance==null) {
                    instance = new BeverageService();
                }

            }
        }

        return instance;
    }

    public void registerBeverage(Beverages beverages){
        beveragesIDAO.create(beverages);
    }

    public Beverages getBeverageDetails(String beverageId){
        Optional<Beverages> beverages = beveragesIDAO.get(beverageId);
        return beverages.orElse(null);
    }
}
