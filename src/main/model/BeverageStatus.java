package model;

public class BeverageStatus {
    String beverageName;
    Boolean isPrepared;

    String ingredient;
    boolean isIngredientAvailable;

    public BeverageStatus(String beverageName, Boolean isPrepared, String ingredient, boolean isIngredientAvailable) {
        this.beverageName = beverageName;
        this.isPrepared = isPrepared;
        this.ingredient = ingredient;
        this.isIngredientAvailable = isIngredientAvailable;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public Boolean getPrepared() {
        return isPrepared;
    }

    public void setPrepared(Boolean prepared) {
        isPrepared = prepared;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public boolean isIngredientAvailable() {
        return isIngredientAvailable;
    }

    public void setIngredientAvailable(boolean ingredientAvailable) {
        isIngredientAvailable = ingredientAvailable;
    }

}
