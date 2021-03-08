package week17.d03;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesMain {
    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/ClosingProject?useUnicode=true");
            dataSource.setUser("test");
            dataSource.setPassword("testpassword");
        } catch (SQLException se) {
            throw new IllegalArgumentException("Some problem with dataSource", se);
        }
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into zipcodes(zip, city, district) values (?, ?, ?)")) {
            stmt.setString(1, "ABCD");
            stmt.setString(2, "Gyulafirátót");
            stmt.setString(3, null);
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("blabla", se);
        }
    }
}