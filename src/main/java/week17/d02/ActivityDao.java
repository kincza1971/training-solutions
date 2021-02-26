package week17.d02;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private DataSource dataSource;

    public ActivityDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

//    public ActivityDao() {
//        this.dataSource = createDataSource();
//    }

//    public MariaDbDataSource createDataSource() {
//        MariaDbDataSource dataSource;
//        String url = "jdbc:mariadb://localhost:3307/activitytracker?useUnicode=true";
//        try {
//            dataSource = new MariaDbDataSource();
//            dataSource.setUrl(url);
//            dataSource.setUser("activitytracker");
//            dataSource.setPassword("activitytracker");
//            return dataSource;
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("Cannot connect to database: " + url);
//        }
//    }

    private List<TrackPoint> saveTrackPoints(List<TrackPoint> trackPoints, long activityId) {
        List<TrackPoint> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO trackpoints (time, lat, lon, activity_id) VALUES " +
                                                         "(?,?, ?)"
                             , Statement.RETURN_GENERATED_KEYS)) {
            try {
                connection.setAutoCommit(false);
                for (TrackPoint trackPoint : trackPoints) {
                    statement.setTimestamp(1, Timestamp.valueOf(trackPoint.getTime()));
                    statement.setDouble(2, trackPoint.getLat());
                    statement.setDouble(3, trackPoint.getLon());
                    statement.setDouble(4, activityId);
                    statement.executeUpdate();
                    long key = executeAndGetGeneratedKey(statement);
                    result.add(new TrackPoint(key, trackPoint.getTime(), trackPoint.getLat(), trackPoint.getLon()));
                }
                connection.commit();
                return result;
            } catch (SQLException sqle) {
                connection.rollback();
                throw new IllegalStateException("Cannot insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }


    public Activity saveActivity(DataSource dataSource, Activity activity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection
                                                   .prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?,?, ?)"
                                                           , Statement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString(2, activity.getDesc());
            statement.setString(3, activity.getActivityType().toString());
            statement.executeUpdate();
            long key = executeAndGetGeneratedKey(statement);
            return Activity.activityById(key, activity);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }


    public List<Activity> saveActivitiesList(DataSource dataSource, List<Activity> activities) {
        List<Activity> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?,?, ?)"
                             , Statement.RETURN_GENERATED_KEYS)) {
            try {
                connection.setAutoCommit(false);
                for (Activity activity : activities) {
                    statement.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                    statement.setString(2, activity.getDesc());
                    statement.setString(3, activity.getActivityType().toString());
                    statement.executeUpdate();
                    long key = executeAndGetGeneratedKey(statement);
                    result.add(Activity.activityById(key, activity));
                }
                connection.commit();
                return result;
            } catch (SQLException sqle) {
                connection.rollback();
                throw new IllegalStateException("Cannot insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    public List<Activity> insertActivityFromList(List<Activity> activities) {
        List<Activity> resultList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO activities (start_time, activity_desc, activity_type) VALUES (?, ?, ?)"
                           + ", (?, ?, ?)".repeat(activities.size() - 1));
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
            setValuesOfStatement(activities, statement);
            executeAndAddToResultList(activities, resultList, statement);
            return resultList;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    private void setValuesOfStatement(List<Activity> activities, PreparedStatement statement) throws SQLException {
        int i = 0;
        for (Activity activity : activities) {
            statement.setTimestamp((i * 3) + 1, Timestamp.valueOf(activity.getStartTime()));
            statement.setString((i * 3) + 2, activity.getDesc());
            statement.setString((i * 3) + 3, activity.getActivityType().toString());
            i++;
        }
    }

    private void executeAndAddToResultList(List<Activity> activities, List<Activity> resultList, PreparedStatement statement) {
        ResultSet rs = null;
        try {
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            int i = 0;
            while (rs.next()) {
                resultList.add(Activity.activityById(rs.getLong(1), activities.get(i)));
                i++;
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert", sqle);
        }
    }

    private long executeAndGetGeneratedKey(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new IllegalStateException("Key not generated");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Insertion failed", sqle);
        }
    }

    public Activity findActivityById(long id) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("select * from activities where id = ?")
        ) {
            statement.setLong(1, id);
            List<Activity> resultList = selectActivityByPreparedStatement(statement);
            if (resultList.size() == 1) {
                return resultList.get(0);
            }
            throw new IllegalStateException("Cannot find activity");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot run query", sqle);
        }
    }

    private List<Activity> selectActivityByPreparedStatement(PreparedStatement statement) {
        try (ResultSet resultSet = statement.executeQuery()) {
            List<Activity> resultList = new ArrayList<>();
            while (resultSet.next()) {
                resultList.add(new Activity(resultSet.getLong("id")
                        , resultSet.getTimestamp("start_time").toLocalDateTime()
                        , resultSet.getString("activity_desc")
                        , ActivityType.valueOf(resultSet.getString("activity_type"))
                        , null));
            }
            return resultList;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute query", sqle);
        }
    }

    public List<Activity> selectAllActivities() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from activities order by 1")
        ) {
            return selectActivityByPreparedStatement(statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot run query", sqle);
        }
    }

    public List<Activity> selectByActivityType(ActivityType activityType) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from activities where " +
                                                                               "activity_type=?")) {
            statement.setString(1, activityType.toString());
            return selectActivityByPreparedStatement(statement);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute select");
        }
    }
}