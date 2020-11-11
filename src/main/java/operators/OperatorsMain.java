package operators;

public class OperatorsMain {

    public static void main(String[] args) {
        Operator operator = new Operator();
        System.out.println((operator.isEven(329) ? "Páros" : "Páratlan"));
        int a = 17;
        a = a>>1;
        System.out.println(a);
        a = a<<1;
        System.out.println(a);
        a = a<<1;
        System.out.println(a);
        System.out.println(operator.multiplyByPowerOfTwo(10, 3));
        int x = 5;
        int y = 2;
        int z = x++ + (x - 4) * y - 2;
        System.out.println(x + " " + z);
    }

}
