package week12.d02;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LandReader {
    public static final int INDEX_OF_SIDE = 0;
    public static final String FIELD_SEPARATOR = " ";
    public static final int INDEX_OF_WIDTH = 1;
    public static final int INDEX_OF_COLOR = 2;
    private int lastHouseNumber;
    private Set<Land> landSet = new TreeSet<>();
    private List<Land> landList = new ArrayList<>();
    int nextEvenNumber;
    int nextOddNumber;



    private void parseLand(String line) {
        String[] lineParts = line.split(FIELD_SEPARATOR);

        int fenceWidth = Integer.parseInt(lineParts[INDEX_OF_WIDTH]);
        String fenceColor = lineParts[INDEX_OF_COLOR];
        Side side = Side.valueOf(lineParts[INDEX_OF_SIDE]);

        Land land = createLand(fenceWidth, fenceColor, side);

        landSet.add(land);
        landList.add(land);
    }

    private Land createLand(int fenceWidth, String fenceColor, Side side) {
        if (side == Side.EVEN) {
            lastHouseNumber = nextEvenNumber;
            nextEvenNumber += 2;
        } else {
            lastHouseNumber = nextOddNumber;
            nextOddNumber += 2;
        }
        return new Land(side, fenceWidth, fenceColor, lastHouseNumber);
    }

    public void readLand(InputStream is) {
       try (BufferedReader bf = new BufferedReader(new InputStreamReader(is))) {
            String line;
            nextEvenNumber = 2;
            nextOddNumber = 1;
            while ((line = bf.readLine()) != null) {
                parseLand(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    public void saveSideToFile(String file, Side side) {
        Path path = Path.of(file);
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for(Land land : landList){
                if (land.getSide()==side) {
                    bw.write(land.toString());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file!", ioe);
        }
    }

    public Set<Land> getLandSet() {
        return landSet;
    }

    public int getLastHouseNumber() {
        return lastHouseNumber;
    }

}