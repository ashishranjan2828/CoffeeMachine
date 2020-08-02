package outlet;

import display.DisplayService;
import model.Outlet;
import model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Process outlet beverages
 * It decides the parallelProcessingPower power of outlet by number of machines
 * Creates a thread pool with number of thread equals to parallelProcessingPower
 * submits the outlet task to these pool for parallel processing
 */

public class OutletProcessor{

    private Outlet outletDetails;
    private Integer parallelProcessingPower;
    private ExecutorService executorService;

    public OutletProcessor(Outlet outletDetails, Integer parallelProcessingPower) {
        this.outletDetails = outletDetails;
        this.parallelProcessingPower = parallelProcessingPower;
        this.executorService = Executors.newFixedThreadPool(parallelProcessingPower);
    }

    public void process() {

        List<String> listOfBeverages = OutletService.getInstance().getAllBeverageRelatedToOutlet(outletDetails.getOutletName());
        List<String> listOfIngredientId = OutletService.getInstance().getAllIngredientsRelatedToOutlet(outletDetails.getOutletName());

        List<Future<Response>> responseFutureList = new ArrayList<>();

        for(String beverageId : listOfBeverages){
            responseFutureList.add(executorService.submit(new OutletTask(outletDetails.getOutletName(), beverageId, listOfIngredientId)));
        }

        try {
            List<Response> responseList = new ArrayList<>();
            for (Future<Response> futureResponse : responseFutureList){
                responseList.add(futureResponse.get());
            }
            DisplayService.getInstance().displayResponse(responseList);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
