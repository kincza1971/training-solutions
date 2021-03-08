package vaccinationproject.guis;

import java.util.List;
import java.util.Map;

public class MessagePrinter {

    private final String EXIT_CODE = "999";
    private final String USER_CANCEL = "Adatbevitel megszakítása: " + EXIT_CODE;


    public void printRed(String message) {
        System.out.println(Colors.RED_BOLD);
        System.out.println(message);
        System.out.println(Colors.RESET);
    }

    public void printGreen(String message) {
        System.out.println(Colors.GREEN);
        System.out.println(message);
        System.out.println(Colors.RESET);
    }

    public void printCian(String message) {
        System.out.print(Colors.CYAN_BOLD);
        System.out.println(message);
        System.out.print(Colors.RESET);

    }

    public void printUserCancelInfo() {
        printCian(USER_CANCEL);
    }

    public void printRedBright(String message) {
        System.out.print(Colors.RED_BRIGHT);
        System.out.println(message);
        System.out.println(Colors.RESET);

    }

    public void printMenu() {
        System.out.print(Colors.BLUE_BOLD.toString());
        System.out.println("Kérem válasszon az alábbi menüpontok közül:");
        System.out.println();
        System.out.println("1.  Regisztráció");
        System.out.println("2.  Tömeges regisztráció");
        System.out.println("3.  Generálás");
        System.out.println("4.  Oltás");
        System.out.println("5.  Oltás meghiúsulás");
        System.out.println("6.  Jelentés");
        System.out.println("999. Kilépés");
        System.out.println(Colors.RESET);
    }

    public void printStringList(List<String> report, String header) {
        System.out.println(Colors.GREEN);
        System.out.println(header.replaceAll(";", "\t"));
        for (String line : report) {
            System.out.println(line.replaceAll(";", "\t\t\t"));
        }
        System.out.println(Colors.RESET);

    }

    public void printVaccinationTypes(Map<Integer, String> vacTypes) {
        System.out.print(Colors.CYAN_BOLD);
        for (Map.Entry<Integer, String> entry : vacTypes.entrySet()) {
            System.out.println(entry.getKey().toString() + "\t" + entry.getValue());
        }
        System.out.println(Colors.RESET);

    }

}
