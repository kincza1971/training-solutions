package vaccinationproject.mainfunctions;

import org.mariadb.jdbc.MariaDbDataSource;
import vaccinationproject.dao.CitizenDao;
import vaccinationproject.dao.MassRegistrationResult;
import vaccinationproject.tableclasses.Citizen;
import vaccinationproject.tableclasses.Vaccination;
import vaccinationproject.validators.AgeValidator;
import vaccinationproject.validators.EmailValidator;
import vaccinationproject.validators.SocIdValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VaccinationService {
    public final int INDEX_OF_NAME = 0;
    public final int INDEX_OF_ZIP = 1;
    public final int INDEX_OF_AGE = 2;
    public final int INDEX_OF_EMAIL = 3;
    public final int INDEX_OF_TAJ = 4;
    MariaDbDataSource dataSource;
    List<String> zips;
    CitizenDao citizenDao;
    List<String> wrongLines;


    public VaccinationService(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
        this.citizenDao = new CitizenDao(dataSource);
        zips = citizenDao.getZips();
    }

    public String checkName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name;
    }

    public String checkZip(String zipStr) {
        if (zips == null) {
            zips = citizenDao.getZips();
            if (zips.isEmpty()) {
                throw new IllegalStateException("Cities table is empty");
            }
        }
        return getZipIfExists(zipStr);
    }

    private String getZipIfExists(String zipStr) {
        for (String zip : zips) {
            if (zip.equals(zipStr)) {
                return zipStr;
            }
        }
        throw new IllegalArgumentException("Zip does not exists " + zipStr);
    }

    private int checkAge(String ageStr) {
        if (new AgeValidator().test(ageStr)) {
            return Integer.parseInt(ageStr);
        }
        throw new IllegalArgumentException("Hibás életkor: " + ageStr);
    }

    private Citizen validateAndCreateCitizen(String line) throws IllegalArgumentException {
        String[] fields = line.split(";");
        if (fields.length == 5) {
            String name = checkName(fields[INDEX_OF_NAME]);
            String zip = checkZip(fields[INDEX_OF_ZIP]);
            int age = checkAge(fields[INDEX_OF_AGE]);
            String email = checkMail(fields[INDEX_OF_EMAIL]);
            String taj = socialIdValidator(fields[INDEX_OF_TAJ]);
            return new Citizen(name, zip, age, email, taj);
        }
        throw new IllegalArgumentException("Wrong line: " + line);
    }

    private String checkMail(String mail) {
        if (new EmailValidator().test(mail)) {
            return mail;
        }
        throw new IllegalArgumentException("Wrong email address: " + mail);
    }

    private String socialIdValidator(String taj) {
        if (new SocIdValidator().test(taj)) {
            return taj;
        } else {
            throw new IllegalArgumentException("Invalid TAJ " + taj);
        }
    }

    private void saveWrongLineToList(String message, String line) {
        if (wrongLines == null) {
            wrongLines = new ArrayList<>();
        }
        wrongLines.add(line + "  ***" + message);
    }

    public List<Citizen> loadFromFileToList(Path file) {
        citizenDao = new CitizenDao(dataSource);
        zips = citizenDao.getZips();
        try (BufferedReader br = Files.newBufferedReader(file)) {
            return br.lines()
                           .skip(1)
                           .map(this::validateAndCreateCitizen)
                           .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("Cannot open file");
        }
    }

    private void validateAndInsertCitizen(String line) throws IllegalArgumentException {
        String[] fields = line.split(";");
        if (fields.length == 5) {
            try {
                String name = checkName(fields[INDEX_OF_NAME]);
                String zip = checkZip(fields[INDEX_OF_ZIP]);
                int age = checkAge(fields[INDEX_OF_AGE]);
                String email = fields[INDEX_OF_EMAIL];
                new EmailValidator().test(email);
                String taj = socialIdValidator(fields[INDEX_OF_TAJ]);
                Citizen citizen = new Citizen(name, zip, age, email, taj);
                insertCitizen(citizen);
            } catch (IllegalArgumentException e) {
                saveWrongLineToList(e.getMessage(), line);
            }
        } else {
            saveWrongLineToList("Wrong line format ", line);
        }
    }

    public MassRegistrationResult loadFromFileToDb(Path file) {
        wrongLines = new ArrayList<>();
        long result;
        try (BufferedReader br = Files.newBufferedReader(file)) {
            result = br.lines()
                             .skip(1)
                             .peek(this::validateAndInsertCitizen)
                             .count();
            return new MassRegistrationResult(result, wrongLines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot open file");
        }
    }

    public List<String> getZipsByZipcode(String zipStr) {
        return citizenDao.getZipsByZipcode(zipStr);
    }

    public boolean insertCitizen(Citizen citizen) throws IllegalStateException {
        try {
            citizenDao.insertCitizen(citizen);
            return true;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to db: " + sqle.getMessage());
        }
    }

    public List<Citizen> getCitizensForVaccination(String zip, int limit) throws IllegalStateException {
        return citizenDao.getCitizensForVaccinationByZip(zip, limit);
    }

    public Citizen getCitizenForVaccination(MariaDbDataSource dataSource, String taj) {
        Citizen citizen = citizenDao.findCitizenBySocialID(taj);
        return citizen;
    }

    public void insertVaccinationCancelled(Vaccination vaccination) {
        citizenDao.insertVaccinationCancelled(vaccination);
    }

    public Vaccination vaccinate(Citizen citizen, Vaccination vaccination) {
        try {
            return vaccination = citizenDao.insertVaccination(citizen, vaccination);

        } catch (IllegalStateException ise) {
            throw new IllegalStateException(ise.getMessage(), ise.getCause());
        }
    }

    public List<String> createReportByZip() {
        return citizenDao.createReportByZip();
    }

    public Map<Integer, String> loadVaccinationTypesFromDatabase() {
        return citizenDao.getVaccinationTypes();
    }
}
