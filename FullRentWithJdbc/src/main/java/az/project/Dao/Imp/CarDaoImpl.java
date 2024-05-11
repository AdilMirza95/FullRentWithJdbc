package az.project.Dao.Imp;

import az.project.Dao.Inter.CarDaoInter;
import az.project.config.AbstractDao;
import az.project.entity.Car;
import az.project.entity.Category;
import az.project.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl extends AbstractDao implements CarDaoInter {

    @Override
    public void update(Car c) {
        try (Connection conn = connect()) {

            PreparedStatement st = conn.prepareStatement("Update car set brand=?,model=?,year=?,dayofprice=?,"
                    + "customer_id=?,category_id=? where car_id=?");
            
            st.setString(1, c.getBrand());
            st.setString(2, c.getModel());
            st.setInt(3, c.getYear());
            st.setInt(4, c.getDayOfPrice());
            st.setInt(5, c.getCustomer().getCustomer_id());
            st.setInt(6, c.getCategory().getCategory_id());
            st.setInt(7, c.getCar_id());
            st.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Car c) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into car (car_id,brand,model,year,dayofprice,"
                    + "category_id,customer_id) values(?,?,?,?,?,?,?)");
            st.setInt(1, c.getCar_id());
            st.setString(2, c.getBrand());
            st.setString(3, c.getModel());
            st.setInt(4, c.getYear());
            st.setInt(5, c.getDayOfPrice());
            st.setInt(6, c.getCategory().getCategory_id());
            st.setInt(7, c.getCustomer().getCustomer_id());
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("delete from car where car_id=?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Car getCarById(int id) {
        Car c = null;
        try (Connection conn = connect()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from allinfo where car_id= " + id);
            while (rs.next()) {
                c = getCar(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> list = new ArrayList<>();
        try (Connection conn = connect()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from allinfo");
            while (rs.next()) {
                list.add(getCar(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static Car getCar(ResultSet rs) throws SQLException {
        int car_id = rs.getInt("car_id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        int year = rs.getInt("year");
        int dayOfPrice = rs.getInt("dayofprice");
        String fullName = rs.getString("fullname");
        String phone = rs.getString("phone");
        String categoryName = rs.getString("category_name");
        int category_id = rs.getInt("category_id");
        int customer_id = rs.getInt("customer_id");
        return new Car(car_id, brand, model, year, dayOfPrice, new Customer(customer_id, fullName, model), new Category(category_id, categoryName));
    }

}
