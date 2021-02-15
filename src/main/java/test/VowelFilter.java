package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VowelFilter {
    
    private final String vowels = "aáeéiíoóöőuúüű" + "aáeéiíoóöőuúüű".toUpperCase(Locale.ROOT); 
    
    public String filterVowels(BufferedReader reader) {
        String line;
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(removeVowels(line));
            }
            return sb.toString().trim();
        } catch(IOException e) {
            throw new IllegalStateException("Cannot read file!");
        }
    }
    
    private String removeVowels(String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (!vowels.contains(line.substring(i,i+1))) {
                sb.append(line.substring(i,i+1));
            }
        }
        return sb.toString() + "%n";
    }

    private String addStars(String line) {
        int starCounter = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < starCounter; i++) {
            sb.append("*");
        }
        return sb.toString()+"%n";
    }

    public String Histogram(Path file) {
        try  {
            String result= Files.lines(file).reduce("",(part,stars) -> part = part+stars);
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }
}
