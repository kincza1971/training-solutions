package collectionsiterator;

public class MissingBookException extends RuntimeException{
    public MissingBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingBookException(String message) {
        super(message);
    }
}
