package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message= prefix + name;
        message = message + 444;
        boolean b = "Hello John Doe".equals(message);
        boolean c = "Hello John Doe444".equals(message);


    }
}
