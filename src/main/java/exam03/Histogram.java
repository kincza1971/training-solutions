package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {


    public String createHistogram(BufferedReader reader) {
        String line;
        StringBuilder sb = new StringBuilder();
        String star = "*";
        try  {
            while ((line = reader.readLine()) != null) {
                sb.append(star.repeat(Integer.parseInt(line)) + "\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }


}
