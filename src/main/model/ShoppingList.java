package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends GeneralList {

    private String item;
    private int quantity;
    private int price;
    private List<ShoppingItem> shoppingList = new ArrayList<>();


    @Override
    public void extractInfo(ListItem item) {
        this.item = item.getPosting();

        System.out.println(item);
    }

    @Override
    public void save() {
        try {
            FileWriter fw = new FileWriter(nameOfList + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            for (ShoppingItem todo : shoppingList) {
                pw.println("Item: " + todo.getShoppingItem() + ". Cost: "
                        + todo.getPrice() + ". Quantity: " + todo.getQuantity());
                pw.println("Cost: " + todo.getPrice());
                pw.println("Quantity: " + todo.getQuantity());
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("CAN'T SAVE UH OH ERROR SHOPPING ITEM");
        }
    }

    @Override
    public List<ListItem> load(String listName) {
        try {
            FileReader fr = new FileReader(listName + ".txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) !=  null) {
                System.out.println(str + "\n");
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
        for (ShoppingItem item : shoppingList) {
            System.out.println("=== " + "Item: " + item.getShoppingItem()
                    + ". Cost: " + item.getPrice() + ". Quantity: " + item.getQuantity());
        }
    }
}
