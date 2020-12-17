package ioprintwriter.talentshow;

public class Vote {
    private final int Id;
    private int num;

    public void incNum() {
        num++;
    }

    public Vote(int id, int num) {
        Id = id;
        this.num = num;
    }

    public int getId() {
        return Id;
    }

    public int getNumber() {
        return num;
    }
}
