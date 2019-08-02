package model;

import java.util.ArrayList;
import java.util.List;

public class ListItem {

    protected String posting;
    protected List<ListItem> todoList = new ArrayList<>();

    public List<ListItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<ListItem> todoList) {
        this.todoList = todoList;
    }

    public ListItem(String posting) {
        this.posting = posting;
    }

    public String getPosting() {
        return posting;
    }

    public void setPosting(String posting) {
        this.posting = posting;
    }
}
