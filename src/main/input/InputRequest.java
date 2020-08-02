package input;

import model.Beverages;
import model.Ingredients;

import java.util.List;

public class InputRequest {
    private List<Beverages> beverages;
    private List<Ingredients> ingredients;
    private Integer totalOutlets;

    public InputRequest(List<Beverages> beverages, List<Ingredients> ingredients, Integer totalOutlets) {
        this.beverages = beverages;
        this.ingredients = ingredients;
        this.totalOutlets = totalOutlets;
    }

    public List<Beverages> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverages> beverages) {
        this.beverages = beverages;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getTotalOutlets() {
        return totalOutlets;
    }

    public void setTotalOutlets(Integer totalOutlets) {
        this.totalOutlets = totalOutlets;
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "beverages=" + beverages +
                ", ingredients=" + ingredients +
                ", totalOutlets=" + totalOutlets +
                '}';
    }
}
