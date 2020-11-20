package schoolrecords;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.round;

public class Student {

    private List<Mark> marks = new ArrayList<>();
    private String name;

    private boolean isEmpty(String toCheck) {
        return  (toCheck == null || toCheck.isBlank());
    }

    public double calculateAverage(){
        int sum =0;
        int counter = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
            counter++;
        }
        if (counter>0) {
            return ((double) round(((double)sum/counter)*100))/100;
        }
        return 0.0;
    }
    public double calculateSubjectAverage(Subject subject){
        if (subject == null) {
            throw new NullPointerException("Subject must not be null");
        }
        int sum =0;
        int counter = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().equals(subject)) {
                sum += mark.getMarkType().getValue();
                counter++;
            }
        }
        if (counter>0) {
            return ((double) round(((double)sum/counter)*100))/100;
        }
        return 0.0;
    }

    public void grading(Mark mark){
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder(500);
        toPrint.append(name + " marks: ");
        for (Mark mark : marks) {
            toPrint.append(String.format("%s: %s(%d) ",
                    mark.getSubject().getSubjectName(),
                    mark.getMarkType().getDescription(),
                    mark.getMarkType().getValue()
                    )
            );
        }
        return toPrint.toString().trim();
    }

    public boolean equals(Student student) {
        return (name.toLowerCase().equals(student.getName().toLowerCase()));
    }


    public String getName() {
        return name;
    }

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }
}
