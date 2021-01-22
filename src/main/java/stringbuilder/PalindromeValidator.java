package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word.toUpperCase());
        return sb.equals(sb.reverse());
    }


    public static void main(String[] args) {
        PalindromeValidator pv = new PalindromeValidator();
        System.out.println(pv.isPalindrome("Görög"));
    }
}

