package pkg;

public class Customer {
    // Private properties
    private String name;
    private int age;
    private String contact;
    private String carOwned;
    private double amountPaid;

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter methods for contact
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Getter and setter methods for carOwned
    public String getCarOwned() {
        return carOwned;
    }

    public void setCarOwned(String carOwned) {
        this.carOwned = carOwned;
    }

    // Getter and setter methods for amountPaid
    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    // Method to set all properties at once
    public void setAll(String name, int age, String contact, String carOwned, double amountPaid) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.carOwned = carOwned;
        this.amountPaid = amountPaid;
    }


    // Method to get all properties as a formatted string
    public String getAll() {
        return toString();
    }

    @Override
    public String toString() {
        return "com.Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", carOwned='" + carOwned + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
