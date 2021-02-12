package week15.d04.junior;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidCases {

    public static final String FIELD_SEPARATOR = ",";
    public static final int WEEK_INDEX = 1;
    public static final int NUMBER_OF_CASES_INDEX = 2;

    private final Path path = Path.of("src/main/resources","data.csv");
    private final Map<String,Integer> weeks = new HashMap<>();

    public List<String> getYearWeekOfMostCases() {
        loadFromFile();
        Map<Integer,String> sortedMap = new TreeMap<>();
        createSortedMap(sortedMap);
        int i = 0;
        List<String> result = new ArrayList<>();
        for (int key : sortedMap.keySet()) {
            result.add(sortedMap.get(key));
            if (++i >2) {
                return result;
            }
        }
        return result;
    }

    private void createSortedMap(Map<Integer, String> sortedMap) {
        for (String key : weeks.keySet()) {
            sortedMap.put(Integer.MAX_VALUE-weeks.get(key), key);
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line = br.readLine();
            while ((line=br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processLine(String line) {
        String[] lineParts = line.split(FIELD_SEPARATOR);
        String key = lineParts[WEEK_INDEX];
        int value = Integer.parseInt(lineParts[NUMBER_OF_CASES_INDEX]);
        if (weeks.containsKey(key)) {
            weeks.put(key,Integer.sum(value,weeks.get(key)));
        } else {
            weeks.put(key,value);
        }
    }

    private String getWeek(String line) {
        return line.split(",")[WEEK_INDEX];
    }

    private int getCaseNumber(String line) {
        return Integer.parseInt(line.split(",")[NUMBER_OF_CASES_INDEX]);
    }


    private List<String> getThreeWeek(Map<String, IntSummaryStatistics> weeks) {
        Map<Long,String> sortedMap = new TreeMap<>();
        for (Map.Entry<String,IntSummaryStatistics> entry : weeks.entrySet()) {
            sortedMap.put(Long.MAX_VALUE - entry.getValue().getSum(),entry.getKey());
        }
        return sortedMap.values().stream().limit(3).collect(Collectors.toList());
    }

    public List<String> case2() {
        try (Stream<String> stream = Files.lines(path)){
            Map<String, IntSummaryStatistics> weeks2 =
                    stream.skip(1)
                    .collect(Collectors.groupingBy(this::getWeek,Collectors.summarizingInt(this::getCaseNumber)));
            return getThreeWeek(weeks2);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public static void main(String[] args) {
        CovidCases cc = new CovidCases();
        System.out.println(cc.getYearWeekOfMostCases());
        System.out.println(cc.case2());
    }
}
