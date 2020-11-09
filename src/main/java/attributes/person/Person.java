package attributes.person;


public class Person {
    private String name;
    private String identificationCard;
    private Address address;

    public String personToString(){
        return name + ", " + identificationCard;
    }

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void moveTo (String country, String city, String streetAndNumber, String zipCode) {
        address = new Address(country, city, streetAndNumber, zipCode);
    }

    public String getAddress(){
        return address.addressToString();
    }

}
