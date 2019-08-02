package model;

import model.exception.TooManyItemException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GeneralList implements Saveable, Loadable {
    protected List<ListItem> todoList = new ArrayList<ListItem>();
    protected String nameOfList = "To-Do List";


    //MODIFIES: this
    //EFFECTS: allows the user to set the name of each list
    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    //MODIFIES: this
    //EFFECTS: allows the user to add a to-do item to the to-do list
    public void addToList(ListItem item) throws TooManyItemException {
        if (!todoList.contains(item)) {
            todoList.add(item);
            item.setTodoList(todoList);

            if (todoList.size() >= 5) {
                throw new TooManyItemException();
            }
            todoList.add(item);
        }
    }

    public abstract void extractInfo(ListItem item);

    //EFFECTS: allows the user to retrieve the to-do list
    public List<ListItem> retrieveTodoList() {
        return todoList;
    }

    public int sizeOfList() {
        return todoList.size();
    }

    //EFFECTS: displays the to-do postings
    public abstract void showPostings();

    // AREAS OF HIGH COUPLING WITH ShoppingList.java---------------------------------------------------
    @Override
    public void save() {
        try {
            FileWriter fw = new FileWriter(nameOfList + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            for (ListItem todo : todoList) {
                pw.println(todo.getPosting());
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("CAN'T SAVE UH OH ERROR");
        }
    }

    @Override
    public List<ListItem> load(String listName) throws FileNotFoundException {
        FileReader fr = new FileReader(listName + ".txt");
        BufferedReader br = new BufferedReader(fr);
        try {
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
}