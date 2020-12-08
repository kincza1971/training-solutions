package exceptions.faults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    private void checkList(List<String> lines) {
        if (lines == null || lines.size() == 0){
            throw new IllegalArgumentException("processLines is null or empty");
        }
    }

    private String result(String number,String codename) {
        return String.format("%s,%s", number,codename);
    }

    private String parseDouble(String s) {
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException nfx){
            return ProcessingResult.VALUE_ERROR.name();
        }
        return ProcessingResult.NO_ERROR.name();
    }

    private String parseDate(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.d.");
        try {
            LocalDate.parse(s,formatter);
        }
        catch (Exception nfx) {
             return ProcessingResult.DATE_ERROR.name();
        }
        return ProcessingResult.NO_ERROR.name();
    }

    private String processLineParts(String[] fields) {
        if (parseDouble(fields[1]) != "NO_ERROR") {
            if (parseDate(fields[2]) != "NO_ERROR") {
                return result(fields[0], ProcessingResult.VALUE_AND_DATE_ERROR.name());
            } else {
                return result(fields[0], ProcessingResult.VALUE_ERROR.name());
            }
        }
        if (parseDate(fields[2]) != "NO_ERROR") {
            return result(fields[0], ProcessingResult.DATE_ERROR.name());
        }
        return result(fields[0], ProcessingResult.NO_ERROR.name());
    }

    private String  processOneLine(String line) {
        String[] fields = line.split(",");
        if (fields.length != 3) {
            return result(fields[0], ProcessingResult.WORD_COUNT_ERROR.name());
        }
        if (parseDouble(fields[0])!="NO_ERROR") {
            return ProcessingResult.COMMENT.getCode();
        }
        return processLineParts(fields);
    }

    public List<String> processLines(List<String> lines) {
        checkList(lines);
        List<String> errorList = new ArrayList<>();
        String result;

        for (String line : lines) {
            result = processOneLine(line);
            if (!(result.contains(ProcessingResult.NO_ERROR.getCode()) || result.contains(ProcessingResult.COMMENT.getCode()))) {
                errorList.add(result);
            }
        }

        return errorList;
    }



}
