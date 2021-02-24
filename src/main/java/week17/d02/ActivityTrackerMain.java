package week17.d02;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityTrackerMain {

    public static void main(String[] args) {

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

        ActivityDao activityDao = new ActivityDao(dataSource);

        Activity activity1 = new Activity(LocalDateTime.of(2021, 1, 20, 16, 12, 05)
                , "kerékpárverseny", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 1, 20, 17, 12, 05)
                , "Hegymászás", ActivityType.HIKING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 1, 20, 18, 12, 05)
                , "kosarazás Dezsővel", ActivityType.BASKETBALL);
        Activity activity4 = new Activity(LocalDateTime.of(2021, 1, 20, 19, 12, 05)
                , "családi bringázás", ActivityType.BIKING);

        activityDao.saveActivity(dataSource, activity1);
        activityDao.saveActivity(dataSource, activity1);
        activityDao.saveActivity(dataSource, activity1);
        activityDao.saveActivity(dataSource, activity1);

        System.out.println(activityDao.findActivityById(3L, dataSource));

        List<Activity> activities = List.of(activity1, activity2, activity3, activity4);
        System.out.println(activityDao.insertActivityFromList(activities));

        System.out.println(activityDao.selectAllActivities());
    }


}
