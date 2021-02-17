package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    public static final String EMPTY_PATTERN_ERROR = "Empty pattern string, cannot use: ";
    public static final String LOCALE_NULL = "Locale must not be null!";
    public static final String DATE_NULL = "Date cannot be null!";
    private final LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String date, String pattern, Locale locale) {
        checkObjectParam(locale, LOCALE_NULL);
        checkString(date, DATE_NULL);
        checkString(pattern, EMPTY_PATTERN_ERROR);
        this.dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern).withLocale(locale));
    }

    public DateOfBirth(String date, String pattern) {
        checkString(date, DATE_NULL);
        checkString(pattern, EMPTY_PATTERN_ERROR);
        this.dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }


    public String findDayOfWeekForBirthDate(Locale locale) {
        checkObjectParam(locale, LOCALE_NULL);
        return getDateOfBirth().getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate otherDate) {
        checkObjectParam(locale, LOCALE_NULL);
        checkObjectParam(otherDate, DATE_NULL);
        return otherDate.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }


    public long countDaysBetween(DateOfBirth otherDate) {
        return ChronoUnit.DAYS.between(getDateOfBirth(), otherDate.dateOfBirth);
    }

    public long countDaysSinceBirth(LocalDate date) {
        if (date.isBefore(getDateOfBirth())) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return ChronoUnit.DAYS.between(getDateOfBirth(), date);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString(String pattern) {
        checkString(pattern, EMPTY_PATTERN_ERROR);
        return dateOfBirth.format(DateTimeFormatter.ofPattern(pattern));
    }

    private void checkObjectParam(Object o, String message) {
        if (o == null) {
            throw new NullPointerException(message);
        }
    }

    private void checkString(String toCheck, String message) {
        if (toCheck == null || toCheck.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}

//Életünk nevezetes dátumairól (DateOfBirth osztály) szeretnénk speciális információkat kapni, mint például: 
//      a hét mely napján születtünk, 
//      eddig összesen hány napot éltünk, vagy 
//      a saját és barátunk/párunk születése között pontosan hány nap telt el. 
// A dátumokat tetszőlegesen formázott String formájában is szeretnénk látni.
//Hibakezelés
//      Üres pattern esetén dobjon IllegalArgumentException-t az adott metódus. 
//      A Locale nem lehet null. 
//      Ha rossz dátumot adtunk meg születési dátumként, a countDaysSinceBirth() metódus dobjon IllegalStateException-t
//
//Tippek
//Használd a ChronoUnit enumot arra, hogy kiszámold, hány nap van két dátum között! Szervezzük külön metódusba az azonos paraméterek ellenőrzését!
