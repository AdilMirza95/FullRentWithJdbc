package az.project.Dao.Imp;

import az.project.Dao.Inter.CategoryDaoInter;
import az.project.config.AbstractDao;
import az.project.entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDaoImpl extends AbstractDao implements CategoryDaoInter {

    @Override
    public void update(Category cat) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("update category set category_name=? where category_id=?");
            st.setString(1, cat.getCategoryName());
            st.setInt(2, cat.getCategory_id());
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Category cat) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("insert into category(category_id,category_name) values(?,?)");
            st.setInt(1, cat.getCategory_id());
            st.setString(2, cat.getCategoryName());
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("delete from category where category_id=?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Category getCategoryById(int id) {
        Category cat = null;

        try (Connection conn = connect()) {
            PreparedStatement st = conn.prepareStatement("select * from allinfo where category_id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                cat = new Category(category_id, categoryName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try (Connection conn = connect()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from allinfo");
            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                Category cat = new Category(category_id, categoryName);
                list.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
