package display;

import model.Response;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service to display responses after performing certain operations like preparation of beverages
 */

public class DisplayService {

    private volatile static DisplayService instance = null;

    private DisplayService() {
        if(instance!=null) {
            throw new RuntimeException("error");
        }
    }

    public static DisplayService getInstance() {

        if(instance==null) {
            synchronized (DisplayService.class) {

                if(instance==null) {
                    instance = new DisplayService();
                }

            }
        }

        return instance;
    }

    public void displayResponse(Response response){

        if(response.getBeverageStatus().getPrepared()){
            System.out.println(response.getBeverageStatus().getBeverageName() + " is prepared");
        } else if(response.getBeverageStatus().isIngredientAvailable()){
            System.out.println(response.getBeverageStatus().getBeverageName() + " cannot be prepared because " +
                    response.getBeverageStatus().getIngredient() + " is not sufficient");
        } else{
            System.out.println(response.getBeverageStatus().getBeverageName() + " cannot be prepared because " +
                    response.getBeverageStatus().getIngredient() + " is not available");
        }
    }

}
