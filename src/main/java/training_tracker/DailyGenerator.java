package training_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static training_tracker.Resources.*;

public class DailyGenerator {
    private final List<DailyData> data = new ArrayList<>();

    public void loadData(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(new DailyData(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkExtrices() {
        for (DailyData item : data) {
            Path path = Path.of("src/main/java/" + item.getPackageName());
            item.setExist(Files.isDirectory(path));
        }
    }

    public void generateHTML() {
        StringBuilder sb = new StringBuilder(STAHTML.replace("{type}", "Daily"));
        sb.append(DAITHHTML).append(THFINALHTML);
        for (DailyData item : data) {
            if (item.isExist()) {
                sb.append(DAITRHTML.replace("{cssclass}", CSSOK).replace("{pkgname}", item.getPackageName()));
            } else {
                sb.append(DAITRHTML.replace("{cssclass}", CSSFAIL).replace("{pkgname}", item.getPackageName()));
            }
        }
        sb.append(EOFHTML);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/java/training_tracker/daily.html"))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int calculatePassed() {
        int sum = 0;
        for (DailyData item : data) {
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