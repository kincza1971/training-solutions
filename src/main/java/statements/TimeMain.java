package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("kérem az első időpontot óra, perc, másorpesr sorrendben!:" );
        int hours=scanner.nextInt();
        int minutes=scanner.nextInt();
        int seconds=scanner.nextInt();

        Time time1 = new Time(hours,minutes,seconds);

        System.out.println("kérem a második időpontot óra, perc, másorpesr sorrendben!:" );
        hours=scanner.nextInt();
        minutes=scanner.nextInt();
        seconds=scanner.nextInt();

        Time time2 = new Time(hours,minutes,seconds);

        System.out.println(time1.toString());
        System.out.println("percben: " + time1.getInMinutes());
        System.out.println(time2.toString());
        System.out.println("másodpercben: " + time2.getInSeconds());
        System.out.println(time1.isEearlierThan(time2) ? "A második időpont nem korábbi" : "A második időpont korábbi");
    }
}
