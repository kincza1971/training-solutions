package exam03retake02;

public class Todo implements Comparable<Todo> {
    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority has be integer value between 1 and 5");
        }
        this.text = text;
        this.state = State.NON_COMPLETED;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }

    @Override
    public int compareTo(Todo o) {
        return Integer.compare(this.getPriority(), o.getPriority());
    }
}
//rj egy tennivaló osztályt (Todo), melynek attribútumai: text, state és priority, rendre String, State és int típusú.
// A State egy saját enum COMPLETED és NON_COMPLETED értékekkel. A prioritás 1 és 5 közötti egész szám.
// Ha nem ilyet kap, akkor kivételt dob. Konstuktorban csak a szövegét és a prioritását kell megadni,
// alapértelmezetten NON_COMPLETED állapottal jön létre. Legyen egy complete() metódusa, mely átállítja az állapotát!
//
