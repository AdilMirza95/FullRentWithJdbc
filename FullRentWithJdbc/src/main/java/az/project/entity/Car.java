
package az.project.entity;

public class Car {
    private int car_id;
    private String brand;
    private String model;
    private int year;
    private int dayOfPrice;    
    private Customer customer;
    private Category category;

    public Car() {
    }

    public Car(int car_id) {
        this.car_id = car_id;
    }

    public Car(int car_id, String brand, String model, int year, int dayOfPrice, Customer customer, Category category) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dayOfPrice = dayOfPrice;
        this.customer = customer;
        this.category= category;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDayOfPrice() {
        return dayOfPrice;
    }

    public void setDayOfPrice(int dayOfPrice) {
        this.dayOfPrice = dayOfPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer_id(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory_id(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Car{" + "car_id=" + car_id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", dayOfPrice=" + dayOfPrice + ", customer=" + customer + ", category=" + category + '}';
    }
    
    
    
    
}
