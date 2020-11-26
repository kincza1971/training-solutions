package lengyeltomi;

import java.util.*;

public class SchoolRecordsController
{
    List<Subject> subjects = new ArrayList<>();
    List<Tutor> tutors = new ArrayList<>();

    ClassRecords classrec = new ClassRecords("4.D", new Random()) ;

    public void initSchool()
    {
        subjects.add(new Subject("Matek"));
        subjects.add(new Subject("Biosz"));
        subjects.add(new Subject("Kémia"));
        subjects.add(new Subject("Angol"));
        subjects.add(new Subject("Fizika"));
        subjects.add(new Subject("Info"));
        subjects.add(new Subject("Torna"));
        subjects.add(new Subject("Történelem"));
        subjects.add(new Subject("Irodalom"));
        subjects.add(new Subject("Nyelvtan"));
        subjects.add(new Subject("Rajz"));
        subjects.add(new Subject("Ének"));

        //Miért kell példányositanom ujbol és ujbol? Miért nem fogdaja el az értékeket anélkül?
        tutors.add(new Tutor("Mézga Géza", Arrays.asList(new Subject("Matek"), new Subject("Biosz"))));
        tutors.add(new Tutor("Lüke Aladár", Arrays.asList(new Subject("Kémia"), new Subject("Angol"))));
        tutors.add(new Tutor("Fülig Jimmy", Arrays.asList(new Subject("Fizika"), new Subject("Info"))));
        tutors.add(new Tutor("Senki Alfonz", Arrays.asList(new Subject("Torna"), new Subject("Történelem"))));
        tutors.add(new Tutor("Piszkos Fred", Arrays.asList(new Subject("Irodalom"), new Subject("Nyelvtan"))));
        tutors.add(new Tutor("Iksz Ipszilon", Arrays.asList(new Subject("Rajz"), new Subject("Ének"))));
        tutors.add(new Tutor("Józsi bácsi", Arrays.asList(new Subject("Matek"), new Subject("Fizika"))));

        classrec.addStudent(new Student("Kovács Kázmér"));
        classrec.addStudent(new Student("Nagy  József"));

        Mark mark = new Mark(MarkType.A , subjects.get(1), tutors.get(0));
    }


    private void menuKivalaszt(int selected)
    {
        try
        {
            switch (selected)
            {
                case 1:
                    System.out.println(classrec.listStudentNames());
                    break;
              /*      case 2:
                          Scanner scan1 = new Scanner(System.in);
                          System.out.println("Kérem a tanuló nevét");
                          String nev1 = scan1.nextLine();
                          System.out.println(classrec.findStudentByName(nev1).getName());
                          break;
              /*      case 3:
                          Scanner scan2 = new Scanner(System.in);
                          System.out.println("Kérem a tanuló nevét");
                          String nev2 = scan2.nextLine();
                          for( int i = 0; i < classrec.students.size(); i++ )
                          {
                                if( classrec.students.get(i).getName().equalsIgnoreCase(scan2.nextLine()))
                                {
                                     System.out.println("Sajnos ilyen tanuló már szerepel");
                                }
                          }
                          classrec.addStudent(new Student(nev2));
                          break;
               /*     case 4:
                          Scanner scan3 = new Scanner(System.in);
                          System.out.println("Kérem a tanuló nevét");
                          classrec.removeStudent(scan3.nextLine());
                          break;
                    case 5:
                          classrec.repetition();
                          break;
                    case 6:
                          System.out.println(classrec.calculateClassAverage());
                          break;
                    case 7:
                          Scanner scan4 = new Scanner(System.in);
                          System.out.println("Kérem a tantárgy nevét");
                          System.out.println(classrec.calculateClassAverageBySubject(new Subject(scan4.nextLine())));
                          break;
                    case 8:
                          System.out.println(classrec.listStudyResults());
                          break;
                    case 9:
                          Scanner scan5 = new Scanner(System.in);
                          System.out.println("Kérem a tanuló nevét");
                          String name1 = scan5.nextLine();
                          Student stud1 = new Student(name1);
                          System.out.println(stud1.calculateAverage());
                          break;
                    case 10:
                          Scanner scan6 = new Scanner(System.in);
                          System.out.println("Kérem a tanuló nevét");
                          String name2 = scan6.nextLine();
                          System.out.println("Kérem a tantárgy nevét");
                          String tantargy  = scan6.nextLine();
                          Student stud2 = new Student(name2);
                          System.out.println(stud2.calculateSubjectAverage(new Subject(tantargy)));
                          break;   */
                case 11:
                    ;
                    break;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    private int menu()
    {
        System.out.println("\n1.  Diákok nevének listázása");
        System.out.println("2.    Diák név alapján keresése");
        System.out.println("3.    Diák létrehozása");
        System.out.println("4.    Diák név alapján törlése");
        System.out.println("5.    Diák feleltetése");
        System.out.println("6.    Osztályátlag kiszámolása");
        System.out.println("7.    Tantárgyi átlag kiszámolása");
        System.out.println("8.    Diákok átlagának megjelenítése");
        System.out.println("9.    Diák átlagának kiírása");
        System.out.println("10.   Diák tantárgyhoz tartozó átlagának kiírása");
        System.out.println("11.   Kilépés");

        return  Integer.parseInt(new  Scanner(System.in).nextLine());
    }



    public static void main(String[] args)
    {
        SchoolRecordsController schoolrec = new SchoolRecordsController();
//        schoolrec.initSchool();
//
//        int selected = -1;
//        while (selected != 11)
//        {
//            selected = schoolrec.menu();
//            schoolrec.menuKivalaszt(selected);
//        }
    }
}