
package az.project.Dao.Inter;

import az.project.entity.Customer;
import java.util.List;

public interface CustomerDaoInter {
    void update(Customer cust);
    void insert(Customer cust);
    void delete (int id);
    Customer getCustomerByID (int id);
    Customer getCustomerByName (String name);
    List<Customer> getAllCustomer();
    
}
