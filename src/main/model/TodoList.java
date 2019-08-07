package model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private String name;
    private List<TodoItem> todoList;

    public TodoList(String name, List<TodoItem> todoList) {
        this.name = name;
        this.todoList = todoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoItem> addToList(TodoItem item) {
        todoList.add(item);
        return todoList;
    }

    public List<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList<TodoItem> todoList) {
        this.todoList = todoList;
    }

    public int size() {
        return todoList.size();
    }
}
