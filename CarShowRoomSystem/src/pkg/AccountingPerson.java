package pkg;

public class AccountingPerson extends Employee {
    private static int totalAccPerson;

    public AccountingPerson(int i, String s, int i1, String s1) {
        super(i, s, i1, s1);
        this.setEmpType("Accounting Person");//same format needs to be maintain for proper file handling (case in-sensitive)
    }
    public AccountingPerson(){
        super();
    }

    public static int getTotalAccPerson() {
        return totalAccPerson;
    }

    public static void setTotalAccPerson(int totalAccPerson) {
        AccountingPerson.totalAccPerson = totalAccPerson;
    }

    private boolean certifiedPublicAccountant;

    public boolean isCertifiedPublicAccountant() {
        return certifiedPublicAccountant;
    }

    public void setCertifiedPublicAccountant(boolean certifiedPublicAccountant) {
        this.certifiedPublicAccountant = certifiedPublicAccountant;
    }

}