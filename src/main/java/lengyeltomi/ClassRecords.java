package lengyeltomi;

import java.util.*;

public class ClassRecords
{
    private   String  className;
    private   Random  veletlenszam ;

    private List<Student> students = new ArrayList<>();


    public ClassRecords(String classname, Random veletlenszam)
    {
        this.className = classname;
        this.veletlenszam = veletlenszam;
    }


    public String getClassName()
    {
        return this.className;
    }


    public void  addStudent(Student student)
    {
        students.add(student);                                                      // felvesz egy diákot az osztályba
    }


    public void removeStudent(String name)
    {
        for( int i = 0; i < students.size(); i++ )                                  //kivesz egy diákot az osztályból
        {
            if( students.get(i).getName().equals(name))
            {
                students.remove(i);
            }
        }
        System.out.println("Nincs ilyen tanuló!");
    }


    public double calculateClassAverage()
    {
        double sum  = 0;
        for(int i = 0; i < students.size(); i++)
        {
            sum  = sum + students.get(i).calculateAverage();
        }
        return  sum / students.size();
    }                                                                                //osztályátlagot számol, minden diákot figyelembe véve



    public double calculateClassAverageBySubject(Subject subject)
    {
        double sum  = 0;
        int szamlalo = 0;
        for(int i = 0; i < students.size(); i++)
        {
            if (students.get(i).calculateSubjectAverage(subject) != 0)
            {
                sum  = sum + students.get(i).calculateSubjectAverage(subject);
                szamlalo = szamlalo +1;
            }
        }
        return sum / szamlalo;
    }                                                                                 //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye


    public Student findStudentByName(String name)
    {
        for (Student  stud : students) {
            if (stud.getName().toLowerCase().equals(name.toLowerCase()))
            {
                return stud;
            }
        }
        throw new IllegalArgumentException("Subject name is invalid " + name);
    }                                                                                 // név szerint megkeres egy diákot az osztályban


    public Student repetition()
    {
        Random rmd = new Random();
        int veletlen = rmd.nextInt(students.size());
        return students.get(veletlen);
//        stud.grading(new Mark(MarkType.A, rec.subjects.get(1), rec.tutors.get(0)));
    }                                                                                 //felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults()
    {
        List<StudyResultByName> lista = new ArrayList<>();
        for( int i = 0; i < students.size(); i++ )
        {
            String  name  = students.get(i).getName();
            Double atlag  = students.get(i).calculateAverage();
            lista.add(new StudyResultByName(name, atlag));
        }
        return lista;
    }                                                                                  //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames()
    {
        StringBuilder build = new StringBuilder();
        for( int i = 0; i < students.size(); i++ )
        {
            build.append(students.get(i).getName() +  ",");
        }
        return  build.toString();
    }                                                                                   //kilistázza a diákok neveit, vesszővel elválasztva

    private boolean isEmpty(String str)
    {

        return !(str == "" || str == null);
    }
}