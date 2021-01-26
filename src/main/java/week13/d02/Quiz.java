package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    private char[] goodAnswers;
    private Map<String, List<Character>> results = new HashMap<>();

    public void loadFromFile(BufferedReader reader){
        try (reader){
            readLine(reader);
        }catch(IOException ioe){
            throw new IllegalArgumentException("can not read file", ioe);
        }
    }

    private void readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        goodAnswers = line.toCharArray();
        while ((line = reader.readLine())!=null){
            processLine(line);
        }
    }

    private void processLine(String line) {
        String[] data = line.split(" ");
        if (!results.containsKey(data[0])){
            results.put(data[0],new ArrayList<>());
        }
        results.get(data[0]).add(data[1].charAt(0));
    }

    public boolean isGoodAnswer(String code, int index){
        Character result = results.get(code).get(index);
        return result.equals(goodAnswers[index]);
    }

    public String mostSkippedCode(){
        String code = "";
        int max = 0;
        for(Map.Entry<String,List<Character>> entrie:results.entrySet()){
            int counter = getXCounter(entrie);
            if(max<counter){
                code = entrie.getKey();
                max = counter;
            }
        }
        return code;
    }

    private int getXCounter(Map.Entry<String, List<Character>> entrie) {
        int counter = 0;
        for (Character c: entrie.getValue()) {
            if(c == 'X'){
                counter++;
            }
        }
        return counter;
    }

    public String getWinner(){
        String code = "";
        int max = 0;
        for(Map.Entry<String,List<Character>> entrie:results.entrySet()){
            int counter = getCounter(entrie);
            if(max<counter){
                code = entrie.getKey();
                max = counter;
            }
        }
        return code;
    }

    private int getCounter(Map.Entry<String, List<Character>> entrie) {
        int counter = 0;
        for (int i = 0; i < entrie.getValue().size(); i++) {
            if(isGoodAnswer(entrie.getKey(),i)){
                counter+=i+1;
            }else{
                if(entrie.getValue().get(i) != 'X'){
                    counter -=2;
                }
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.loadFromFile(new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("results.txt"))));

        System.out.println(quiz.isGoodAnswer("AB123",0));
        System.out.println(quiz.mostSkippedCode());
        System.out.println(quiz.getWinner());
    }
}