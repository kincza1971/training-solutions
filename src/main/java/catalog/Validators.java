package catalog;

import java.util.Collection;
import java.util.List;

public class Validators {

    public static boolean isBlank(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List listToCheck) {
        if (listToCheck == null || listToCheck.isEmpty()) {
            return true;
        }
        return false;
    }

}
