
package az.project.entity;

public class Customer {
   private int customer_id;
   private String fullName;
   private String phone;

    public Customer() {
    }

    public Customer(int customer_id) {
        this.customer_id = customer_id;
    }

    public Customer(int customer_id, String fullName, String phone) {
        this.customer_id = customer_id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", fullName=" + fullName + ", phone=" + phone + '}';
    }
   
   
   
}
