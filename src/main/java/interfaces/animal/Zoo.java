package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    List<Animal> animals;

    public int getNumberOfLegs() {
        int legCounter = 0;
        for (Animal animal : animals) {
            legCounter += animal.getNumberOfLegs();
        }
        return legCounter;
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }
}
