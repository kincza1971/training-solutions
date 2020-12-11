package week07.d05;

import com.sun.source.tree.TryTree;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private static void writeToFile(List<String> data, String fileName) {
        Path file = Path.of(fileName);
        try {
            Files.write(file, data, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            throw new IllegalStateException("Fájl írása sikertelen, " + fileName,ex);
        }
    }

    private static String getUserData(Scanner scanner, List<String> data) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Kérem a(z) " + i+1 + ". adatot:");
            data.add(scanner.nextLine());
        }
        System.out.println("Kérem a fájl nevét:");
        return scanner.nextLine();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String>  data = new ArrayList<>();

        String fileName = getUserData(scanner, data);

        writeToFile(data, fileName);
    }


}
