package pkg;

public class Car {

    // Private properties
    private String carId;
    private String brandName;
    private String color;
    private String fuelType;
    private double price;
    private String type;

    //constructor

    // Constructor
    public Car(){

    }
    public Car(String carId, String brandName, String color, String fuelType, double price, String type) {
        this.carId = carId;
        this.brandName = brandName;
        this.color = color;
        this.fuelType = fuelType;
        this.price = price;
        this.type = type;
    }
    public void setId(String id){
        this.carId = id;
    }
    public String getId(){
        return this.carId;
    }
    // Getter and setter methods for brandName
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    // Getter and setter methods for modelName


    // Getter and setter methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter and setter methods for fuelType
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Getter and setter methods for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and setter methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Method to set all properties at once
    public void setAll(String brandName, String modelName, String color, String fuelType, double price, String type) {
        this.brandName = brandName;
        this.color = color;
        this.fuelType = fuelType;
        this.price = price;
        this.type = type;
    }

    // Method to get all properties as an array
//    public String[] getAll() {
//        return new String[]{brandName, modelName, color, fuelType, String.valueOf(price), type};
//    }
    // Method to get all properties as a formatted string
    public String getAll() {
        return toString();
    }
    @Override
    public String toString() {
        return "com.Car{" +
                "brandName='" + brandName + '\'' +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
