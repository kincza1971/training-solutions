package collectionsqueue;

public class NoJobException extends IllegalStateException {
    public NoJobException(String message) {
        super(message);
    }
}
