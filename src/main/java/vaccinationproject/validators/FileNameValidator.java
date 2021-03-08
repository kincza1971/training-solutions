package vaccinationproject.validators;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameValidator implements Predicate<String> {

    @Override
    public boolean test(String emailStr) throws IllegalArgumentException {
        String regex = "[\\w]+\\.[\\w]{0,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.matches();
    }

}
