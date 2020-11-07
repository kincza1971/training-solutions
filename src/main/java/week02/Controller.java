package week02;

import java.util.Scanner;

public class Controller {

    private Office office;
    private Scanner scanner = new Scanner(System.in);

    public void readOffice(){
        office = new Office();

        System.out.println("Tárgyalók száma?");
        int numberOfMeetingRooms = scanner.nextInt();
        scanner.nextLine();

        String name;
        int length;
        int width;

        for (int i = 0; i < numberOfMeetingRooms; i++) {
            System.out.println("kérem a tárgyaló nevét!");
            name = scanner.nextLine();
            System.out.println("kérem a hosszát!");
            length = scanner.nextInt();
            System.out.println("kérem a tárgyaló szélességét!");
            width = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name,length,width);
            office.addMeetingRoom(meetingRoom);
        }

    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendbenű");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu() {
        scanner.reset();
        int selectedMenu = scanner.nextInt();
        switch (selectedMenu) {
            case 1:{
                office.printNames();
                break;
            }
            case 2: {
                office.printNamesReverse();
                break;
            }
            case 3: {
                office.printEvenNames();
                break;
            }
            case 4: {
                office.printAreas();
                break;
            }
            case 5: {
                System.out.println("Kérem a tárgyaló nevét!");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
                break;
            }
            case 6: {
                System.out.println("Kérem a névrészletet!");
                String part = scanner.nextLine();
                office.printMeetingRoomsContains(part);
                break;
            }
            case 7: {
                System.out.println("Kérem a mérethatárt!");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        int exit =0;
        do {
            controller.printMenu();
            controller.runMenu();
            System.out.println("Kilépsz? (0 - Nem; 9 - Igen)");
            exit = controller.scanner.nextInt();
            controller.scanner.nextLine();
        } while ( exit != 9);

    }
}
