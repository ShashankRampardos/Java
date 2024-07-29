
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import pkg.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main{


    // Method to read showroom data from file

     //methods to handle exception for int input
    public static int getInputInt(Scanner scanner, String prompt) {//below two function handel inputmissmath exception
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                validInput = true; // If no exception, input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        return input;
    }
  //method to handle exception for double input.
    public static double getInputDouble(Scanner scanner, String prompt) {
        double input = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(scanner.nextLine());
                validInput = true; // If no exception, input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid double.");
            }
        }

        return input;
    }

    public static boolean getInputBool(Scanner scanner, String prompt) {
        boolean input = false;

        while (true) {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();
            if (inputStr.equalsIgnoreCase("true") || inputStr.equalsIgnoreCase("false")) {
                input = Boolean.parseBoolean(inputStr);
                break; // Exit loop if input is valid
            } else {
                System.out.println("Invalid input! Please enter 'true' or 'false'.");
            }
        }

        return input;
    }

    //file handling
    public static Showroom initShowroomInfo(String filePath){
        // File path


        try {
            // Create a File object
            File file = new File(filePath);

            // Create a FileReader object
            FileReader fileReader = new FileReader(file);

            // Wrap the FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the line containing the data
            String line = bufferedReader.readLine();

            // Close the BufferedReader
            bufferedReader.close();

            // Process the line containing the data
            if (line != null) {
                // Split the line by "|"
                String[] parts = line.split("\\|");

                // Extract relevant information
                String showroomName = parts[0];
                String showroomAddress = parts[1];
                String manager = parts[2];
               /* int totalCarsInStock = Integer.parseInt(parts[3]);
                int numberOfCustomers = Integer.parseInt(parts[4]);
                int numberOfEmployees = Integer.parseInt(parts[5]);
                int numberOfJanitors = Integer.parseInt(parts[6]);
                int numberOfSalesPerson = Integer.parseInt(parts[7]);
                int numberOfAccountants = Integer.parseInt(parts[8]);*/

                Showroom showroom = new Showroom(showroomName,showroomAddress,manager);
                /*Showroom.setTotalCarsInStock(totalCarsInStock);
                Showroom.setTotalCustomers(numberOfCustomers);
                Showroom.setNumberOfEmployees(numberOfEmployees);
                Showroom.setNumberOfJanitors(numberOfJanitors);
                Showroom.setNumberOfSalesPersons(numberOfSalesPerson);
                Showroom.setNumberOfAccPersons(numberOfAccountants);*/
                return showroom;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Showroom("ABC", "Kurukshetra Haryana", "Bard");
    }

    //method to generate showroom data in a format that we will store in the file.
    public static String generateData(String showroomName, String showroomAddress, String manager,
                                      int totalCarsInStock,int numberOfCustomers, int numberOfEmployees, int numberOfJanitors,
                                      int numberOfSalesPerson, int numberOfAccountants) {
        // Format the data as required
        return showroomName + "|" + showroomAddress + "|" + manager /*+ "|" +
                totalCarsInStock + "|" + numberOfCustomers + "|" + numberOfEmployees + "|" + numberOfJanitors + "|" +
                numberOfSalesPerson + "|" + numberOfAccountants + "|"*/;
    }

     // method to actually store data in file
    public static void storeDataToFile(String data, String filePath) {
        try {
            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(filePath);

            // Wrap the FileWriter in a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the data to the file
            bufferedWriter.write(data);

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //retrieve cars from file
    public static void loadCarsFromFile(Showroom showroom,String filePath) {
        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // make an array list
            ArrayList<Car> carsList = new ArrayList<Car>();
            String line;
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by "|"
                String[] parts = line.split("\\|");

                // Extract information for each car
                String carId = parts[0];
                String brandName = parts[1];
                String color = parts[2];
                String fuelType = parts[3];
                double price = Double.parseDouble(parts[4]);
                String type = parts[5];

                // Create a Car object with the extracted information and add it to the ArrayList
                Car car = new Car(carId, brandName, color, fuelType, price, type);
                carsList.add(car);
            }

           // add all cars that are retrieved from file.
            for(Car car : carsList){
                showroom.addCar(car);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to save all cars information in file
    public static void storeCarsToFile(String filePath, ArrayList<Car> carsList) {
        try {
            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(filePath);

            // Wrap the FileWriter in a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data of each car to the file
            for (Car car : carsList) {
                bufferedWriter.write(car.getId() + "|" + car.getBrandName() + "|" +
                        car.getColor() + "|" + car.getFuelType() + "|" +
                        car.getPrice() + "|" + car.getType() + "\n");
            }

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     // method to load customers from file.
    public static void loadCustomersFromFile(Showroom showroom,String filePath) {
        try {
            // ArrayList to store custommers
            ArrayList<Customer> customersList = new ArrayList<Customer>();
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by "|"
                String[] parts = line.split("\\|");

                // Extract information for each customer
                String name = parts[0];
                //System.out.println("Here" + parts[0] + "Here");     // for debugging
                int age = Integer.parseInt(parts[1]);
                String contact = parts[2];
                String carOwned = parts[3];
                double amountPaid = Double.parseDouble(parts[4]);

                // Create a Customer object with the extracted information and add it to the ArrayList
                Customer customer = new Customer();
                customer.setAll(name, age, contact, carOwned, amountPaid);
                customersList.add(customer);
            }
            for(Customer customer : customersList){
                showroom.addCustomer(customer);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to store customers data to file.
    public static void storeCustomersToFile(String filePath, ArrayList<Customer> customersList) {
        try {
            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(filePath);

            // Wrap the FileWriter in a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data of each customer to the file
            for (Customer customer : customersList) {
                bufferedWriter.write(customer.getName() + "|" + customer.getAge() + "|" +
                        customer.getContact() + "|" + customer.getCarOwned() + "|" +
                        customer.getAmountPaid() + "\n");
            }

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void loadEmployeeFromFile(Showroom showroom,String filePath) {
        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);

            // Wrap the FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // make an array list
            ArrayList<Employee> empList = new ArrayList<Employee>();
            String line;
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by "|"
                String[] parts = line.split("\\|");
                System.out.println(parts[0]+"|"+parts[1]+"|"+parts[2]+"|"+parts[3]+"|"+parts[4]+"|"+parts[5]);

                // Extract information for each Employee
                int empId = Integer.parseInt(parts[0]);
                String empType = parts[1];
                String empName = parts[2];
                int empAge = Integer.parseInt(parts[3]);
                String empExp = parts[4];
                Employee emp = null;
                //here comes the complex part to handle different types of employees

                //if else ladder will initialize a employee object
                if(empType.equalsIgnoreCase("sales person")) {// may be,we can use Tri data structure for similar equality
                   // System.out.println("why you!");
                    emp = new SalesPerson(empId,empName,empAge,empExp);
                    double commission = Double.parseDouble(parts[5]);// it will have commission of double type
                    ((SalesPerson)(emp)).setCommissionRate(commission);//set commission

                }else if(empType.equalsIgnoreCase("accounting person")){
                    //System.out.println("why you!");
                    emp = new AccountingPerson(empId,empName,empAge,empExp);
                    boolean hasCertification = Boolean.parseBoolean(parts[5]);// it will have true or false
                    ((AccountingPerson)(emp)).setCertifiedPublicAccountant(hasCertification);

                }else if(empType.equalsIgnoreCase("janitor")){
                     ///  System.out.println("why you!");
                    emp = new Janitor(empId,empName,empAge,empExp);
                    boolean hasCleaningCertificate = Boolean.parseBoolean(parts[5]);
                    ((Janitor)(emp)).setHasCleaningCertification(hasCleaningCertificate);

                }
                //add this employee to array list
                empList.add(emp);
                System.out.println(emp.getAll());
            }

            // add all cars that are retrieved from file.
            for(Employee emp : empList){
                showroom.addEmployee(emp);
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeEmployeeToFile(String filePath, ArrayList<Employee> employeeList) {
        try {
            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(filePath);

            // Wrap the FileWriter in a BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data of each customer to the file
            for (Employee emp : employeeList) {
                boolean hasCertification = false;
                double commission = -1;

                if(emp.getEmpType().equalsIgnoreCase("sales person")) {// may be we use tri data structure for similar equality

                    commission = ((SalesPerson)(emp)).getCommissionRate();

                }else if(emp.getEmpType().equalsIgnoreCase("accounting person")){

                    hasCertification = ((AccountingPerson)(emp)).isCertifiedPublicAccountant();

                }else if(emp.getEmpType().equalsIgnoreCase("janitor")){

                    hasCertification = ((Janitor)(emp)).hasCleaningCertification();
                    System.out.println("_____"+commission+"______");

                }

                bufferedWriter.write(emp.getEmpId() + "|" + emp.getEmpType() + "|" +
                        emp.getEmpName() + "|" + emp.getEmpAge() + "|" +
                        emp.getEmpExperience() + "|" +
                        ((commission == -1) ? (hasCertification) : commission) + "\n");

            }

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


public static void main(String[] args) {

        //file path where system data stored
    String filePath = "data\\data.txt";
    String filePathForCars = "data\\cars.txt";
    String filePathForCustomers = "data\\customers.txt";
    String filePathForEmployee = "data\\emp.txt";
    Scanner scanner = new Scanner(System.in);
    //initialize showroom basic data
    Showroom showroom = initShowroomInfo(filePath);
    //load cars from file
    loadCarsFromFile(showroom,filePathForCars);
    //load customers from file
    loadCustomersFromFile(showroom,filePathForCustomers);
    //load employees from file
    loadEmployeeFromFile(showroom,filePathForEmployee);

    String workingDir = System.getProperty("user.dir");
    System.out.println("Current working directory: " + workingDir);
   // showroom = readShowroomFromFile("showroom.txt");
    //showroom.addEmployee(new AccountingPerson().setAll(101, "John Doe", 30, "Senior Accountant"));

    int choice = 0;
    do {
        System.out.println("\nCar Showroom System Menu:");
        System.out.println("1. Add Car");
        System.out.println("2. Display Available Cars");
        System.out.println("3. Buy Car");
        System.out.println("4. Add Employee");
        System.out.println("5. Fire Employee");
        System.out.println("6. Display all Employees");
        System.out.println("7. Display all Customers");
        System.out.println("8. Remove a Car");
        System.out.println("9. Remove a Customer");
        System.out.println("10. Display Showroom Details");
        System.out.println("11. Exit");

        boolean forException = false;// it is used for exception handling purpose.

        while (!forException) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                forException = true; // If no exception, input is valid
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.nextLine(); // Consume newline character
        boolean removed;// it is used to remove car, employee
        switch (choice) {
            case 1:
                // Create cars and add them to the showroom
                Car car1 = new Car();
                System.out.println("Enter Car Id:");
                car1.setId(scanner.nextLine());
                System.out.println("Enter brand name:");
                car1.setBrandName(scanner.nextLine());

                System.out.println("Enter color:");
                car1.setColor(scanner.nextLine());

                System.out.println("Enter fuel type:");
                car1.setFuelType(scanner.nextLine());

                double price = 0.0;
                forException = false;

                while (!forException) {
                    try {
                        System.out.println("Enter price:");
                        price = scanner.nextDouble();
                        forException = true; // If no exception, input is valid
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a valid price.");
                        scanner.nextLine(); // Clear the input buffer
                    }
                }
                car1.setPrice(price);
                scanner.nextLine(); // Consume newline character

                System.out.println("Enter type:");
                car1.setType(scanner.nextLine());

                showroom.addCar(car1);

                break;
            case 2:
                forException = false;
                for(Car c : showroom.getCars()){
                    forException= true;
                    System.out.println("-------------------------------------------------");
                   System.out.println(c.getAll());
                    System.out.println("-------------------------------------------------");
                }
                if(!forException){//no car is present at the moment
                    System.out.println("No car is present at the moment");
                }
                break;
            case 3:
                // Create customers and simulate interactions

                System.out.println("Enter car owned by the customer:");
                String carOwned = scanner.nextLine();

                removed = showroom.removeCarByBrandName(carOwned);
                if (removed) {

                    System.out.println("Enter com.Customer Name Age Contact AmountPain");
                    // Read inputs
                    System.out.println("Enter customer name: ");
                    String name = scanner.nextLine();

                    int age = getInputInt(scanner, "Enter customer age: ");

                    System.out.println("Enter customer contact: ");
                    String contact = scanner.nextLine();

// Create com.Customer object
                    Customer customer1 = new Customer();
                    customer1.setName(name);
                    customer1.setAge(age);
                    customer1.setContact(contact);
                    customer1.setCarOwned(carOwned);

// Read amount paid
                    double amountPaid = getInputDouble(scanner, "Enter amount paid: ");
                    customer1.setAmountPaid(amountPaid);

                    showroom.addCustomer(customer1);
                    // Add the customer to the showroom or wherever appropriate

                } else {
                    System.out.println(STR."Car with brand name\{carOwned}not available at the moment.");
                }

                break;
            case 4:

                System.out.println("Select employee type:");
                System.out.println("1. Sales Person");
                System.out.println("2. Accounting Person");
                System.out.println("3. com.Janitor");
                System.out.print("Enter employee type (1/2/3): ");
                int employeeTypeChoice = 0;

                forException = false;
                   // input valid employee type
                while (!forException) {
                    try {
                        System.out.print("Enter the employee type choice: ");
                        employeeTypeChoice = scanner.nextInt();
                        forException = true; // If no exception, input is valid
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter an integer for employee type choice.");
                        scanner.nextLine(); // Clear the input buffer
                    }
                }
                scanner.nextLine(); // Consume newline character

                Employee employee = null;//up casting will be used here
                switch (employeeTypeChoice) {
                    case 1:
                        employee = new SalesPerson();
                        //down casting
                        ((SalesPerson) employee).setCommissionRate(getInputDouble(scanner,"Enter commission rate:"));
                        scanner.nextLine(); // Consume newline character
                        break;
                    case 2:
                        employee = new AccountingPerson();
                        //down casting
                        ((AccountingPerson) employee).setCertifiedPublicAccountant(getInputBool(scanner,"Is certified public accountant? (true/fales):"));
                        scanner.nextLine(); // Consume newline character
                        break;
                    case 3:
                        employee = new Janitor();
                        // down casting
                        ((Janitor) employee).setHasCleaningCertification(getInputBool(scanner,"Has cleaning certification?"));
                        scanner.nextLine(); // Consume newline character
                        break;
                    default:
                        System.out.println("Invalid employee type.");
                        break;
                }


                if (employee != null) {
                    int id = getInputInt(scanner,"Enter employee ID: "); // Read ID
                    System.out.print("Enter employee Name: ");
                    String name = scanner.nextLine(); // Read Name
                    int age = getInputInt(scanner,"Enter employee Age: "); // Read Age
                    System.out.print("Enter employee Experience: ");
                    String experience = scanner.nextLine(); // Read Experience

                    employee.setAll(id, name, age, experience);

                    showroom.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                }

                break;

            case 5:
                //fire employee or remove from showroom.

                int empId = getInputInt(scanner,"Enter employee ID:");
                scanner.nextLine(); // Consume newline character

                removed = showroom.removeEmployeeById(empId);
                if (removed) {
                    System.out.println(STR."com.Employee with ID \{empId} removed successfully.");
                } else {
                    System.out.println(STR."com.Employee with ID \{empId} not found.");
                }
                break;
            case 6:
                forException = false;
                for(Employee e : showroom.getEmployees()){
                    forException = true;
                    System.out.println("-------------------------------------------------");
                    System.out.println(e.getAll());
                    System.out.println("-------------------------------------------------");
                }
                if(!forException){
                    System.out.println("No Employee availbale at a moment.");
                }
                break;
            case 7:
                    for(Customer c : showroom.getCustomers()){
                    System.out.println("-------------------------------------------------");
                    System.out.println(c.getAll());
                    System.out.println("-------------------------------------------------");
                    }
                    if(showroom.getCustomers().isEmpty()){
                        System.out.println("No Customers at the moment.");
                    }
                break;
            case 8:
                System.out.println("Enter car name to remove:");
                String carRemove = scanner.nextLine();

                removed = showroom.removeCarByBrandName(carRemove);
                if (removed) {
                    System.out.println(STR."One model of \{carRemove} removed from Showroom");
                } else {
                    System.out.println(STR."Car with brand name\{carRemove}not present.");
                }
               break;
            case 9:
                System.out.println("Enter Customer contact to remove:");
                String customerRemove = scanner.nextLine();

                removed = showroom.removeCustomerByContact(customerRemove);
                if (removed) {
                    System.out.println(STR."com.Customer with contact: \{customerRemove} removed from com.Showroom");
                } else {
                    System.out.println(STR."com.Customer with contact \{customerRemove} not present.");
                }
                break;
            case 10:
                // Display showroom details
                System.out.println(STR."Showroom Name: \{showroom.getShowroomName()}");
                System.out.println(STR."Showroom Address: \{showroom.getShowroomAddress()}");
                System.out.println(STR."Manager: \{showroom.getManagerName()}");
                System.out.println(STR."Total Cars in Stock: \{Showroom.getTotalCarsInStock()}");
                System.out.println(STR."Total Customers: \{Showroom.getTotalCustomers()}");
                System.out.println(STR."Number of Employees: \{Showroom.getNumberOfEmployees()}");
                System.out.println(STR."Number of Janitors: \{Showroom.getNumberOfJanitors()}");
                System.out.println(STR."Number of SalesPerson: \{Showroom.getNumberOfSalesPersons()}");
                System.out.println(STR."Number of Accountant: \{Showroom.getNumberOfAccPersons()}");
                break;
            case 11:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 11);


     // storing showroom basic data to file
     storeDataToFile(generateData(showroom.getShowroomName(),showroom.getShowroomAddress(),
             showroom.getManagerName(),Showroom.getTotalCarsInStock(),Showroom.getTotalCustomers(),
             Showroom.getNumberOfEmployees(),Showroom.getNumberOfJanitors(),Showroom.getNumberOfSalesPersons(),
             Showroom.getNumberOfAccPersons()), filePath);

     // store/save showroom cars in a file
     storeCarsToFile(filePathForCars,showroom.getCars());
     // store/save showroom Customers in a file
     storeCustomersToFile(filePathForCustomers,showroom.getCustomers());
     //store/save showroom Employees in a file
    storeEmployeeToFile(filePathForEmployee,showroom.getEmployees());

    scanner.close();
}
}