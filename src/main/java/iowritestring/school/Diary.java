package iowritestring.school;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {
//    newMark() metódussal, ami paraméterül várja a tanuló nevét és egy jegyet! Ha létezik a "tanulo_neve.txt"
//    akkor a jegyet hozzáfűzi az állomány végére. Ha nem, akkor egy új állományt hoz létre "tanulo_neve.txt" formátumban,
//    és beleírja a jegyet. Azt, hogy létezik-e egy fájl a Files.exists(path) metódussal tudod eldönteni.
//    A fájlok a src/main/resources/ könyvtárban legyenek!
//
//    Az év végén a tanár szeretné a tanuló fájl utolsó sorába az átlagot beírni. Írj egy metódust average() névvel,
//    ami a fájl utolsó sorába a jegyek átlagát írja be! Például "average: 5".

    private Path getPath(String name) {
        String fileName = "/src/main/resources/"+ name +".txt";
        Path file = Path.of(fileName);
    return file;
}


    public void newMark(String name, int mark) {
        Path file = getPath(name);
        String markStr = Integer.toString(mark);
        try {
            if (Files.exists(file)) {
                Files.writeString(file, markStr, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, markStr, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File írási hiba, " + name);
        }
    }

    private double calcAverage(List<String> marks) {
        if (marks.size()>0) {
            int sum =0;
            double counter = 0;
            for (String mark : marks) {
                sum += Integer.parseInt(mark);
                counter++;
            }
            return sum/counter;
        }
        return 0;
    }

    public double average (String name) {
        Path file = getPath(name);
        double avg = 0;
        List<String> marks;
        try {
            if (Files.exists(file)) {
                avg = calcAverage(Files.readAllLines(file));
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("File nem létezik " + name);
        }
        return avg;
    }

}



