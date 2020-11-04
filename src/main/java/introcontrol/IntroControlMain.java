package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl ic = new IntroControl();

        System.out.println(ic.substractTenIfGreaterThanTen(15));
        System.out.println(ic.substractTenIfGreaterThanTen(5));
        System.out.println(ic.substractTenIfGreaterThanTen(10));

        System.out.println(ic.describeNumber(0));
        System.out.println(ic.describeNumber(7));

        System.out.println(ic.calculateConsumption(9999,300));
        System.out.println(ic.calculateConsumption(300,9999));

        System.out.println(ic.greetingToJoe("Joe"));
        System.out.println(ic.greetingToJoe(""));

        ic.printNumbersBetweenAnyDirection(1,8);
        System.out.println("");
        ic.printNumbersBetweenAnyDirection(1,1);
        System.out.println("");
        ic.printNumbersBetweenAnyDirection(7,1);

        System.out.println("odd");
        ic.printOddNumbers(9);
        System.out.println("odd");
        ic.printOddNumbers(1);
        System.out.println("odd");
        ic.printOddNumbers(8);

    }
}
