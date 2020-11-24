package schoolrecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SetUpClass {

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

    private List<Subject> subjects =new ArrayList<>(Arrays.asList(geo, mat, bio, mus, phi, chem));;


    private Tutor tutor1 = new Tutor("Nagy Csilla", Arrays.asList(geo,mat,bio));

    private Tutor tutor2 = new Tutor("Kovács Gábor",Arrays.asList(mus,phi, chem));

    private Tutor tutor3 = new Tutor("Szentgyörgyi Albert", Arrays.asList(mat, phi, chem));

    private TeachingStaff teachingStaff = new TeachingStaff(new ArrayList<>(Arrays.asList(tutor1,tutor2,tutor3)));

    private ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random());



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

    public TeachingStaff setupStaff() {
        return teachingStaff;
    }

    public List<Subject> setupSubjects(){
        return this.subjects;
    }

    public ClassRecords setupClass(){
        return classRecords;
    }

    public SetUpClass() {
        setUp();
    }
}
