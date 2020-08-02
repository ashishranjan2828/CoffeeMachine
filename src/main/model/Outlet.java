package model;

public class Outlet {
    private String outletName;
    private Integer machineCounts;

    public Outlet(String outletName, Integer machineCounts) {
        this.outletName = outletName;
        this.machineCounts = machineCounts;
    }

    @Override
    public String toString() {
        return "Outlet{" +
                "outletName='" + outletName + '\'' +
                ", machineCounts=" + machineCounts +
                '}';
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public Integer getMachineCounts() {
        return machineCounts;
    }

    public void setMachineCounts(Integer machineCounts) {
        this.machineCounts = machineCounts;
    }
}
