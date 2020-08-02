package db;

/**
 * For maintaining relationShip of outlet and beverage
 */
public class OutletToBeverages {
    private String outletId;
    private String beverageId;

    public OutletToBeverages(String outletId, String beverageId) {
        this.outletId = outletId;
        this.beverageId = beverageId;
    }

    @Override
    public String toString() {
        return "OutletToBeverages{" +
                "outletId='" + outletId + '\'' +
                ", beverageId='" + beverageId + '\'' +
                '}';
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(String beverageId) {
        this.beverageId = beverageId;
    }
}