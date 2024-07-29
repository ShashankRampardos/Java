package pkg;

public class SalesPerson extends Employee {
    private static int totalSalesPerson;

    public SalesPerson(int i, String s, int i1, String s1) {
        super(i, s, i1, s1);
        this.setEmpType("Sales Person");// in same format file will be stored and retrieved (case in-sensitive)
    }
    public SalesPerson(){
        super();
    }

    private double commissionRate;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }


    public static int getTotalSalesPerson() {
        return totalSalesPerson;
    }

    public static void setTotalSalesPerson(int totalSalesPerson) {
        SalesPerson.totalSalesPerson = totalSalesPerson;
    }
}