package schoolrecords;

public class Subject {
    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean equals(Subject aSub) {
        return  (subjectName.toLowerCase().equals(aSub.getSubjectName().toLowerCase()));
    }
}
