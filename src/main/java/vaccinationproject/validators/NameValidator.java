package vaccinationproject.validators;

import java.util.function.Predicate;

public class NameValidator implements Predicate<String> {
    @Override
    public boolean test(String name) {
        return !(name == null || name.isBlank());
    }
}
