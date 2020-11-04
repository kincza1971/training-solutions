package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Név?");
        String name = scnr.nextLine();

        System.out.println("Születési év?");
        int year = scnr.nextInt();

        System.out.println("Születési hónap?");
        int month = scnr.nextInt();

        System.out.println("Születési nap");
        int day = scnr.nextInt();

        Employee employee = new Employee(year, month, day, name);

        System.out.println(employee.getName());
        System.out.println(employee.getDateOfBirth());
        System.out.println(employee.getBeginEmployment());

    }
}
