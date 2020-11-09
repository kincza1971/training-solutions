package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public void generateTodoList(TodoList todoList) {
        for (int i = 1; i < 10; i++) {

            todoList.addTodo("ToDo ASAP " + i);

        }
    }

    public List<Todo> generateTodoListToClose() {
        List<Todo> toFinish = new ArrayList<>();
        toFinish.add(new Todo("ToDo ASAP 4"));
        toFinish.add(new Todo("ToDo ASAP 5"));
        toFinish.add(new Todo("ToDo ASAP 6"));
        toFinish.add(new Todo("ToDo ASAP 9"));
        return toFinish;
    }

    public void printATodoList(List<Todo> listToPrint) {
        for (Todo todo : listToPrint) {
            System.out.print(todo.getCaption() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TodoListMain main = new TodoListMain();
        TodoList todoList = new TodoList();

        main.generateTodoList(todoList);
        main.printATodoList(todoList.todosToFinish());

        todoList.finishTodos("ToDo ASAP 7");
        System.out.println();
        System.out.println("finished: " + todoList.numberOfFinishedTodos());
        main.printATodoList(todoList.todosToFinish());

        todoList.finishAllTodos(main.generateTodoListToClose());
        System.out.println();
        System.out.println("finished: " + todoList.numberOfFinishedTodos());
        main.printATodoList(todoList.todosToFinish());

        System.out.println(todoList.toString());

    }

}
