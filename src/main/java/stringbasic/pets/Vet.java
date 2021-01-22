package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();


    public List<Pet> getPets() {
        return pets;
    }

    public List<Pet> add(Pet pet) {
        for (Pet aPet : pets) {
            if (aPet.registrationNumber.equals(pet.registrationNumber)) {
                return pets;
            }
        }
        pets.add(pet);
        return pets;
    }

    public static void main(String[] args) {
        String password1 = "John123";
        String password2 = "John123";

        System.out.println(password1 == password2);
        System.out.println(password1.toUpperCase() == password2.toUpperCase());
    }
}

