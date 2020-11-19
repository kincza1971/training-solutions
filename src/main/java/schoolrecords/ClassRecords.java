package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    private boolean isEmpty(String toCheck) {
        return  (toCheck == null || toCheck.isBlank());
    }

    public boolean addStudent(Student std) {
        if (std == null) {
            throw new NullPointerException("Student must not be empty");
        }
        for (Student student : students) {
            if (student.equals(std)) {
                return false;
            }
        }
        students.add(std);
        return true;
    }

    public boolean removeStudent(Student std) {
        if (std == null) {
            throw new NullPointerException("Student must not be empty");
        }
        int index = 0;
        for (Student student : students) {
            if (student.equals(std)) {
                students.remove(index);
                return true;
            }
            index ++;
        }
        return false;
    }

    public double calculateClassAverageBySubject(Subject subject){
        if (students.size() ==0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double avg = 0.0;
        double sum = 0.0;
        int counter = 0;
        for (Student student : students) {
            avg = student.calculateSubjectAverage(subject);
            if (avg != 0.0) {
                sum += avg;
                counter++;
            }
        }
        if (counter >0) {
            return ((double) Math.round(sum/counter*100))/100;
        } else {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
    }

    public double calculateClassAverage() {
        if (students.size() ==0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double avg = 0.0;
        double sum = 0.0;
        int counter = 0;
        for (Student student : students) {
            avg = student.calculateAverage();
            if (avg != 0.0) {
                sum += avg;
                counter++;
            }
        }
        if (counter >0) {
            return ((double) Math.round(sum/counter*100))/100;
        } else {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
    }


    public Student findStudentByName(String name) {
        if (students.size()==0) {
            throw new IllegalStateException("No students to search!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        for (Student student : students) {
            if (student.getName().equals(name)){
                return student;
            }
        }
        throw new IllegalArgumentException(String.format("Student by this name cannot be found! %s", name));
    }

    public String listStudentNames(){
        if (students.size()==0) {
            throw new IllegalArgumentException("No students to be listed");
        }
        List<String> list = new ArrayList<>();
        for (Student student : students) {
            list.add(student.getName());
        };
        list.sort(String.CASE_INSENSITIVE_ORDER);
        return list.toString().substring(1,list.toString().length()-1);
    }

    public Student repetition() {
        if (students.size()==0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()+1));
    }

    public List<StudyResultByName> listStudyResults() {
        if (students.size()==0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        List<StudyResultByName> result = new ArrayList<>();
        for (Student student : students) {
            result.add(new StudyResultByName(student.getName(),student.calculateAverage()));
        }
        return result;
    }

    public String getClassName() {
        return className;
    }

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }
}
