
package training_tracker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Math.round;
import static training_tracker.Resources.*;

public class DetailGenerator {
    public void generateHTML(int daipass, int dayall, int lesspass, int lessall) {
        double daiperc = (double) daipass / dayall;
        double lesperc = (double) lesspass / lessall;
        double sumperc = (double) (daipass + lesspass) / (dayall + lessall);
        StringBuilder sb = new StringBuilder(STAHTML.replace("{type}", "Details"));
        sb.append(DETTHHTML).append(THFINALHTML);
        sb.append(DETTRHTML.replace("{type}", "Lessons").replace("{all}", String.valueOf(lessall)).replace("{succes}", String.valueOf(lesspass)).replace("{fail}", String.valueOf(lessall - lesspass)).replace("{percent}", String.valueOf(round(lesperc*10000)/100)));
        sb.append(DETTRHTML.replace("{type}", "Daily").replace("{all}", String.valueOf(dayall)).replace("{succes}", String.valueOf(daipass)).replace("{fail}", String.valueOf(dayall - daipass)).replace("{percent}", String.valueOf(round(daiperc*10000)/100)));
        sb.append(DETTRHTML.replace("{type}", "Summa").replace("{all}", String.valueOf(lessall)).replace("{succes}", String.valueOf(daipass + lesspass)).replace("{fail}", String.valueOf((dayall + lessall) - (daipass + lesspass))).replace("{percent}", String.valueOf(round(sumperc*10000)/100)));
        sb.append(SOUHTML).append(EOFHTML);
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/java/training_tracker/main.html"))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}