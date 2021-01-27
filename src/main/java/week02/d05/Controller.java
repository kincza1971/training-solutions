package week02.d05;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {

        Controller controller = new Controller();





        controller.readOffice();
    }


    Office iroda = new Office();

    public void readOffice() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int length;
        int width;

        System.out.println("Tárgyalók száma:");

        int number = scanner.nextInt();

        for (int i = 1; i < number; i++) {

            System.out.println(i + ". Tárgyaló neve:");
            name = scanner.nextLine();

            System.out.println(i + ". Tárgyaló hossza:");
            length = scanner.nextInt();

            System.out.println(i + ". Tárgyaló szélessége:");
            width = scanner.nextInt();

            MeetingRoom room = new MeetingRoom((name), (width), (length));

            iroda.addMeetingRoom(room);
        }
    }
    public void printMenu(){
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }
    public void runMenu(){
        Scanner scanner = new Scanner(System.in);
        int valasz;
        System.out.println("Választása:");
        valasz = scanner.nextInt();
        switch (valasz){
            case 1:
                iroda.printNames();
            case 2:
                iroda.printNamesReverse();
            case 3:
                iroda.printEvenNames();
            case 4:
                iroda.printAreas();
            case 5:
                System.out.println("Tárgyaló neve:");
                String name = scanner.nextLine();
                iroda.printMeeetingRoomsWithName(name);
            case 6:
                System.out.println("Névrészlet:");
                name = scanner.nextLine();
                iroda.printMeetingRoomsContains(name);
            case 7:
                System.out.println("Tárgyaló minimális területe:");
                int area = scanner.nextInt();
                iroda.printAreasLargerThan(area);
        }
    }
}