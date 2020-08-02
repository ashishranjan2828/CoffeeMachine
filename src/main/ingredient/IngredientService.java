package ingredient;

import dbDAO.IDAO;
import dbDAO.IngredientsDAO;
import model.Ingredients;

import java.util.Optional;

/**
 * All interactions related to ingredient is handled here
 *
 */

public class IngredientService {
    private volatile static IngredientService instance = null;
    private IDAO<Ingredients> ingredientsIDAO;

    private IngredientService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
        ingredientsIDAO = IngredientsDAO.getInstance();
    }

    public static IngredientService getInstance() {

        if(instance==null) {
            synchronized (IngredientService.class) {

                if(instance==null) {
                    instance = new IngredientService();
                }

            }
        }

        return instance;
    }

    public void registerIngredient(Ingredients ingredients){
        ingredientsIDAO.create(ingredients);

    }

    public Ingredients getIngredients(String ingredientId){
        Optional<Ingredients> ingredientsOptional = ingredientsIDAO.get(ingredientId);
        return ingredientsOptional.orElse(null);
    }

    public void updateIngredients(Ingredients ingredients){
        ingredientsIDAO.update(ingredients);
    }

}
