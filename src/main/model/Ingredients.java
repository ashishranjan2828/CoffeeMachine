package model;

public class Ingredients {
    private String ingredientsId;
    private String ingredientsName;
    private Double quantity;

    public Ingredients(String ingredientsName, Double quantity) {
        this.ingredientsId = ingredientsName;
        this.ingredientsName = ingredientsName;
        this.quantity = quantity;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(String ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientsName='" + ingredientsName + '\'' +
                ", ingredientsId='" + ingredientsId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
