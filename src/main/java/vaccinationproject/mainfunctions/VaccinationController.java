package vaccinationproject.mainfunctions;

import org.mariadb.jdbc.MariaDbDataSource;
import vaccinationproject.dao.MassRegistrationResult;
import vaccinationproject.fileio.SaveFiles;
import vaccinationproject.guis.MessagePrinter;
import vaccinationproject.guis.UserInputs;
import vaccinationproject.tableclasses.Citizen;
import vaccinationproject.tableclasses.Vaccination;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VaccinationController {
    public static final String STATUS_COMPLETED = "SIKERES";
    public static final String STATUS_CANCELLED = "SIKERTELEN";
    private final MariaDbDataSource dataSource = new MariaDbDataSource();
    private final MessagePrinter mp;
    private final VaccinationService vaccinationService;
    private final UserInputs ui;
    private final Map<Integer, String> vaccinationTypes;
    private final SaveFiles filer;

    public static final String EXIT_CODE = "999";
    private static final String REGISTRATION_FILE_HEADER = "Név;Irányítószám;Életkor;E-mail cím;Taj szám";
    private static final String VACCINATION_FILE_HEADER = "Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám";
    private static final String REPORT_HEADER = "Irányítószám;OLTATLAN;EGY_OLTÁS;KÉT_OLTÁS";


    public VaccinationController(Scanner mainScanner) {
        setDataSource();
        vaccinationService = new VaccinationService(dataSource);
        mp = new MessagePrinter();
        ui = new UserInputs(mp, vaccinationService, mainScanner);
        this.vaccinationTypes = vaccinationService.loadVaccinationTypesFromDatabase();
        filer = new SaveFiles(mp);
    }

    private void setDataSource() {
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot find database server", sqle);
        }
    }

    public void controllerMain() {
        String selected;
        do {
            selected = ui.writeMenuToConsole();
            doSelected(selected);
        } while (!selected.equals(EXIT_CODE));
    }

    public void doSelected(String selected) {
        switch (selected) {
            case EXIT_CODE:
                break;
            case "1":
                registration();
                break;

            case "2":
                massRegistrationFromFile();
                break;

            case "3":
                generateListForVaccination();
                break;

            case "4":
                vaccinate();
                break;

            case "5":
                cancelVaccination();
                break;

            case "6":
                reportingByZip();
                break;
            default:
                mp.printRed("Nem létező menüpont");
        }
    }

    private void reportingByZip() {
        try {
            List<String> report = vaccinationService.createReportByZip();
            mp.printStringList(report, REPORT_HEADER);
            if (ui.getYesNo("Kívánja a istát fájlba menteni? I/N")) {
                String pathStr = Paths.get("").toAbsolutePath().toString() + "/vaccinations";
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
                String fileStr = "report" + "_" + LocalDate.now().format(df) + ".csv";
                filer.writeStringListToFile(Path.of(pathStr, fileStr), report, REPORT_HEADER);
            }
        } catch (IllegalStateException ise) {
            mp.printRed(ise.getMessage());
        }

    }

    private void cancelVaccination() {
        String taj = ui.getSocialId();
        Citizen citizen = vaccinationService.getCitizenForVaccination(dataSource, taj);
        String note = ui.getNote();
        String question = citizen.toString() + System.lineSeparator() + "Helyesek az adatok (I/N)?";
        if (!ui.getYesNo(question)) {
            return;
        }
        Vaccination vaccination = new Vaccination(LocalDate.now(), STATUS_CANCELLED, note, citizen.getId(), null);
        insertVaccinationCancelled(vaccination);

    }

    private void insertVaccinationCancelled(Vaccination vaccination) {
        try {
            vaccinationService.insertVaccinationCancelled(vaccination);
            mp.printGreen("Meghiúsulás sikeresen rögzítve: " + vaccination.toString());
        } catch (IllegalStateException ise) {
            mp.printRed(ise.getMessage());
        }

    }

    private void vaccinate() {
        try {
            String taj = ui.getSocialId();
            Citizen citizen = vaccinationService.getCitizenForVaccination(dataSource, taj);
            int numOfVaccination = citizen.getNumberOfVaccination();
            if (numOfVaccination >= 2) {
                mp.printRed("A választott személy már megkapta a két oltást " + System.lineSeparator() + citizen.getShortData());
                return;
            }
            String question = citizen.toString() + System.lineSeparator() + "Helyesek az adatok (I/N)?";
            if (ui.getYesNo(question)) {
                doTheVaccination(citizen, numOfVaccination);
            }
        } catch (IllegalArgumentException e) {
            mp.printUserCancelInfo();
        }
    }

    private void doTheVaccination(Citizen citizen, int numOfVaccination) {
        if (numOfVaccination == 0) {
            doTheFirstVaccination(citizen);
        } else { // 1
            doTheSecondVaccination(citizen);
        }
    }

    private void doTheSecondVaccination(Citizen citizen) {
        Vaccination vaccination = new Vaccination(LocalDate.now(), STATUS_COMPLETED, "", citizen.getId(),
                citizen.getLastVaccinationType());
        vaccinationService.saveVaccinateToDb(citizen, vaccination);
        mp.printGreen("Az oltás sikeresen regisztrálásra került" + System.lineSeparator() + citizen.getShortData());
        mp.printRedBright("Figyelem: " + vaccination.getVacccinationType());
    }

    private void doTheFirstVaccination(Citizen citizen) {
        String type = ui.getVaccinationType(vaccinationTypes);
        Vaccination vaccination = new Vaccination(LocalDate.now(), STATUS_COMPLETED, "",
                citizen.getId(), type);
        mp.printGreen(vaccination.toString());
        vaccinationService.saveVaccinateToDb(citizen, vaccination);
        mp.printGreen("Az oltás sikeresen regisztrálásra került" + System.lineSeparator() + citizen.getShortData());
    }

    private void saveRegistrationErrorFile(MassRegistrationResult result, String dir) {
        String pathStr = Paths.get("").toAbsolutePath().toString() + dir;
        try {
            Path path = ui.getPath(pathStr);
            path = ui.getFileName(path);
            filer.writeStringListToFile(path, result.getWrongLines(), REGISTRATION_FILE_HEADER);
        } catch (IllegalArgumentException iae) {
            mp.printRed(iae.getMessage());
        }

    }

    private void handleMassRegistrationResult(MassRegistrationResult result) {
        try {
            mp.printGreen(result.getLineCounter() + " sor feldolgozása történt meg");
            mp.printGreen(result.getErrorCounter() + " hibás sor volt a fájlban");
            if (result.getErrorCounter() > 0 & ui.getYesNo("Kívánja a hibalistát menteni? I/N")) {
                String dir = "/errors";
                saveRegistrationErrorFile(result, dir);
            }
        } catch (IllegalArgumentException e) {
            mp.printUserCancelInfo();
        }
    }

    private void massRegistrationFromFile() {
        try {
            String pathStr = Paths.get("").toAbsolutePath().toString() + "/covidtestfiles";
            Path path = ui.getPath(pathStr);
            path = ui.getFileName(path);
            if (Files.notExists(path)) {
                mp.printRed("Fájl nem található");
                return;
            }
            mp.printCian("Adatbetöltés folyamatban ...");
            MassRegistrationResult result = vaccinationService.loadFromFileToDb(path);
            handleMassRegistrationResult(result);
        } catch (IllegalArgumentException e) {
            mp.printUserCancelInfo();
        }
    }

    private void registration() {
        try {
            Citizen citizen = createCitizenByUserData();
            vaccinationService.insertCitizen(citizen);
            mp.printCian(citizen.getShortData());
        } catch (IllegalArgumentException iae) {
            mp.printRed(iae.getMessage());
        }
    }

    private Citizen createCitizenByUserData() {
        String name = ui.getName();
        String zip = ui.getZip();
        String age = ui.getAge();
        String email = ui.getEmailAddress();
        String taj = ui.getSocialId();
        return new Citizen(name, zip, Integer.parseInt(age), email, taj);
    }

    private void generateListForVaccination() {
        String zip = ui.getZip();
        String limit = "16";
        try {
            List<Citizen> citizens = vaccinationService.getCitizensForVaccination(zip, Integer.parseInt(limit));
            List<String> vaccination = createVaccinationList(citizens);
            String pathStr = Paths.get("").toAbsolutePath().toString() + "/vaccinations";
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
            String fileStr = zip + "_" + LocalDate.now().format(df) + "_vaccinaton.csv";
            filer.writeStringListToFile(Path.of(pathStr, fileStr), vaccination, VACCINATION_FILE_HEADER);
        } catch (IllegalStateException ie) {
            mp.printRedBright(ie.getMessage());
        }
    }

    private List<String> createVaccinationList(List<Citizen> citizens) {
        List<String> result = new LinkedList<>();
        LocalTime time = LocalTime.of(8, 0);
        for (Citizen citizen : citizens) {
            result.add(time.toString() + ";" + citizen.getVaccinationFileLine());
            time = time.plusMinutes(30);
        }
        return result;
    }

}
