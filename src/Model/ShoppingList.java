package Model;

import java.io.*;
import java.util.List;

public class ShoppingList extends GeneralList{

    private String item;
    private int quantity;
    private int price;

    @Override
    public void extractInfo(Todo item) {
        this.item = item.getShoppingPosting();
        quantity = item.getQuantity();
        price = item.getPrice();

        System.out.println("There are "  + quantity + " amount of " + item + " which will cost " + (quantity*price));
    }

    @Override
    public void save() {
        try {
            FileWriter fw = new FileWriter(nameOfList+".txt");
            PrintWriter pw = new PrintWriter(fw);
            // NOTE FOR SHOPPINGLIST YOU HAVE TO OVERRIDE TO SAVE THE QUANITITY
            for(Todo todo : todoList){
                pw.println("Item: " + todo.getShoppingPosting() + ". Cost: " + todo.getPrice() + ". Quantity: " + todo.getQuantity());
//                pw.println("Cost: " + todo.getPrice());
//                pw.println("Quantity: " + todo.getQuantity());
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("CAN'T SAVE UH OH ERROR SHOPPING ITEM");
        }
    }

    @Override
    public List<Todo> load() {
        try {
            FileReader fr = new FileReader(nameOfList + ".txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while((str = br.readLine()) !=  null){
                System.out.println(str + "\n");
                //TODO: PARSE THE INPUT STRING TO GET THE ITEM, PRICE AND QUANTITY AND SAVE IT TO A TODO ITEM
                //      HAVEN'T DONE YET. DO AFTER THE MIDTERM
                Todo todo = new Todo(str);
                todoList.add(todo);
            }
            br.close();
            return todoList;
        } catch (IOException e) {
            System.out.println("ERROR IN LOADING");
            return null;
        }
    }

    @Override
    public void showPostings() {
        for(Todo item : todoList){
            System.out.println("Item: " + item.getShoppingPosting() + ". Cost: " + item.getPrice() + ". Quantity: " + item.getQuantity());
        }
    }
}
