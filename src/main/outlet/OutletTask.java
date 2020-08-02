package outlet;

import beverage.BeverageService;
import display.DisplayService;
import ingredient.IngredientService;
import model.BeverageStatus;
import model.Beverages;
import model.Ingredients;
import model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * It is a single unit task which is performed in the outlet thread pool
 * This task has the business logic of serving the beverages
 */

public class OutletTask implements Runnable {
    private String outletId;
    private String beverageId;
    private final List<String> sharedIngredientListInOutlet;

    public OutletTask(String outletId, String beverageId, List<String> sharedIngredientListInOutlet) {
        this.outletId = outletId;
        this.beverageId = beverageId;
        this.sharedIngredientListInOutlet = sharedIngredientListInOutlet;
    }

    @Override
    public String toString() {
        return "OutletTask{" +
                "beverageId='" + beverageId + '\'' +
                ", sharedIngredientListInOutlet=" + sharedIngredientListInOutlet +
                '}';
    }

    @Override
    public void run() {
        Response response;

        Beverages beverageDetail = BeverageService.getInstance().getBeverageDetails(beverageId);
        List<Ingredients> beverageIngredientsList = beverageDetail.getIngredientsList();

        synchronized (sharedIngredientListInOutlet){
            Map<String, Ingredients> outletIngredientsMap = new HashMap<>();
            String ingredientShortage = null;
            boolean isIngredientAvailable = true;
            for(Ingredients beverageIngredient :  beverageIngredientsList){
                Ingredients ingredientInOutlet = IngredientService.getInstance().getIngredients(beverageIngredient.getIngredientsId());

                if(ingredientInOutlet==null){
                    ingredientShortage = beverageIngredient.getIngredientsName();
                    isIngredientAvailable = false;
                    break;
                }

                if(ingredientInOutlet.getQuantity() < beverageIngredient.getQuantity() && ingredientShortage==null){
                    ingredientShortage = beverageIngredient.getIngredientsName();
                }

                outletIngredientsMap.put(ingredientInOutlet.getIngredientsName(), ingredientInOutlet);
            }

            if(ingredientShortage!=null){
                response = new Response(outletId, new BeverageStatus(beverageDetail.getBeverageName(), false,
                        ingredientShortage, isIngredientAvailable));
            } else {

                for(Ingredients beverageIngredient : beverageIngredientsList){
                    Ingredients ingredient = outletIngredientsMap.get(beverageIngredient.getIngredientsName());
                    ingredient.setQuantity(ingredient.getQuantity() - beverageIngredient.getQuantity());
                    IngredientService.getInstance().updateIngredients(ingredient);
                }

                response = new Response(outletId, new BeverageStatus(beverageDetail.getBeverageName(), true,
                        ingredientShortage, isIngredientAvailable));
            }
        }

        DisplayService.getInstance().displayResponse(response);
    }
}
