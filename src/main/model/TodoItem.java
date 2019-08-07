package model;

import java.util.Objects;

public class TodoItem {
    private String todoPosting;
    private String dueDate = "N/A";


    public TodoItem(String todoPosting) {
        this.todoPosting = todoPosting;
    }

    public TodoItem(String todoPosting, String dueDate) {
        this.todoPosting = todoPosting;
        this.dueDate = dueDate;
    }

    public String getTodoPosting() {
        return todoPosting;
    }

    public void setTodoPosting(String todoPosting) {
        this.todoPosting = todoPosting;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TodoItem)) {
            return false;
        }
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(todoPosting, todoItem.todoPosting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoPosting);
    }
}
