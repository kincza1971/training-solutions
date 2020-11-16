package week04;

public class NameChanger {
    private String fullName;
    private String vezetekNev;
    private String keresztNev;

    public void changeFirstName(String firstName) {
        if (firstName== null || firstName.isBlank()) {
            throw new IllegalArgumentException ("Invalid name: " + firstName);
        }
        this.vezetekNev = firstName;
        fullName = vezetekNev + " " + keresztNev;
    }

    public NameChanger(String fullName) {
        if (fullName== null || fullName.isBlank()) {
            throw new IllegalArgumentException ("Invalid name: " + fullName);
        }
        String[] names = fullName.split(" ");
        this.fullName = fullName;
        vezetekNev = names[0];
        keresztNev = names[1];
    }

    public String getFullName() {
        return fullName;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public String getKeresztNev() {
        return keresztNev;
    }
}
