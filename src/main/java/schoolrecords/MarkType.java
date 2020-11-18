package schoolrecords;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail") ;

    private final int Value;
    private final String description;

    public MarkType getMarkTypeByName(String desc) {
        MarkType mt = null;
        switch (desc) {
            case "excellent":
                mt = MarkType.A;
                break;
            case "very good":
                mt = MarkType.B;
                break;
            case "improvement needed":
                mt = MarkType.C;
                break;
            case "close fail":
                mt = MarkType.D;
                break;
            case "fail":
                mt = MarkType.F;
                break;
        }
        return mt;
    }

    public int getValue() {
        return Value;
    }

    public String getDescription() {
        return description;
    }

    MarkType(int value, String description) {
        Value = value;
        this.description = description;
    }
}
