package coffee;

import beverage.BeverageService;
import ingredient.IngredientService;
import input.InputRequest;
import model.Beverages;
import model.Ingredients;
import model.Outlet;
import outlet.OutletService;

import static commons.Constants.DEFAULT_OUTLET_NAME;

/**
 * Application layer
 * It interacts with all the components like outlet, beverage, ingredient
 */
public class CoffeeService {
    private volatile static CoffeeService instance = null;

    OutletService outletService;
    IngredientService ingredientService;
    BeverageService beverageService;

    private CoffeeService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
        outletService = OutletService.getInstance();
        ingredientService = IngredientService.getInstance();
        beverageService = BeverageService.getInstance();
    }

    public static CoffeeService getInstance() {

        if(instance==null) {
            synchronized (CoffeeService.class) {

                if(instance==null) {
                    instance = new CoffeeService();
                }

            }
        }

        return instance;
    }

    public void processInputRequest(InputRequest inputRequest){
        registerOutlet(new Outlet(DEFAULT_OUTLET_NAME, inputRequest.getTotalOutlets()));

        if(inputRequest.getBeverages()!=null){
            for(Beverages beverages : inputRequest.getBeverages()){
                registerBeverage(beverages);
                registerBeverageWithOutlet(DEFAULT_OUTLET_NAME, beverages.getBeverageName());
            }
        }

        if(inputRequest.getIngredients()!=null){
            for(Ingredients ingredients : inputRequest.getIngredients()){
                registerIngredient(ingredients);
                registerIngredientWithOutlet(DEFAULT_OUTLET_NAME, ingredients.getIngredientsName());
            }
        }
    }

    public void registerOutlet(Outlet outlet){
        outletService.registerOutlet(outlet);
    }

    public void registerBeverage(Beverages beverages){
        beverageService.registerBeverage(beverages);
    }

    public void registerBeverageWithOutlet(String outletId, String beverageId){
        outletService.registerBeverageWithOutlet(outletId, beverageId);
    }
    public void registerIngredient(Ingredients ingredients){
        ingredientService.registerIngredient(ingredients);
    }

    public void registerIngredientWithOutlet(String outletId, String ingredientId){
        outletService.registerIngredientWithOutlet(outletId, ingredientId);
    }

    public void serve(InputRequest inputRequest) {
        processInputRequest(inputRequest);
        outletService.serve();
    }

}
