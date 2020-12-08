package exceptions.faults;

public enum ProcessingResult {

    WORD_COUNT_ERROR,
    VALUE_ERROR,
    DATE_ERROR,
    VALUE_AND_DATE_ERROR,
    NO_ERROR,
    COMMENT;

    public String getCode () {
        return name();
    }
}
