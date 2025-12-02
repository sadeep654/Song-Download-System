import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection - centralised JDBC helper.
 * Update URL, USER, PASS to match your MySQL instance.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/musicdb?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "your_password_here";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
