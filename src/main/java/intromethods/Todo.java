package intromethods;

public class Todo {
    private String caption;
    private boolean finished;

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return caption + "(" + (finished ? "kész":"elvégzendő") +");";
    }

    public void finish() {
        finished = true;
    }
}
