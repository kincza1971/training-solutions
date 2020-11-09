package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<Todo> todoList = new ArrayList<>();

    public void addTodo(String caption) {
        todoList.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo todo : todoList) {
            if (caption.equals(todo.getCaption())) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<Todo> toFinish) {
        for (Todo todo : todoList) {
            for (Todo tf : toFinish) {
                if(todo.getCaption().equals(tf.getCaption())) {
                    todo.finish();
                }
            }
        }
    }

    public List<Todo> todosToFinish() {
        List<Todo> toFinisList = new ArrayList<>();
        for (Todo todo : todoList) {
            if (!todo.isFinished()){
                toFinisList.add(todo);
            }
        }
        return toFinisList;
    }

    public int numberOfFinishedTodos() {
        int i =0;
        for (Todo todo : todoList) {
            if (todo.isFinished()){
                i++;
            }
        }
        return i;
    }

//    @Override
//    public String toString() {
//        String result = "";
//        for (Todo todo : todoList) {
//            result = result + todo.toString() + " ";
//        }
//        return result;
//    }


    @Override
    public String toString() {
        return todoList.toString();
    }
}
