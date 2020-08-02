package model;

public class Response {
    String outletId;
    BeverageStatus beverageStatus;

    public Response(String outletId, BeverageStatus beverageStatus) {
        this.outletId = outletId;
        this.beverageStatus = beverageStatus;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public BeverageStatus getBeverageStatus() {
        return beverageStatus;
    }

    public void setBeverageStatus(BeverageStatus beverageStatus) {
        this.beverageStatus = beverageStatus;
    }

    @Override
    public String toString() {
        return "Response{" +
                "outletId='" + outletId + '\'' +
                ", beverageStatus=" + beverageStatus +
                '}';
    }
}
