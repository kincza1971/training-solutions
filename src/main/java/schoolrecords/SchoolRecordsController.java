package schoolrecords;

import org.junit.platform.commons.function.Try;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Array;
import java.util.*;

public class SchoolRecordsController {


    private Tutor tutor1 = new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("földrajz"),
                    new Subject("matematika"),
                    new Subject("biológia")
            ));

    private Tutor tutor2 = new Tutor("Nagy Csilla",
            Arrays.asList(new Subject("zene"),
                    new Subject("fizika"),
                    new Subject("kémia")));

    private List<Tutor> tutors= new ArrayList<>(Arrays.asList(tutor1,tutor2));


    private ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random(5));
    private Student firstStudent = new Student("Kovács Rita");
    private Student secondStudent = new Student("Nagy Béla");
    private Student thirdStudent = new Student("Varga Márton");
    private Student forthStudent = new Student("G. Maczó Ágika");
    private Student fifthStudent = new Student("Urbán Violácska");
    private Student sixthStudent = new Student("Kalányos Rózsika");

    private Subject geo = new Subject("földrajz");
    private Subject mat = new Subject("matematika");
    private Subject bio = new Subject("biológia");
    private Subject mus = new Subject("zene");
    private Subject phi = new Subject("fizika");
    private Subject chem = new Subject("kémia");

    private List<Subject> subjects = new ArrayList<>(Arrays.asList(geo, mat, bio, mus, phi, chem));

    public void setUp() {
        firstStudent.grading(new Mark(MarkType.A, geo, tutor1));
        firstStudent.grading(new Mark(MarkType.C, mat, tutor1));
        firstStudent.grading(new Mark(MarkType.D, geo, tutor1));
        secondStudent.grading(new Mark(MarkType.A, bio, tutor1));
        secondStudent.grading(new Mark(MarkType.C, mat, tutor1));
        secondStudent.grading(new Mark(MarkType.D, mus, tutor2));
        thirdStudent.grading(new Mark(MarkType.A, phi, tutor2));
        thirdStudent.grading(new Mark(MarkType.C, chem, tutor2));
        thirdStudent.grading(new Mark(MarkType.D, geo, tutor1));
        forthStudent.grading(new Mark(MarkType.B, phi, tutor2));
        forthStudent.grading(new Mark(MarkType.C, chem, tutor2));
        fifthStudent.grading(new Mark(MarkType.B, geo, tutor1));
        fifthStudent.grading(new Mark(MarkType.A, bio, tutor1));
        fifthStudent.grading(new Mark(MarkType.C, mat, tutor1));
        fifthStudent.grading(new Mark(MarkType.D, mus, tutor2));

        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
        classRecords.addStudent(forthStudent);
        classRecords.addStudent(fifthStudent);
        classRecords.addStudent(sixthStudent);
    }

    private Student findStudent() {
        Student std;
        System.out.println("Name to find?:");
        std =classRecords.findStudentByName(new Scanner(System.in).nextLine());
        return std;
    }

    private void addNewStudent(){
        System.out.println("Name of the new student?:");
        if(!classRecords.addStudent(
                new Student(new Scanner(System.in).nextLine()))){
            System.out.println("Student name already exists");
        };
    }

    private void deleteStudent(){
        System.out.println("Name of the new student to delete?:");
        if(!classRecords.removeStudent(
                new Student(new Scanner(System.in).nextLine()))){
            System.out.println("Student name does not exist");
        };
    }

    private Subject findSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equals(name)) {
                return subject;
            }
        }
        System.out.println("Subject name is invalid");
        throw new IllegalArgumentException("Subject name is invalid " + name);
    }

    private Tutor findTutorByName(String name) {
        for (Tutor tutor : tutors) {
            if (tutor.getName().equals(name)) {
                return tutor;
            }
        }
        System.out.println("Tutor name is invalid");
        throw new IllegalArgumentException("Tutor name is invalid " + name);
    }

    private void repetition() {
        Student std;
        Subject sub;
        MarkType mt;
        Tutor tut;
        Scanner scn = new Scanner(System.in);

        std = classRecords.repetition();
        System.out.println(std.getName() + " jöjjön ki a táblához!");

        try {
            System.out.println("Name of subject?:");
            sub = findSubjectByName(scn.nextLine().toLowerCase());
            System.out.println("Name of tutor?:");
            tut = findTutorByName(scn.nextLine());
            System.out.println("Mark value (A..F)?:");
            mt = MarkType.valueOf(scn.nextLine().toUpperCase());

            Mark mark = new Mark(mt,sub,tut);

            std.grading(mark);

        } catch (IllegalArgumentException iex) {
            iex.getMessage();
        }

    }

    private void classAverage() {

        System.out.println(classRecords.calculateClassAverage());
    }

    private void classAverageBySubject() {
        Scanner scn = new Scanner(System.in);
        Subject subject;
        System.out.println("Name of subject?:");
        try {
            subject = findSubjectByName(scn.nextLine().toLowerCase());
            System.out.println(classRecords.calculateClassAverageBySubject(subject));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printStudyResult(){
        List<StudyResultByName> results = classRecords.listStudyResults();
        for (StudyResultByName result : results) {
            System.out.println(result.getStudentName() + ": " + result.getStudyAverage());
        }
    }

    private void printAverageByName() {
        Student std = findStudent();
        System.out.println(std.calculateAverage());
    }
    private void printAverageByNameAndSubject() {
        Student std = findStudent();
        System.out.println("Name of subject?:");
        Scanner scn = new Scanner(System.in);
        System.out.println(std.calculateSubjectAverage(findSubjectByName(scn.nextLine())));
    }

    private void runMenu(int selected) {
        try {
            switch (selected) {
                case 1:
                    System.out.println(classRecords.listStudentNames());
                    break;
                case 2:
                    System.out.println(findStudent());
                    break;
                case 3:
                    addNewStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    repetition();
                    break;
                case 6:
                    classAverage();
                    break;
                case 7:
                    classAverageBySubject();
                    break;
                case 8:
                    printStudyResult();
                    break;
                case 9:
                    printAverageByName();
                    break;
                case 10:
                    printAverageByNameAndSubject();
                    break;
                case 11:
                    ;
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
    }

    private int printMenu() {
        System.out.println("\n1.  Diákok nevének listázása");
        System.out.println("2.  Diák név alapján keresése");
        System.out.println("3.  Diák létrehozása");
        System.out.println("4.  Diák név alapján törlése");
        System.out.println("5.  Diák feleltetése");
        System.out.println("6.  Osztályátlag kiszámolása");
        System.out.println("7.  Tantárgyi átlag kiszámolása");
        System.out.println("8.  Diákok átlagának megjelenítése");
        System.out.println("9.  Diák átlagának kiírása");
        System.out.println("10. Diák tantárgyhoz tartozó átlagának kiírása");
        System.out.println("11. Kilépés");
        return new Scanner(System.in).nextInt();
    }

    public static void main(String[] args) {
        SchoolRecordsController src = new SchoolRecordsController();
        src.setUp();
        int selected =-1;
        while (selected!=11 ) {
            selected = src.printMenu();
            if (selected !=11) src.runMenu(selected);
        }
    }
}
