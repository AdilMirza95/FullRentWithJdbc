package az.project.Dao.Inter;


import az.project.entity.Car;
import java.util.List;

public interface CarDaoInter {

    void update(Car c);
    void insert(Car c);
    void delete(int id);
    Car getCarById(int id);
    List<Car> getAllCar();

    
    
    
    
}
