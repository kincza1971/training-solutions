package week05.d02;

public class ChangeLetter {
    public static String changeVowels (String str){
        if (str == null || str.isBlank()) throw new IllegalArgumentException("Paramater most not null");
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str);
        for (int i = 0; i<sb.length();i++) {
            switch (sb.charAt(i)) {
                case 'a' :
                case 'A' :
                case 'e' :
                case 'E' :
                case 'i' :
                case 'I' :
                case 'o' :
                case 'O' :
                case 'u' :
                case 'U' :
                    sb.replace(i,i+1,"*");
            }
        }
        return sb.toString();
    }

    public static String changeVowels2 (String str){
        if (str == null || str.isBlank()) throw new IllegalArgumentException("Paramater most not null");
        StringBuilder sb = new StringBuilder(str.length());
        String toReplace = "aAeEiIoOuU";
        for (int i = 0; i<str.length();i++) {
            if (toReplace.contains(""+ str.charAt(i)) ) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


}
