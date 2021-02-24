package week17.d01;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    //                                      .getConnection("mariabd://localhost:3307/pizzeria?useUnicode=true"
//                                              , "root"
//                                              , "DBadmin"
//                                      );

    private MariaDbDataSource setDatasource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
            dataSource.setDatabaseName("employees");
            return dataSource;
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            throw new IllegalStateException("Cannot create datasource", sqle);
        }

    }


    public ResultSet execSql() {
        MariaDbDataSource dataSource = setDatasource();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO employees (emp_name) VALUES (?)")
        ) {
            statement.setString(1, "John Doe");
            statement.executeUpdate();
            ResultSet resultSet = connection.prepareStatement("select * from employees").executeQuery();
            return resultSet;
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
            throw new IllegalStateException("Cannot run query", ee);
        }
    }

    public static void main(String[] args) throws SQLException {
        DBTest dbTest = new DBTest();
        ResultSet rs = dbTest.execSql();
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
    }
}
