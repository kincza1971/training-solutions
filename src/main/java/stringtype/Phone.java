package stringtype;

import java.util.Scanner;

public class Phone {
    String type;
    int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("kérem az elsőt");

        String name = scanner.nextLine();
        int type = scanner.nextInt();
        scanner.nextLine();

        Phone mobil = new Phone(name, type);

        System.out.println("kérem a másodikat");
        name = scanner.nextLine();
        type = scanner.nextInt();

        Phone otthon = new Phone(name, type);

    }

}
