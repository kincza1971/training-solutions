package vaccinationproject.validators;

import java.util.function.Predicate;

public class AgeValidator implements Predicate<String> {

    @Override
    public boolean test(String ageStr) {
        int age;
        try {
            age = Integer.parseInt(ageStr);
            return (age > 10 && age < 150);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
