package db;

/**
 * For maintaining relationShip of outlet and ingredients
 */

public class OutletToIngredients {
    private String outletId;
    private String ingredientId;

    public OutletToIngredients(String outletId, String ingredientId) {
        this.outletId = outletId;
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString() {
        return "OutletToIngredients{" +
                "outletId='" + outletId + '\'' +
                ", ingredientId='" + ingredientId + '\'' +
                '}';
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }
}
