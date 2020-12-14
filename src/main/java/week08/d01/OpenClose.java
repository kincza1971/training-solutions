package week08.d01;

public enum OpenClose {
    OPEN,
    CLOSE;

    public static OpenClose change(OpenClose openClose){
        if (openClose.equals(OpenClose.CLOSE)) {
            return OpenClose.OPEN;
        }
        return OpenClose.CLOSE;
    }
}
