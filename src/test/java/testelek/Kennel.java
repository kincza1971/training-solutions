package testelek;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        throw new IllegalArgumentException("Dog cannot be found by this name");
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<Dog> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                       .filter(dog -> dog.getHappiness() > minHappiness)
                       .collect(Collectors.toList());
    }

}
//Legyen egy Kennel osztály, mely nyilvántartja a kutyákat. A következő metódusokat implementáld:
//
//void addDog(Dog dog) - hozzáaad egy kutyát
//feedAll() - összes kutya feed() metódusát meghívja
//Dog findByName(String name) - kikeresi a kutyát név alapján, kivételt dob, ha nem találja
//void playWith(String name, int hours) - a paraméterként megadott kutyát kikeresi, és meghívja a play() metódusát az
// átadott hours paraméterrel
//List<String> getHappyDogNames(int minHappiness) - visszaadja azon kutyák neveit, melyeknek boldogsága nagyobb,
// mint a paraméterként átadott érték