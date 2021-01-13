package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class Linked {
    private List<String> linked = new LinkedList<>();

    public void add() {
        linked.add("alma");
        linked.add("körte");
        int a = linked.indexOf("körte");
        linked.get(0);
    }
}
