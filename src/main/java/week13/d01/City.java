package week13.d01;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class City {
    private final String postCode;
    private final String name;
//    private final String district;

    public String getPostCode() {
        return postCode;
    }

    public String getName() {
        return name;
    }

//    public String getDistrict() {
//        return district;
//    }

    public City(String postCode, String name) {
        this.postCode = postCode;
        this.name = name;
//        this.district = district;
    }


    @Override
    public String toString() {
        return "("+ getPostCode() + "; " + getName()+ ")";
    }
}
