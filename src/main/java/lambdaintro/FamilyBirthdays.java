package lambdaintro;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private final LocalDate[] birthDays;

    public boolean isFamilyBirthday(LocalDate date) {
        return Arrays.stream(birthDays).anyMatch(a -> a.equals(date));
    }

    public FamilyBirthdays(LocalDate... birthDays) {
        this.birthDays = birthDays;
    }
}
