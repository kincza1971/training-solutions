package vaccinationproject.validators;

import java.util.Map;
import java.util.function.Predicate;

public class VaccineValidator implements Predicate<String> {
    private final Map<Integer, String> vacType;

    public VaccineValidator(Map<Integer, String> vacType) {
        this.vacType = vacType;
    }

    @Override
    public boolean test(String s) {
        try {
            int type = Integer.parseInt(s);
            return vacType.containsKey(type);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
