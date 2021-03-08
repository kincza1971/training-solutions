package vaccinationproject.tableclasses;

import java.time.LocalDate;


public class Vaccination {
    private int id;
    private final LocalDate date;
    private final String status;
    private final String note;
    private final int citizen_id;
    private final String vacType;

    public Vaccination(int id, LocalDate date, String status, String note, int citizen_id,
                       String vacType) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.note = note;
        this.citizen_id = citizen_id;
        this.vacType = vacType;
    }

    public Vaccination(LocalDate date, String status, String note, int citizen_id, String vacType) {
        this.date = date;
        this.status = status;
        this.note = note;
        this.citizen_id = citizen_id;
        this.vacType = vacType;
    }

    public static Vaccination of(Vaccination vaccination, int vacid) {
        return new Vaccination(
                vacid,
                vaccination.getDate(),
                vaccination.getStatus(),
                vaccination.getNote(),
                vaccination.getCitizenId(),
                vaccination.getVaccinationType()
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

    public int getCitizenId() {
        return citizen_id;
    }

    public String getVaccinationType() {
        return vacType;
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
