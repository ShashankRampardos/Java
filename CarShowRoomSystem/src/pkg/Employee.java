package pkg;

public class Employee {
    // Private properties
    private int empId;
    private String empType;
    private String empName;
    private int empAge;
    private String empExperience;

    public Employee(int i, String s, int i1, String s1) {
        this.empId = i;
        this.empName = s;
        this.empAge = i1;
        this.empExperience = s1;
    }
    public Employee(){

    }

    public String getEmpType(){
        return empType;
    }
    public void setEmpType(String type){
        empType = type;
    }

    // Getter and setter methods for empId
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    // Getter and setter methods for empName
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    // Getter and setter methods for empAge
    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    // Getter and setter methods for empExperience
    public String getEmpExperience() {
        return empExperience;
    }

    public void setEmpExperience(String empExperience) {
        this.empExperience = empExperience;
    }

    // Method to set all properties at once
    public void setAll(int empId, String empName, int empAge, String empExperience) {
        if(this instanceof AccountingPerson){
            setEmpType("Accounting Person");
        }else if(this instanceof SalesPerson){
            setEmpType("Sales Person");
        }else if(this instanceof Janitor){
            setEmpType("Janitor");
        }
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empExperience = empExperience;
    }

    // Method to get all properties as a formatted string
    public String getAll() {
        return toString();
    }

    @Override
    public String toString() {
        String result = "Employee{" +
                "EmpType='"+empType+ '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empExperience='" + empExperience + '\'';

        // Check if the instance is a SalesPerson and include commissionRate
        if (this instanceof SalesPerson) {
            SalesPerson salesPerson = (SalesPerson) this;
            result += ", commissionRate=" + salesPerson.getCommissionRate();
        }

        // Check if the instance is a Janitor and include hasCleaningCertification
        if (this instanceof Janitor) {
            Janitor janitor = (Janitor) this;
            result += ", hasCleaningCertification=" + janitor.hasCleaningCertification();
        }

        // Check if the instance is an AccountingPerson and include certifiedPublicAccountant
        if (this instanceof AccountingPerson) {
            AccountingPerson accountingPerson = (AccountingPerson) this;
            result += ", certifiedPublicAccountant=" + accountingPerson.isCertifiedPublicAccountant();
        }

        result += '}';
        return result;
    }
}
