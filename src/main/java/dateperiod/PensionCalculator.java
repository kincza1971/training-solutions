package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PensionCalculator {

    private Period employmentPeriod;

    public PensionCalculator() {
        employmentPeriod = Period.ZERO;
    }

    public void addEmploymentPeriod(Period period) {
        employmentPeriod = employmentPeriod.plus(period).normalized();
    }

    public Period sumEmploymentPeriods() {
        return employmentPeriod.normalized();
    }

    public Period modifyByDays(Period period, int days) {
        return period.plusDays(days).normalized();
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
        return Period.between(fromDate, toDate).normalized();
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        stringValidator(fromDate, "Empty from date string, cannot use: ");
        stringValidator(toDate, "Empty to date string, cannot use: ");
        stringValidator(pattern, "Empty pattern string, cannot use: ");
        LocalDate dateFrom = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern(pattern));
        LocalDate dateTo = LocalDate.parse(toDate, DateTimeFormatter.ofPattern(pattern));

        return getPeriodBetweenDates(dateFrom, dateTo);
    }

    public int calculateTotalDays(Period period) {
        return period.getDays() + period.getYears() * 365 + period.getMonths() * 30;
    }

    public Period getEmploymentPeriod() {
        return employmentPeriod;
    }

    private boolean stringValidator(String s, String message) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException(message);
        }
        return true;
    }
}
