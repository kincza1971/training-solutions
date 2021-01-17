package collectionsmap;

import java.time.LocalDate;
import java.util.*;

public class LogParser {


    public static final String LINE_SEPARATOR = "\n";
    public static final String FIELD_SEPARATOR = ":";
    public static final int NUMBER_OF_FIELDS = 3;
    public static final int YEAR_INDEX = 0;
    public static final int IP_INDEX = 0;
    public static final int DATE_INDEX = 1;
    public static final int MONTH_INDEX = 1;
    public static final int DAY_INDEX = 2;
    public static final int LOGIN_INDEX = 2;

    private void checkLog(String log) {
        if (log==null || log.isBlank()) {
            throw new IllegalStateException("Incorrect log: Null or Empty");
        }
    }

    private LocalDate parseDate(String strDate) {

        String[] parts = strDate.split("-");
        if (parts.length != NUMBER_OF_FIELDS) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
        return LocalDate.of(
                Integer.parseInt(parts[YEAR_INDEX]),
                Integer.parseInt(parts[MONTH_INDEX]),
                Integer.parseInt(parts[DAY_INDEX]));
    }

    private Entry parseEntry(String line) {
        String[] parts = line.split(FIELD_SEPARATOR);
        if (parts.length!= NUMBER_OF_FIELDS) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        return new Entry(parts[IP_INDEX],parseDate(parts[DATE_INDEX]),parts[LOGIN_INDEX]);
    }

    private void addEntry(Map<String, List<Entry>> logMap, Entry entry) {
        List<Entry> entryList;
        if (logMap.containsKey(entry.getIpAddress())) {
            logMap.get(entry.getIpAddress()).add(entry);
        } else {
            entryList = new ArrayList<>();
            entryList.add(entry);
            logMap.put(entry.getIpAddress(),entryList);
        }
    }

    public Map<String, List<Entry>> parseLog(String log) {
        checkLog(log);
        String[] logLines = log.split(LINE_SEPARATOR);

        Entry entry;
        Map<String,List<Entry>> logMap= new TreeMap<>();

        for (String line : logLines) {
            entry = parseEntry(line);
            addEntry(logMap, entry);
        }

        return logMap;
    }

}
