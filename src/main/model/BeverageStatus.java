package model;

public class BeverageStatus {
    String beverageName;
    Boolean isPrepared;

    public BeverageStatus(String beverageName, Boolean isPrepared) {
        this.beverageName = beverageName;
        this.isPrepared = isPrepared;
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

    @Override
    public String toString() {
        return "BeverageStatus{" +
                "beverageName='" + beverageName + '\'' +
                ", isPrepared=" + isPrepared +
                '}';
    }
}
