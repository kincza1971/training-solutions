package stringconcat;

public enum Title {
    MR("Mr."), MS("Ms."), PROF("Prof.");
    private final String toPrint;

    Title(String toPrint) {
        this.toPrint = toPrint;
    }

    public String getToPrint() {
        return toPrint;
    }
}
