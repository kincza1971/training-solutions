package vaccinationproject.validators;

import java.util.function.Predicate;

public class SocIdValidator implements Predicate<String> {
    @Override
    public boolean test(String s) throws IllegalArgumentException {
        if (s == null || s.isBlank() || s.length() != 9) {
            throw new IllegalArgumentException("TAJ cannot be null or different length than 9: " + s);
        }
        int sum = 0;
        int c;
        for (int i = 0; i < 8; i++) {
            c = Character.getNumericValue(s.charAt(i));
            sum += (i % 2 == 0 ? c * 3 : c * 7);
        }
        return (sum % 10 == Character.getNumericValue(s.charAt(8)));
    }
}
