
package az.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADIL
 */
public abstract class AbstractDao {
    
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fullcar", "Adil", "1234");
    }
    
}
