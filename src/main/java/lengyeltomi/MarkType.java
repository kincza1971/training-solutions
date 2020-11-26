package lengyeltomi;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail");


    private final int values;
    private final String description;

    private MarkType(int values, String description)
    {
        this.values = values;
        this.description = description;
    }

    public int getValues()
    {
        return values;
    }

    public String getDescription()
    {
        return description;
    }
}