package model;

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

}
