package vaccinationproject.validators;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameValidator implements Predicate<String> {
    private final String regex = "[\\w]+\\.[\\w]{0,}";

    @Override
    public boolean test(String emailStr) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailStr);
        if (matcher.matches()) {
            return true;
        }
        throw new IllegalArgumentException("invalid email address:" + emailStr);
    }

}
