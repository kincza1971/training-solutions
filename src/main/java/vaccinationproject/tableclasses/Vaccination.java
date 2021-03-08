package vaccinationproject.tableclasses;

import java.time.LocalDate;


public class Vaccination {
    private int id;
    private LocalDate date;
    private String status;
    private String note;
    private int citizen_id;
    private String String;

    public Vaccination(int id, LocalDate date, String status, String note, int citizen_id,
                       String String) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.note = note;
        this.citizen_id = citizen_id;
        this.String = String;
    }

    public Vaccination(LocalDate date, String status, String note, int citizen_id, String String) {
        this.date = date;
        this.status = status;
        this.note = note;
        this.citizen_id = citizen_id;
        this.String = String;
    }

    public static Vaccination of(Vaccination vaccination, int vacid) {
        return new Vaccination(
                vacid,
                vaccination.getDate(),
                vaccination.getStatus(),
                vaccination.getNote(),
                vaccination.getCitizen_id(),
                vaccination.getVacccinationType()
        );
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public int getCitizen_id() {
        return citizen_id;
    }

    public String getVacccinationType() {
        return String;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                       "id=" + id +
                       ", date=" + date +
                       ", status=" + status +
                       ", note='" + note + '\'' +
                       ", citizen_id=" + citizen_id +
                       '}';
    }
}
