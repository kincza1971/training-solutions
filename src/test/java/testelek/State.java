package testelek;

public class State {

    private static int instance = 0;

    public State() {
        instance++;
    }

    public static void main(String[] args) {
        new State();
        new State();
        System.out.println(instance);
    }
}