package model;

import java.util.List;

public class Beverages {
    private String beverageName;
    private List<Ingredients> ingredientsList;

    public Beverages(String beverageName, List<Ingredients> ingredientsList) {
        this.beverageName = beverageName;
        this.ingredientsList = ingredientsList;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    @Override
    public String toString() {
        return "Beverages{" +
                "beverageName='" + beverageName + '\'' +
                ", ingredientsList=" + ingredientsList +
                '}';
    }
}
