package week13.d01;

public class City {
    private final String postCode;
    private final String name;
    private final String district;

    public String getPostCode() {
        return postCode;
    }

    public String getName() {
        return name;
    }


    public City(String postCode, String name, String district) {
        this.postCode = postCode;
        this.name = name;
        this.district = district;
    }


    @Override
    public String toString() {
        return "("+ getPostCode() + "; " + getName()+ ")";
    }
}
