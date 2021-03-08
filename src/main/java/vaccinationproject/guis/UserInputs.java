package vaccinationproject.guis;

import vaccinationproject.mainfunctions.VaccinationService;
import vaccinationproject.validators.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserInputs {
    private final MessagePrinter mp;
    private final VaccinationService vaccinationService;
    private final Scanner scanner;

    private static final String EXIT_CODE = "999";

    public UserInputs(MessagePrinter mp, VaccinationService service, Scanner scanner) {
        this.mp = mp;
        this.vaccinationService = service;
        this.scanner = scanner;
    }

    public String writeMenuToConsole() throws IllegalArgumentException {
        mp.printMenu();
        return scanner.nextLine().trim();
    }

    public String getVaccinationType(Map<Integer, String> vacMap) throws IllegalArgumentException {
        mp.printVaccinationTypes(vacMap);
        String type = getAndValidateValue("Kérem válasszon vakcinát:", new VaccineValidator(vacMap));
        return vacMap.get(Integer.parseInt(type));
    }

    public String getNote() throws IllegalArgumentException {
        String note;
        mp.printUserCancelInfo();
        mp.printCian("Kérem az indoklást (maximum 1 sor):");
        note = scanner.nextLine();
        isUserExit(note);
        return note;
    }

    public String getName() {
        return getAndValidateValue("Kérem, adja meg a nevet: ", new NameValidator());
    }

    public String getZip() throws IllegalArgumentException, IllegalStateException {
        ZipValidator zipValidator = new ZipValidator(vaccinationService.getCitizenDao());
        String zip = getAndValidateValue("Kérem az irányítószámot:", zipValidator);
        printZipcodes(vaccinationService.getZipsByZipcode(zip));
        return zip;
    }

    private void printZipcodes(List<String> zips) {
        mp.printStringList(zips, "Talált írányítószám(ok):");
    }

    public String getAge() throws IllegalArgumentException {
        return getAndValidateValue("Kérem az életkort (11 - 149)", new AgeValidator());
    }

    public String getSocialId() throws IllegalArgumentException {
        String taj;
        taj = getAndValidateValue("Kérem a TAJ számot:", new SocIdValidator());
        return taj;
    }

    public String getEmailAddress() throws IllegalArgumentException {
        String email = "";
        String emailAgain = "";
        EmailValidator emailValidator = new EmailValidator();
        do {
            if (!email.equals(emailAgain)) {
                mp.printRed("A két email cím nem egyezik meg, kérem adja meg újra!");
            }
            email = getAndValidateValue("Kérem az Email címet:", emailValidator).toLowerCase(Locale.ROOT);
            emailAgain = getAndValidateValue("Kérem az Email címet újra:", emailValidator).toLowerCase(Locale.ROOT);
        } while (!email.equals(emailAgain));
        return email;
    }

    private void isUserExit(String param) throws IllegalArgumentException {
        if (param.equals(EXIT_CODE)) {
            throw new IllegalArgumentException("Felhasználói megszakítás");
        }
    }

    public Path getFileName(Path path) throws IllegalArgumentException {
        String fileStr = getAndValidateValue("Kérem adja meg a fájl nevét elérési út nélkül, kiterjesztéssel: ", new FileNameValidator());
        return Path.of(path.toString(), fileStr);
    }

    public Path getPath(String defaultPathStr) throws IllegalArgumentException {
        Path path = Path.of(defaultPathStr);
        mp.printGreen("Alapértelmezett  könyvtár = " + path.toString());
        String yesNo = getAString("Szeretne Saját könyvtárat megadni (I,N)?");
        if (yesNo.equalsIgnoreCase("i")) {
            String message = "Kérem adja meg az elérési utat fájlnév nélkül:";
            String pathStr = getAndValidateValue(message, new DirectoryValidator());
            path = Path.of(pathStr);
        }
        return path;
    }

    public boolean getYesNo(String question) throws IllegalArgumentException {
        String answer = getAString(question);
        isUserExit(question);
        return answer.toLowerCase(Locale.ROOT).equals("i");
    }

    public String getAndValidateValue(String message, Predicate<String> validator) throws IllegalArgumentException {
        String answer;
        do {
            answer = getAString(message).toLowerCase(Locale.ROOT);
        } while (!validator.test(answer));
        return answer;
    }

    public String getAString(String question) throws IllegalArgumentException {
        mp.printUserCancelInfo();
        mp.printCian(question);
        String answer = scanner.nextLine();
        isUserExit(answer);
        return answer;
    }


}
