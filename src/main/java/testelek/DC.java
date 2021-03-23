package testelek;

import java.util.regex.Pattern;

public class DC {
    public int getCountsOfDigits(String s) {
        StringBuilder sb = new StringBuilder(10);
        Pattern p = Pattern.compile("[0-9]");
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (p.matcher(sub).matches()) {
                if (sb.indexOf(sub) < 0) {
                    sb.append(sub);
                }
            }
        }
        return sb.length();
    }
}
