package week02;

public class product {
    private String name;
    private String code;

    public product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(product p) {

        return ((this.name.equals(p.getName())) && (java.lang.Math.abs((this.code).length() - p.getCode().length()) <= 1));
    }


}
