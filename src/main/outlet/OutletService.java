package outlet;

import db.OutletToBeverages;
import db.OutletToIngredients;
import dbDAO.IDAO;
import dbDAO.OutLetDAO;
import dbDAO.OutletToBeveragesDAO;
import dbDAO.OutletToIngredientDAO;
import ingredient.IngredientService;
import model.Ingredients;
import model.Outlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Outlet service which handles the task related to outlet
 * It performs the action of serving the beverages to people
 * registration of outlet, maintaining relationsShip with beverage, serving of beverages etcs are maintained here
 */

public class OutletService {
    private volatile static OutletService instance = null;

    private IDAO<Outlet> outletIDAO;
    private IDAO<OutletToIngredients> outletToIngredientsIDAO;
    private IDAO<OutletToBeverages> outletToBeveragesIDAO;
    private IngredientService ingredientService;

    private OutletService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
        outletIDAO = OutLetDAO.getInstance();
        outletToIngredientsIDAO = OutletToIngredientDAO.getInstance();
        outletToBeveragesIDAO = OutletToBeveragesDAO.getInstance();
        ingredientService = IngredientService.getInstance();
    }

    public static OutletService getInstance() {

        if(instance==null) {
            synchronized (OutletService.class) {

                if(instance==null) {
                    instance = new OutletService();
                }

            }
        }

        return instance;
    }

    public void registerOutlet(Outlet outlet){
        outletIDAO.create(outlet);
    }

    public Optional<Outlet> getOutlet(String outletId){
        return outletIDAO.get(outletId);
    }

    public void registerIngredientWithOutlet(String outletId, String ingredientId){
        outletToIngredientsIDAO.create(new OutletToIngredients(outletId, ingredientId));
    }

    public void registerBeverageWithOutlet(String outletId, String beverageId){
        outletToBeveragesIDAO.create(new OutletToBeverages(outletId, beverageId));
    }

    public List<String> getAllBeverageRelatedToOutlet(String outletId){
        List<String> beverageIds = new ArrayList<>();
        for(Optional<OutletToBeverages> entry : outletToBeveragesIDAO.getBatch(outletId)){
            entry.ifPresent(outletToBeverages -> beverageIds.add(outletToBeverages.getBeverageId()));
        }
        return beverageIds;
    }

    public List<String> getAllIngredientsRelatedToOutlet(String outletId){
        List<String> ingredientIds = new ArrayList<>();

        for(Optional<OutletToIngredients> entry : outletToIngredientsIDAO.getBatch(outletId)){
            entry.ifPresent(outletToIngredients -> ingredientIds.add(outletToIngredients.getIngredientId()));
        }
        return ingredientIds;
    }

    public Ingredients getIngredientsRelatedToOutlet(String outletId, String ingredientId){
        List<String> ingredientIds = getAllIngredientsRelatedToOutlet(outletId);
        for(String ingredientIdsOfOutlet : ingredientIds){
            if(ingredientIdsOfOutlet.equals(ingredientId)){
                return IngredientService.getInstance().getIngredients(ingredientId);
            }
        }
        return null;
    }

    public void serve(){
        List<Outlet> listOfOutlet = (List<Outlet>) outletIDAO.getAll();
        for(Outlet outlet : listOfOutlet){
            OutletProcessor outletProcessor = new OutletProcessor(outlet, outlet.getMachineCounts());
            outletProcessor.process();
        }
    }
}
