package schoolrecords;


//import java.util.*;

import java.util.*;

public class SchoolRecordsController {

    private static SetUpClass setUpClass = new SetUpClass();
    private static TeachingStaff teachingStaff = setUpClass.setupStaff();
    private static ClassRecords classRecords = setUpClass.setupClass();
    private static List<Subject> subjects = setUpClass.setupSubjects();


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
            if (subject.getSubjectName().toLowerCase().equals(name.toLowerCase())) {
                return subject;
            }
        }
        System.out.println("Subject name is invalid");
        throw new IllegalArgumentException("Subject name is invalid " + name);
    }

    private Tutor findTutorByName(String name) {
        try {
            return teachingStaff.findTutorByName(name);
        } catch (IllegalArgumentException iax) {
            System.out.println("Tutor name is invalid");
            throw new IllegalArgumentException("Tutor name is invalid " + name);

        }
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
        setUpClass.setUp();
        int selected =-1;
        while (selected!=11 ) {
            selected = src.printMenu();
            if (selected !=11) src.runMenu(selected);
        }
    }
}
