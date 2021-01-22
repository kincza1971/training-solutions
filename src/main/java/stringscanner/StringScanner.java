package stringscanner;

import java.util.Scanner;

public class StringScanner {


    private void checkBlank(String string) {
        if (string==null || string.isBlank()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
    }

    private void checkEmpty(String string) {
        if (string==null || string.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
    }

    public int readAndSumValues(String intString, String delimiter){

        Scanner scanner = new Scanner(intString);
        if (delimiter != null && !delimiter.isBlank()) {
            scanner.useDelimiter(delimiter);
        }
        int sum = 0;
        while (scanner.hasNext()) {
            if(! scanner.hasNextInt()) {
                throw new IllegalArgumentException("Incorrect parameter string!");
            }
            sum += scanner.nextInt();
        }
        scanner.close();
        return sum;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString," ");
    }

    public String filterLinesWithWordOccurrences(String text, String word){
        checkBlank(text);
        checkEmpty(word);
        Scanner scanner = new Scanner(text);
        scanner.useDelimiter("%n");
        String line;
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.toUpperCase().contains(word.toUpperCase())) {
                sb.append(line);
                sb.append("\n");
            }
        }
        scanner.close();
        return sb.toString().trim();
    }

}
