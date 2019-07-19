package Model;

import java.util.ArrayList;
import java.util.List;

public class Todo {

    private String todoPosting;
    private String shoppingItem;
    private int quantity;
    private int price;
    private List<Todo> todoList = new ArrayList<>();

    // Constructor for TodoList
    public Todo(String todoPosting){
        this.todoPosting = todoPosting;
    }
    // Constructor for ShoppingList
    public Todo(String shoppingItem, int quantity, int price){
        this.shoppingItem = shoppingItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getTodoPosting() {
        return todoPosting;
    }

    public void setTodoPosting(String todoPosting) {
        this.todoPosting = todoPosting;
    }

    public String getShoppingPosting() {
        return shoppingItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

}
