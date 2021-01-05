package week10.d01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class HikingFile {

    private Differences diff = new Differences();


    private Pos createPos(String line) {
        double x;
        double y;
        double alt;
        String[] posLine = line.split(",");
        x = Double.parseDouble(posLine[0]);
        y = Double.parseDouble(posLine[1]);
        alt = Double.parseDouble(posLine[2]);
        return new Pos(x,y,alt);
    }

    public Differences getPlusElevation(InputStream IS) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(IS));
        Pos prevPos = null;
        Pos pos = null;
        try {
            String line;
            while ((line =reader.readLine()) != null) {
                if (prevPos == null) {
                    prevPos = createPos(line);
                } else {
                    pos = createPos(line);
                    diff.add(pos.getAlt() - prevPos.getAlt());
                    prevPos = pos;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot read file");
        }
        return diff;
    }


}
