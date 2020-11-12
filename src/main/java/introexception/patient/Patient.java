package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if ( name == null || name.equals("")) {
            throw new IllegalArgumentException("Név megadása kötelező");
        }
        this.name = name;
        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("A születés éve nem lehet 1900-nál kisebb");
        }
        if( new SsnValidator().isValidSsn(socialSecurityNumber) == false) {
            throw new IllegalArgumentException("Helytelen TB kártya szám");
        }
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }


}
