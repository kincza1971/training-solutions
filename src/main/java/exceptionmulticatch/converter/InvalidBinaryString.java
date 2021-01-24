package exceptionmulticatch.converter;

public class InvalidBinaryString extends RuntimeException{
    public InvalidBinaryString(String message, Throwable cause) {
        super(message, cause);
    }
}
