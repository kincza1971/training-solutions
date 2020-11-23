package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class TeachingStaff {

    private List<Tutor> staff;

    public boolean addTutor(Tutor newTutor) {
        if (staff==null) throw new NullPointerException("Tutor must not empty");
        for (Tutor tutor : staff) {
            if (tutor.equals(newTutor)) return false;
        }
        return true;
    }

    public Tutor findTutorByName(String name) {
        for (Tutor tutor : staff) {
            if (tutor.getName().toLowerCase().equals(name.toLowerCase())) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("Tutor name is invalid " + name);
    }


    public TeachingStaff(List<Tutor> staff) {
        if (staff == null) {
            staff = new ArrayList<>();
        } else {
            this.staff = staff;
        }
    }
}
