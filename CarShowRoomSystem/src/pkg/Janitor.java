package pkg;

public class Janitor extends Employee {
    private static int totalJanitor;

    public static int getTotalJanitor() {
        return totalJanitor;
    }

    public static void setTotalJanitor(int totalJanitor) {
        Janitor.totalJanitor = totalJanitor;
    }
    public Janitor(int i, String s, int i1, String s1) {
        super(i, s, i1, s1);
        this.setEmpType("Janitor");
    }
    public Janitor(){
        super();
    }
    private boolean hasCleaningCertification;

    public boolean hasCleaningCertification() {
        return hasCleaningCertification;
    }

    public void setHasCleaningCertification(boolean hasCleaningCertification) {
        this.hasCleaningCertification = hasCleaningCertification;
    }

}