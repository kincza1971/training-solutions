package schoolrecords;

import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects;

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject ts : taughtSubjects) {
            if (ts.equals(subject)) {
                return true;
            }
        }
        return false;
    }



    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }
}
