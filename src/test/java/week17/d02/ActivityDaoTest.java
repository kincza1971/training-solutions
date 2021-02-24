package week17.d02;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

class ActivityDaoTest {

    ActivityDao activityDao;

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;
        String url = "jdbc:mariadb://localhost:3307/activitytracker?useUnicode=true";
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl(url);
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database: " + url);
        }


        Flyway flyway = Flyway.configure().locations("db/migration/activity").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);

    }


}