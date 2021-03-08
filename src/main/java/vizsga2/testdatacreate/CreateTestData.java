package vizsga2.testdatacreate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CreateTestData {
    private List<String> zipCodes;
    private Random rnd = new Random();


    public void createTestFile() {
        fillZip();
        try (BufferedReader br =
                     Files.newBufferedReader(Path.of("src/main/resources/covidtestfiles",
                             "/registered_persons_UTF8.csv"),
                             StandardCharsets.UTF_8)) {
            String line = "";
            String[] parts;
            List<String> lines = br.lines()
                                         .skip(1)
                                         .map(this::fillZipInFile)
                                         .collect(Collectors.toList());
            writeToFile(lines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file - registered_person", e);
        }
    }

    private void fillZip() {
        try (BufferedReader br = Files.newBufferedReader(
                Path.of("src/main/resources/covidtestfiles"
                        , "osszes_iranyitoszam.csv"), StandardCharsets.UTF_8)
        ) {
            zipCodes = br.lines()
                               .map(m -> m.split(";")[0])
                               .collect(Collectors.toList());
            Collections.shuffle(zipCodes);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file - telepulesek", e);
        }
    }

    private String fillZipInFile(String line) {
        String[] parts = line.split(";");
        parts[1] = getValidZipCode(100);
        if (Integer.parseInt(parts[2]) > 100) {
            parts[2] = Integer.toString((Integer.parseInt(parts[2]) - 50));
        }
        return Arrays.stream(parts).collect(Collectors.joining(";", "", "\n"));
    }


    private String getValidZipCode(int maxZipCodes) {
        int maxNumberOfZipsToUse = Integer.min(zipCodes.size(), maxZipCodes);//for test cases
        return zipCodes.get((rnd.nextInt(maxNumberOfZipsToUse)));
    }

    private String getValidZipCode() {
        return zipCodes.get(rnd.nextInt(zipCodes.size()));
    }


    private void writeToFile(List<String> lines) {
        try (BufferedWriter bw =
                     Files.newBufferedWriter(Path.of("src/main/resources/covidtestfiles"
                             , "registered_tesztfile.csv"), StandardCharsets.UTF_8)) {
            for (String line : lines) {
                bw.write(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file");
        }
    }


    private boolean validSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        char[] chars = ssn.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int num = Character.getNumericValue(chars[i]);
            sum += i % 2 == 0 ? num * 3 : num * 7;
        }
        int cNumber = Character.getNumericValue(chars[chars.length - 1]);
        return sum % 10 == cNumber;
    }

    public static void main(String[] args) {
        CreateTestData td = new CreateTestData();
        td.createTestFile();
    }
}
