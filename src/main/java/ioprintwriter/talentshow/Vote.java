package ioprintwriter.talentshow;

public class Vote implements Comparable <Vote> {
    private final int Id;
    private Integer num;

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

    public Integer getNumber() {
        return num;
    }

    @Override
    public String toString() {
        return "ID: " + Id + ", Votes: " +num.toString();
    }

    @Override
    public int compareTo(Vote vote) {
        return this.getNumber().compareTo(vote.getNumber());
    }
}
