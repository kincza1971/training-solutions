package vaccinationproject.dao;

import vaccinationproject.tableclasses.Citizen;
import vaccinationproject.tableclasses.Vaccination;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CitizenDao {
    private final String SELECT_VACCINATION_BY_CITIZEN
            = "select vac_id, citizen_id, vac_date, vac_status,vac_note, vac_type from vaccinations " +
                      "where citizen_id = ?  and vac_status = 'SIKERES' order by vac_date desc";

    private final String SELECT_REPORT_BY_ZIP
            = " SELECT distinct zip, (SELECT COUNT(*) FROM citizens c2 WHERE vac_num=0 AND c2.zip = citizens.zip) zero," +
                      " (SELECT COUNT(*) FROM citizens c3 WHERE vac_num=1 AND c3.zip = citizens.zip) `one`," +
                      " (SELECT COUNT(*) FROM citizens c3 WHERE vac_num >= 2 AND c3.zip = citizens.zip) two_or_more" +
                      " FROM citizens ORDER BY zip";
    private final DataSource dataSource;

    public CitizenDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getZips() {
        List<String> zips = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("select zipcode from cities")
        ) {
            while (rs.next()) {
                zips.add(rs.getString(1));
            }
            return zips;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database ", sqle);
        }
    }

    public List<String> getZipsByZipcode(String zip) {
        List<String> zipList = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement statement = conn.prepareStatement("select zipcode,city,district from cities where " +
                                                                            "zipcode = ?")
        ) {
            statement.setString(1, zip);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                zipList.add(rs.getString(1) + "; " + rs.getString(2) + "; " + rs.getString(3));
            }
            return zipList;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database ", sqle);
        }
    }

    public void insertCitizen(Citizen citizen) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            prepareAndExecuteInsertCitizen(citizen, conn);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + " " + e.getCause().getMessage());
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to db: " + sqle.getMessage());
        }
    }

    private void prepareAndExecuteInsertCitizen(Citizen citizen, Connection conn) {
        try (PreparedStatement statement =
                     conn.prepareStatement("Insert into citizens (fullname,zip,age,email,soc_id,vac_num,last_vac)" +
                                                   " values (?,?,?,?,?,?,?)")) {
            statement.setString(1, citizen.getFullName());
            statement.setString(2, citizen.getZipCode());
            statement.setInt(3, citizen.getAge());
            statement.setString(4, citizen.getMail());
            statement.setString(5, citizen.getSocialId());
            statement.setInt(6, 0);
            statement.setDate(7, null);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Cannot insert citizen record", sqle);
        }
    }

    public Citizen findCitizenBySocialID(String taj) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement("select id, fullname, zip, age, email, soc_id, vac_num, last_vac " +
                                                            "from citizens where soc_id = ?")
        ) {
            statement.setString(1, taj);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new IllegalArgumentException("Cannot find citizen with this TAJ");
            }
            return createCitizenByResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect or execute query ", sqle);
        }
    }

    private Citizen createCitizenByResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        List<Vaccination> vaccinations = getVaccinationsByCitizen(id);
        return new Citizen(
                id,
                rs.getString("fullname"),
                rs.getString("zip"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("soc_id"),
                rs.getInt("vac_num"),
                rs.getDate("last_vac") == null ? null : rs.getDate("last_vac").toLocalDate(),
                vaccinations);
    }

    private List<Citizen> createCitizensByResultSet(ResultSet rs) throws SQLException {
        List<Citizen> result = new ArrayList<>();
        do {
            result.add(createCitizenByResultSet(rs));
        }
        while (rs.next());
        return result;
    }

    public List<Citizen> getCitizensForVaccinationByZip(String zip, int limit) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(
                                "select id, fullname, zip,age, email, soc_id vac_num, last_vac from citizens where " +
                                        "zip = ?" +
                                        " and ( `vac_num` =0 or (`vac_num` =1 and `last_vac` < ?)) order by age DESC, " +
                                        "fullname LIMIT ?")
        ) {
            statement.setString(1, zip);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setInt(3, limit);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) {
                throw new IllegalStateException("No more person to vaccinate with this zip: " + zip);
            }
            List<Citizen> result = createCitizensByResultSet(rs);
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot read data from db: " + sqle.getMessage());
        }
    }

    //nt id, LocalDate date, VaccinationStatus status, String note, int citizen_id,
    //                       VaccinationType vaccinationType

    private List<Vaccination> createVaccinationListByResultSet(ResultSet rs) {
        List<Vaccination> vaccinations = new ArrayList<>();
        try (rs) {
            while (rs.next()) {
                vaccinations.add(
                        new Vaccination(rs.getInt("vac_id"),
                                rs.getDate("vac_date").toLocalDate(),
                                rs.getString("vac_status"),
                                rs.getString("vac_note"),
                                rs.getInt("citizen_id"),
                                rs.getString("vac_type")
                        )
                );
            }
            return vaccinations;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Vaccination result set error", sqle);
        }
    }

    public List<Vaccination> getVaccinationsByCitizen(int citizen_id) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(SELECT_VACCINATION_BY_CITIZEN)
        ) {
            statement.setInt(1, citizen_id);
            ResultSet rs = statement.executeQuery();
            return createVaccinationListByResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Connect or select vaccinations failed", sqle);
        }
    }

    public Vaccination insertVaccination(Citizen citizen, Vaccination vaccination) throws IllegalStateException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try (
                    PreparedStatement vaccinationStmt =
                            connection.prepareStatement("insert into vaccinations values (null,?,?,?,?,?)",
                                    Statement.RETURN_GENERATED_KEYS);
                    PreparedStatement citizenSmt =
                            connection.prepareStatement("update citizens set vac_num = vac_num+1, last_vac =CURDATE()" +
                                                                " where id= ?")
            ) {
                vaccination = prepareAndInsertVaccination(vaccination, vaccinationStmt);
                prepareAndUpdateCitizen(citizen, citizenSmt);
                citizen.vaccinate(vaccination);
                connection.commit();
                return vaccination;
            } catch (IllegalStateException ise) {
                connection.rollback();
                throw new IllegalStateException(ise.getMessage(), ise.getCause());
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect: " + sqle);
        }
    }

    private Vaccination prepareAndInsertVaccination(Vaccination vaccination, PreparedStatement stmt) {
        try {
            stmt.setInt(1, vaccination.getCitizen_id());
            stmt.setDate(2, Date.valueOf(vaccination.getDate()));
            stmt.setString(3, vaccination.getStatus());
            stmt.setString(4, vaccination.getNote());
            stmt.setString(5, vaccination.getVacccinationType());
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();
            int vacId = keys.getInt(1);
            return Vaccination.of(vaccination, vacId);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot insert vaccination: " + vaccination.toString() + " " + sqle.getMessage(),
                    sqle);
        }
    }

    private void prepareAndUpdateCitizen(Citizen citizen, PreparedStatement stmt) {
        try {
            stmt.setInt(1, citizen.getId());
            stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot update citizen: " + citizen.toString() + " " + sqle.getMessage(), sqle);
        }
    }

    public void insertVaccinationCancelled(Vaccination vaccination) {
        try (Connection connection = dataSource.getConnection()) {
            try {
                PreparedStatement statement =
                        connection.prepareStatement("insert into vaccination values (null,?,?,3,null,null)");
                statement.setInt(1, vaccination.getCitizen_id());
                statement.setDate(2, Date.valueOf(vaccination.getDate()));
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot insert cancelled vaccination: " + vaccination.toString(), sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to db", sqle);
        }
    }

    public List<String> createReportByZip() {
        try (
                Connection connection = dataSource.getConnection()
        ) {
            try (
                    Statement statement = connection.createStatement()
            ) {
                ResultSet rs = statement.executeQuery(SELECT_REPORT_BY_ZIP);
                return createReportByResultSet(rs);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot execute querry: " + sqle.getMessage(), sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database: " + sqle.getMessage(), sqle);
        }
    }

    private List<String> createReportByResultSet(ResultSet rs) throws SQLException {
        List<String> result = new ArrayList<>();
        String line = "";
        while (rs.next()) {
            line = rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4);
            result.add(line);
        }
        return result;
    }

    private Map<Integer, String> creatVaccinationTypeMapFromResultSet(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            throw new IllegalStateException("Vactypes table is empty");
        }
        Map<Integer, String> result = new TreeMap<>();
        int i = 1;
        do {
            result.put(i, rs.getString("type_name"));
            i++;
        } while (rs.next());
        return result;
    }

    public Map<Integer, String> getVaccinationTypes() {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select type_name from vactypes order by 1")
        ) {
            return creatVaccinationTypeMapFromResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database: " + sqle.getMessage(), sqle);
        }
    }

}


//CREATE TABLE `citizens` (
//	`fullname` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
//	`zip` INT(11) NOT NULL,
//	`age` INT(10) UNSIGNED NOT NULL,
//	`email` VARCHAR(200) NOT NULL COLLATE 'utf8_general_ci',
//	`soc_id` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
//	`vac_num` INT(11) NOT NULL DEFAULT '0',
//	`last_vac` DATETIME NULL DEFAULT NULL,
//	PRIMARY KEY (`soc_id`) USING BTREE,
//	INDEX `FK_citizens_cities` (`zip`) USING BTREE
//)
//COLLATE='utf8_general_ci'
//ENGINE=InnoDB
//;
