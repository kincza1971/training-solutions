package test;



public class Test {
    private static final String LOWERCASE_HUN = "[a-záéíóöőúüű ]+?";

    public static void main(String[] args) {
        String akombakom= "láélás édgoőpkw aááűúőőöüóí";
        System.out.println (akombakom.matches(LOWERCASE_HUN));
    }
}