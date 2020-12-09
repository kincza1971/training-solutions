package exceptions.simpletime;

public class InvalidTimeException extends IllegalArgumentException{
    private int min;
    private int max;


    public InvalidTimeException(String s, int min, int max) {
        super(s + "(" + min + " - " + max + ")");
        this.min = min;
        this.max = max;
    }

    public InvalidTimeException(String message, Throwable cause, int min, int max) {
        super(message + "(" + min + " - " + max + ")", cause);
        this.min = min;
        this.max = max;
    }

    public InvalidTimeException(Throwable cause, int min, int max) {
        super(cause);
        this.min = min;
        this.max = max;
    }
}
