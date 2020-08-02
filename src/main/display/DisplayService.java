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
            System.out.println("beverage: " + response.getBeverageStatus().getBeverageName() + " is ready, pls take from counter");
        } else {
            System.out.println("unable to process beverage " + response.getBeverageStatus().getBeverageName());
        }
    }


    public void displayResponse(List<Response> response){
        List<Response> processedResponse = response.stream()
                .filter(response1 -> response1.getBeverageStatus().getPrepared()).collect(Collectors.toList());
        List<Response> unprocessedResponse = response.stream()
                .filter(response1 -> !response1.getBeverageStatus().getPrepared()).collect(Collectors.toList());

        processedResponse.forEach(x -> displayResponse(x));
        unprocessedResponse.forEach(x -> displayResponse(x));
    }
}
