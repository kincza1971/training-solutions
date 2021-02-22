package exam03retake;

public class CdvCheck {


    private void isValidString(String toCheck) {
        if (toCheck == null || toCheck.length() != 10) {
            throw new IllegalArgumentException("Wrong string");
        }
    }

    public boolean check(String toCheck) {
        isValidString(toCheck);
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Integer.parseInt(toCheck.substring(i, i + 1)) * (i + 1);
            }
            if (sum % 11 == Integer.parseInt(toCheck.substring(9, 10))) {
                return true;
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        return false;
    }
}
