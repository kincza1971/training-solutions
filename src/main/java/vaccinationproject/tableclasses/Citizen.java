package vaccinationproject.tableclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Citizen {
    private final int id;
    private final String fullName;
    private final String zipCode;
    private final int age;
    private final String mail;
    private final String socialId;
    private int numberOfVaccination;
    private LocalDate dateOfLastVaccination;
    private List<Vaccination> vaccinations = new ArrayList<>();
    private String lastVaccinationType;


    public Citizen(String fullName, String zipCode, int age, String mail, String socialId) {
        this.fullName = fullName;
        this.zipCode = zipCode;
        this.age = age;
        this.mail = mail;
        this.socialId = socialId;
        id = 0;
    }

    public Citizen(int id, String fullName, String zipCode, int age, String mail, String socialId) {
        this.id = id;
        this.fullName = fullName;
        this.zipCode = zipCode;
        this.age = age;
        this.mail = mail;
        this.socialId = socialId;
    }

    public Citizen(int id, String fullName, String zipCode, int age, String mail, String socialId,
                   int numberOfVaccination, LocalDate dateOfLastVaccination, List<Vaccination> vaccinations) {

        this(id, fullName, zipCode, age, mail, socialId);

        this.numberOfVaccination = numberOfVaccination;
        this.dateOfLastVaccination = dateOfLastVaccination;
        this.vaccinations = vaccinations;

        if (vaccinations != null) {
            if (!vaccinations.isEmpty()) {
                this.lastVaccinationType = vaccinations.get(0).getVaccinationType();
            }
        }
    }

    public Citizen(String fullName, String zipCode, int age, String mail, String socialId,
                   int numberOfVaccination, LocalDate dateOfLastVaccination, List<Vaccination> vaccinations) {

        this(fullName, zipCode, age, mail, socialId);

        this.numberOfVaccination = numberOfVaccination;
        this.dateOfLastVaccination = dateOfLastVaccination;
        this.vaccinations = vaccinations;
    }


    public static Citizen of(Citizen citizen, int id) {
        return new Citizen(
                id,
                citizen.getFullName(),
                citizen.getZipCode(),
                citizen.getAge(),
                citizen.getMail(),
                citizen.getSocialId(),
                citizen.getNumberOfVaccination(),
                citizen.getDateOfLastVaccination(),
                citizen.getVaccinations()
        );
    }

    public String getFullName() {
        return fullName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getSocialId() {
        return socialId;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDate getDateOfLastVaccination() {
        return dateOfLastVaccination;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public int getId() {
        return id;
    }

    public String getLastVaccinationType() {
        return lastVaccinationType;
    }

    public Citizen vaccinate(Vaccination vaccination) {
        List<Vaccination> newVaccinations = new ArrayList<>();
        List<Vaccination> oldVaccinations = getVaccinations();
        newVaccinations.add(vaccination);
        if (oldVaccinations != null) {
            if (!oldVaccinations.isEmpty()) {
                newVaccinations.addAll(getVaccinations());
            }
        }
        this.vaccinations = newVaccinations;
        this.numberOfVaccination = getNumberOfVaccination() + 1;
        this.dateOfLastVaccination = vaccination.getDate();
        this.lastVaccinationType = vaccination.getVaccinationType();
        return this;
    }

    public String getFullData() {
        return "Citizen{" +
                       "id=" + id +
                       ", fullName='" + fullName + '\'' +
                       ", zipCode='" + zipCode + '\'' +
                       ", age=" + age +
                       ", mail='" + mail + System.lineSeparator() + "," +
                       " socialId='" + socialId + '\'' +
                       ", numberOfVaccination=" + numberOfVaccination +
                       ", dateOfLastVaccination=" + dateOfLastVaccination +
                       ", vaccineType='" + lastVaccinationType + '\'' +
                       '}';
    }

    public String getShortData() {
        return fullName + '\'' +
                       ", TAJ: " + socialId + '\'' +
                       ", eddigi oltások: " + numberOfVaccination +
                       ", Utolsó oltás dátuma: " + dateOfLastVaccination +
                       ", Oltás típusa'" + lastVaccinationType + '\'' +
                       '}';
    }

    public String getVaccinationFileLine() {
        return fullName + ";" +
                       zipCode + ";" +
                       age + ";" +
                       mail + ";" +
                       socialId;
    }

    @Override
    public String toString() {
        return fullName + ";" +
                       zipCode + ";" +
                       age + ";" +
                       mail + ";" +
                       socialId;
    }
}
