package week08.d05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Plane {

    public int flyOver(String filename) {
        try {
            InputStreamReader isr = new InputStreamReader(new BufferedInputStream(
                Plane.class.getResourceAsStream(filename)));
            int num =0;
            char[] mapPoint = new char[1];
            int maxOcean =0;
            int aktOcean =0;
            while ((num = isr.read(mapPoint)) ==1) {
                if (mapPoint[0] == '0') {
                    aktOcean++;
                    if (aktOcean > maxOcean) {
                        maxOcean = aktOcean;
                    }
                } else {
                    aktOcean =0;
                }
            }
            isr.close();
            return maxOcean;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("Can not read file",e);
    }
    }
}
