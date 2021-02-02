package training_tracker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static training_tracker.Resources.*;

public class LessonGenerator {
    private final List<LessonData> data = new ArrayList<>();

    public void loadData(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            String pkg;
            String des;
            while ((line = br.readLine()) != null) {
                pkg = line.split(";")[0];
                des = line.split(";")[1];
                data.add(new LessonData(pkg, des));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkExtrices() {
        for (LessonData item : data) {
            Path path = Path.of("src/main/java/" + item.getPackageName());
            item.setExist(Files.isDirectory(path));
        }
    }

    public void generateHTML() {
        StringBuilder sb = new StringBuilder(STAHTML.replace("{type}", "Lessons"));
        sb.append(LESTHHTML).append(THFINALHTML);
        for (LessonData item : data) {
            if (item.isExist()) {
                sb.append(LESTRHTML.replace("{cssclass}", CSSOK).replace("{pkgname}", item.getPackageName()).replace("{desc}", item.getDescription()));
            } else {
                sb.append(LESTRHTML.replace("{cssclass}", CSSFAIL).replace("{pkgname}", item.getPackageName()).replace("{desc}", item.getDescription()));
            }
        }
        sb.append(EOFHTML);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/java/training_tracker/lessons.html"))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int calculatePassed() {
        int sum = 0;
        for (LessonData item : data) {
            if (item.isExist()) {
                sum++;
            }
        }
        return sum;
    }

    public int countAllPackage() {
        return data.size();
    }
}