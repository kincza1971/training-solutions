package training;

public class Trainer {
    private String name;
    private int yearOfBirth;

    public String getName() {
        return name;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setName (String name) {
        this.name=name;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth=yearOfBirth;
    }
    public String getNameAndAge(int year) {
        return "Név: " + this.name + "  Életkor: " + (year-this.yearOfBirth);
    }

    public Trainer(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

}
