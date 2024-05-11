package az.project.Dao.Imp;

import az.project.Dao.Inter.CustomerDaoInter;
import az.project.config.AbstractDao;
import az.project.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDaoImpl extends AbstractDao implements CustomerDaoInter {

    @Override
    public void update(Customer cust) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("UPDATE customer SET fullname=?,phone=? WHERE customer_id=?");
            st.setString(1, cust.getFullName());
            st.setString(2, cust.getPhone());
            st.setInt(3, cust.getCustomer_id());
            int count = st.executeUpdate();
            System.out.println(count + "Musteri melumatlari yenilendi");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Customer cust) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("INSERT INTO customer (fullname,phone) VALUES(?,?)");
            st.setString(1, cust.getFullName());
            st.setString(2, cust.getPhone());
            int count = st.executeUpdate();
            System.out.println(count + "Musteri melumatlari yenilendi");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getCustomerByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer cust = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try (Connection conn = connect()) {
            st = conn.prepareStatement("SELECT * FROM customer WHERE fullname =?");
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                  cust = new Customer();
                  cust.setCustomer_id(rs.getInt("customer_id"));
                  cust.setFullName(rs.getString("fullname"));
                  cust.setPhone(rs.getString("phone"));
                  System.out.println(cust);
                  
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cust;
    }

    @Override
    public List<Customer> getAllCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
