package week12.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class EmployeeFilterTest {

    Employee e1= new Employee(29,4,"zozó", Arrays.asList("karate", "car driving", "programmer"));
    Employee e2= new Employee(23,2,"Bozó", Arrays.asList("karate", "car driving", "programmer"));
    Employee e3= new Employee(29,4,"Hozó", Arrays.asList("karate", "car driving", "programmer"));
    Employee e4= new Employee(23,2,"Lozó", Arrays.asList("karate", "car driving", "programmer"));
    Employee e5= new Employee(29,4,"Homokozó", Arrays.asList("karate", "car driving", "SCRUM"));
    Employee e6= new Employee(23,2,"Lapozó", Arrays.asList("karate", "car driving", "JAVA"));


    @Test
    public void testEmployeeFilter() {

        EmployeeFilter ef = new EmployeeFilter();
        Assertions.assertEquals(Arrays.asList(e1,e3), ef.countSeniorDevs(Arrays.asList(e1,e2,e3,e4,e5,e6)));

    }

    @Test
    public void testErrMessage() {

        EmployeeFilter ef = new EmployeeFilter();

        Exception e = Assertions.assertThrows(IllegalArgumentException.class,() -> ef.countSeniorDevs(Arrays.asList(e1, e2, null)));
        Assertions.assertEquals(e.getMessage(),"List must not null or empty and employee = null is not allowed here");

        e = Assertions.assertThrows(IllegalArgumentException.class,() -> ef.countSeniorDevs(new ArrayList<>()));
        Assertions.assertEquals(e.getMessage(),"List must not null or empty and employee = null is not allowed here");

        e = Assertions.assertThrows(IllegalArgumentException.class,() -> ef.countSeniorDevs(null));
        Assertions.assertEquals(e.getMessage(),"List must not null or empty and employee = null is not allowed here");
    }
}
