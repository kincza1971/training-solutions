package testelek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalService {

    public static void main(String[] args) {
        AnimalService animalService = new AnimalService();
        List<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("A");
        letters.add("C");
        letters.add("B");

        System.out.println(letters);
        Collections.sort(letters);
        System.out.println(letters);
    }
}

