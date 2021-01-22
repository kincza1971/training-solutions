package stringbuilder;

public class PalindromeValidator {
    public boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word.trim().toUpperCase());
        return sb.toString().equals(sb.reverse().toString());
    }


    public static void main(String[] args) {
        PalindromeValidator pv = new PalindromeValidator();
        System.out.println(pv.isPalindrome("zörög"));
        System.out.println(pv.isPalindrome("Görög"));
    }
}

