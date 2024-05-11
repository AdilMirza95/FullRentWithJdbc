package az.project.main;


import az.project.Dao.Inter.CarDaoInter;
import az.project.Dao.Inter.CategoryDaoInter;
import az.project.Dao.Inter.CustomerDaoInter;
import az.project.config.Context;
import az.project.entity.Car;
import az.project.entity.Category;
import az.project.entity.Customer;
import java.util.Iterator;
import java.util.List;

public class FullRentWithJdbc {

    public static void main(String[] args) {

        
        CustomerDaoInter cdao =  Context.instanceCustomerDao();
        Customer cust = cdao.getCustomerByName("Adil Mirzeyev");
        
        
        
        
       
        
        
     
       
         
         
         
         
         
         
        
    }
}
