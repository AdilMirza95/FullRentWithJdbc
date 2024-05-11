package az.project.config;

import az.project.Dao.Imp.CarDaoImpl;
import az.project.Dao.Imp.CategoryDaoImpl;
import az.project.Dao.Imp.CustomerDaoImpl;
import az.project.Dao.Inter.CarDaoInter;
import az.project.Dao.Inter.CategoryDaoInter;
import az.project.Dao.Inter.CustomerDaoInter;

public class Context {

    public static CarDaoInter instanceCarDao() {
        return new CarDaoImpl();
    }

    public static CategoryDaoInter instanceCategoryDao() {
        return new CategoryDaoImpl();
    }
    
    public static CustomerDaoInter instanceCustomerDao() {
        return new CustomerDaoImpl();
    }
}
