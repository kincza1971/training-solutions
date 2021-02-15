package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {


    public String createHistogram(BufferedReader reader) {
        String line;
        StringBuilder sb = new StringBuilder();
        try  {
            while ((line = reader.readLine()) != null) {
                sb.append(addStars(line));
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private String addStars(String line) {
        int starCounter = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < starCounter; i++) {
            sb.append("*");
        }
        return sb.toString()+"\n";
    }

}
