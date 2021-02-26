package exam03retake02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public long getNumberOfItemsLeft() {
        return todos.stream().filter(t -> t.getState() == State.NON_COMPLETED).count();
    }

    public List<Todo> getTodos() {
        return List.copyOf(todos);
    }


    public List<String> getMostImportantTodosText() {
        if (todos.isEmpty()) {
            throw new IllegalStateException("Take a rest, there is nothing to do!");
        }
        List<String> result = new ArrayList<>();
        todos.sort(Comparator.naturalOrder());
        Todo prev = todos.get(0);
        for (Todo todo : todos) {
            if (todo.getPriority() == prev.getPriority()) {
                result.add(todo.getText());
            } else {
                return result;
            }
        }
        return result;
    }


    public void deleteCompleted() {
        Iterator<Todo> it = todos.iterator();
        Todo todo;
        while (it.hasNext()) {
            todo = it.next();
            if (todo.getState() == State.COMPLETED) {
                it.remove();
            }
        }
    }


}

//Legyen egy TodoList osztály, mely több tennivalót tartalmaz! Egy List<Todo> attribútumban tartalmazza a tennivalókat.
//
//Metódusai:
//
//getNumberOfItemsLeft() - visszaadja a még el nem készült tennivalók számát
//getMostImportantTodosText() - visszaadja a legyfontosabb tennivalókat. Nem feltétlen van 1-es prioritású.
//deleteCompleted() - a listából kitörli az elvégzetteket
