package exam02.lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {
    private InputStream is;
    private int [] numCounter = new int[90];

    private void getNumbers(){
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        String[] parts;
        try {
            while ((line = br.readLine()) != null) {
                parts= line.split(";");

            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public LottoReader(InputStream is) {
        this.is = is;

    }
}
