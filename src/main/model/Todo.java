package model;

import java.util.Objects;

public class Todo extends ListItem {

    private String todoPosting;
//    private String shoppingItem;
//    private int quantity;
//    private int price;
//    private List<Todo> todoList = new ArrayList<>();

    // AREA OF LOW COHESION -------------------------------------------------------------------------------------
    // TODOLIST VS SHOPPING ---> NOT SINGULAR
    // Constructor for TodoList
    public Todo(String todoPosting) {
        super(todoPosting);
        this.todoPosting = todoPosting;
    }
    // Constructor for ShoppingList
//    public Todo(String shoppingItem, int quantity, int price){
//        this.shoppingItem = shoppingItem;
//        this.quantity = quantity;
//        this.price = price;
//    }

    // Getters and Setters
    public String getTodoPosting() {
        return todoPosting;
    }

    public void setTodoPosting(String todoPosting) {
        this.todoPosting = todoPosting;
    }

//    public String getShoppingPosting() {
//        return shoppingItem;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public int getPrice() {
//        return price;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Todo todo = (Todo) o;
        return Objects.equals(todoPosting, todo.todoPosting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoPosting);
    }
}
