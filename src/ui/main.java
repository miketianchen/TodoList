package ui;

import Model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("Your To-Do List:");
        run();
//        addItem();
//        removeItem();
    }

    public static void run(){
        List<Todo> todoList = new ArrayList<>();
        int exit = 0;
        while(exit == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your to-do posting");
            String userListInput = sc.nextLine();
            Todo todo = new Todo(userListInput);
            todoList.add(todo);
            System.out.println("Posting added");
            System.out.println("Enter [0] if you wish to view your Todo List");
            System.out.println("Enter [1] if you wish to enter another to-do posting");
            System.out.println("Enter [2] if you wish to exit application");
            int userChoiceInput = sc.nextInt();
            switch(userChoiceInput){
                case 0: showPostings(todoList);
                case 1: break;
                case 2: exit = 1;
            }
        }
    };

    public static void showPostings(List<Todo> todoList){
        for(Todo item : todoList){
            System.out.println(item.getTodoPosting());
        }
    }
//    public static void addItem(){
//        System.out.println("Item added to your todo list");
//    }
//    public static void removeItem(){
//        System.out.println("Item removed from your todo list");
//    }
}
