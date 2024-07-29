package pkg;

import java.util.ArrayList;

public class Showroom {
    // Properties
    private ArrayList<Car> cars;
    private ArrayList<Employee> employees;
    private ArrayList<Customer> customers; // New property for storing customer information
    private String showroomName;
    private String showroomAddress;
    private static int totalCarsInStock;
    private static int numberOfEmployees;
    private static int totalCustomers; // New property to track the total number of customers
    private String managerName;

    // Constructor
    public Showroom(String showroomName, String showroomAddress, String managerName) {
        this.showroomName = showroomName;
        this.showroomAddress = showroomAddress;
        this.managerName = managerName;
        this.cars = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>(); // Initialize the customers ArrayList
    }

    // Getter and setter methods for cars
    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    // Method to add a single car to the showroom
    public void addCar(Car car) {
        cars.add(car);
        totalCarsInStock++;
    }

    // Getter and setter methods for employees
    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    // Method to add a single employee to the showroom
    public void addEmployee(Employee employee) {
        employees.add(employee);//adding in array list of employee
        numberOfEmployees++;//incrementing number of emmlyees
        //incrementing specific type of employee
        if(employee instanceof AccountingPerson){
            AccountingPerson.setTotalAccPerson(AccountingPerson.getTotalAccPerson()+1);
        }else if(employee instanceof SalesPerson){
            SalesPerson.setTotalSalesPerson(SalesPerson.getTotalSalesPerson()+1);
        }else if(employee instanceof Janitor){
            Janitor.setTotalJanitor(Janitor.getTotalJanitor()+1);
        }
    }

    // Getter and setter methods for customers
    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    // Method to add a single customer to the showroom
    public void addCustomer(Customer customer) {
        customers.add(customer);
        totalCustomers++;
    }

    // Getter and setter methods for showroomName
    public String getShowroomName() {
        return showroomName;
    }

    public void setShowroomName(String showroomName) {
        this.showroomName = showroomName;
    }

    // Getter and setter methods for showroomAddress
    public String getShowroomAddress() {
        return showroomAddress;
    }

    public void setShowroomAddress(String showroomAddress) {
        this.showroomAddress = showroomAddress;
    }

    // Getter and setter methods for totalCarsInStock
    public static int getTotalCarsInStock() {
        return totalCarsInStock;
    }

    public static void setTotalCarsInStock(int totalCarsInStock) {
        Showroom.totalCarsInStock = totalCarsInStock;
    }

    // Getter and setter methods for numberOfEmployees and their types.
    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public static int getNumberOfJanitors(){
        return Janitor.getTotalJanitor();
    }

    public static int getNumberOfSalesPersons(){
        return SalesPerson.getTotalSalesPerson();
    }

    public static int getNumberOfAccPersons(){
        return AccountingPerson.getTotalAccPerson();
    }
    public static void setNumberOfEmployees(int numberOfEmployees) {
        Showroom.numberOfEmployees = numberOfEmployees;
    }
    public static void setNumberOfJanitors(int num){
        Janitor.setTotalJanitor(num);
    }
    public static void setNumberOfAccPersons(int num){
        AccountingPerson.setTotalAccPerson(num);
    }
    public static void setNumberOfSalesPersons(int num){
        SalesPerson.setTotalSalesPerson(num);
    }
    // Getter and setter methods for totalCustomers
    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public static void setTotalCustomers(int totalCustomers) {
        Showroom.totalCustomers = totalCustomers;
    }

    // Getter and setter methods for managerName
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public boolean removeCarByBrandName(String brandName) {
        // Iterate through the list of cars
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            // If the car's brand name matches the input brand name
            if (car.getBrandName().equalsIgnoreCase(brandName)) {
                // Remove the car from the list
                cars.remove(i);
                // Decrement totalCarsInStock
                totalCarsInStock--;
                // Return true to indicate that the car was found and removed
                return true;
            }
        }
        // If the car with the specified brand name is not found
        return false;
    }

    public boolean removeEmployeeById(int empId) {
        // Iterate through the list of employees
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            // If the employee's ID matches the input employee ID
            if (employee.getEmpId() == empId) {
                // Remove the employee from the list
                employees.remove(i);
                // Decrement numberOfEmployees
                numberOfEmployees--;

                //decrement specific type of employee
                if(employee instanceof AccountingPerson){
                    AccountingPerson.setTotalAccPerson(AccountingPerson.getTotalAccPerson()-1);
                }else if(employee instanceof SalesPerson){
                    SalesPerson.setTotalSalesPerson(SalesPerson.getTotalSalesPerson()-1);
                }else if(employee instanceof Janitor){
                    Janitor.setTotalJanitor(Janitor.getTotalJanitor()-1);
                }
                // Return true to indicate that the employee was found and removed
                return true;
            }
        }
        // Return false if the employee with the given ID was not found
        return false;
    }

    public boolean removeCustomerByContact(String contact) {
        // Iterate through the list of customers
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            // If the customer's contact matches the input contact
            if (customer.getContact().equalsIgnoreCase(contact)) {
                // Remove the customer from the list
                customers.remove(i);
                // Decrement totalCustomers
                totalCustomers--;
                // Return true to indicate that the customer was found and removed
                return true;
            }
        }
        // Return false if the customer with the given contact was not found
        return false;
    }

    public boolean removeCarById(String id) {
        // Iterate through the list of cars
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            // If the car's id matches the input brand name
            if (car.getId().equalsIgnoreCase(id)) {
                // Remove the car from the list
                cars.remove(i);
                // Decrement totalCarsInStock
                totalCarsInStock--;
                // Return true to indicate that the car was found and removed
                return true;
            }
        }
        //Return false if the car with given id is not present
        return false;
    }


/*

// it is deleting all instance which matches search key so its not a solution we have to make manual search function
    public boolean removeCarByBrandName(String brandName) {
        boolean removed = cars.removeIf(car -> car.getBrandName().equalsIgnoreCase(brandName));

        if (removed) {
            totalCarsInStock--;
        }

        return removed;
    }

    public boolean removeEmployeeById(int empId) {
        boolean removed = employees.removeIf(employee -> employee.getEmpId() == empId);

        if (removed) {
            numberOfEmployees -= removed ? 1 : 0;
        }

        return removed;
    }

    public boolean removeCustomerByContact(String contact) {
        boolean removed = customers.removeIf(customer -> customer.getContact().equalsIgnoreCase(contact));

        if (removed) {
            totalCustomers -= removed ? 1 : 0;
        }

        return removed;
}
*/

}


