package introexception.patient;

public class SsnValidator {
    public boolean isValidSsn(String ssn) {
        if ((ssn == null) || (ssn.length() != 9)) {
            return false;
        }
        int chksum = 0;
        char ch;
        for (int i = 0; i < 9; i++) {
            ch = ssn.charAt(i);
//            if ("1234567890".indexOf( ch )  <0) {  // ez a megoldás is hibátlanul megy
//                return false;
//            }
            try {
                if (i < 8) {
                    if (i % 2 == 0) {
                        chksum += Integer.parseInt("" + ch) * 3;
                    } else {
                        chksum += Integer.parseInt("" + ch) * 7;
                    }
                } else {
                    return (chksum % 10 == Integer.parseInt("" + ch));
                }
            } catch (IllegalArgumentException iae) {
                return false;
            }
        }
        return false;
    }

    public SsnValidator() {
    }
}
