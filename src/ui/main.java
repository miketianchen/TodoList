package ui;

import Model.Exception.InvalidInputException;
import Model.Exception.TooManyItemException;
import Model.ShoppingList;
import Model.Todo;
import Model.TodoList;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    private TodoList todoList = new TodoList();
    private ShoppingList shoppingList = new ShoppingList();
    private boolean runtimeCondition = false;
    private Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        main run = new main();
        run.initiateProgram();

    }


    //TODO: WRITE A METHOD TO ELIMINATE DUPLICATED CODE
    //MODIFIES: this
    //EFFECTS: initiate the entire program, starting the ui
    public void initiateProgram(){

        String listOption = promptForShoppingOrTodoList();
        if(listOption.equals("0")){
            todoList.setNameOfList(promptForListName());
            while(!runtimeCondition){

                System.out.println("Please enter your to-do posting");
                String userListInput = sc.nextLine();

                Todo todo = new Todo(userListInput);
                try {
                    todoList.addToList(todo);
                } catch (TooManyItemException e) {
                    System.out.println("Try ticking off some of your Todo Items before adding a new Item!");
                    break;
                } finally {
                    System.out.println(todoList.getNameOfList() + " Todo List");
                }

                System.out.println("Enter [0] if you wish to view your Todo List");
                System.out.println("Enter [1] if you wish to enter another to-do posting");
                System.out.println("Enter [2] if you wish to exit application");
                System.out.println("Enter [3] if you wish to save your Todo List");
                String userChoiceInput = sc.nextLine();
                if(!userChoiceInput.equals("0") && !userChoiceInput.equals("1") && !userChoiceInput.equals("2") && !userChoiceInput.equals(("3"))){
                    try {
                        throw new InvalidInputException();
                    } catch (InvalidInputException e) {
                        System.out.println("Please enter a proper Input");
                        userChoiceInput = sc.nextLine();
                    }
                }
                switch(userChoiceInput){
                    case "0":
                        todoList.showPostings();
                        break;
                    case "1":
                        break;
                    case "2":
                        runtimeCondition = true;
                        break;
                    case "3":
                        todoList.save();
                        runtimeCondition = true;
                        break;
                }

            }
        }else if (listOption.equals("1")){
            shoppingList.setNameOfList(promptForListName());
            while(!runtimeCondition){

                System.out.println("Please what item you want to purchase");
                String itemName = sc.nextLine();
                System.out.println("Please enter quantity you wish to purchase");
                int itemQuantity = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the price if you know how much it cost, 0 otherwise");
                int itemPrice = Integer.parseInt(sc.nextLine());

                Todo shoppingTodo = new Todo(itemName,itemQuantity, itemPrice);
                try {
                    shoppingList.addToList(shoppingTodo);
                } catch (TooManyItemException e) {
                    System.out.println("Tick off some of your Shopping Items before adding new ones");
                }

                System.out.println("Enter [0] if you wish to view your Shopping List");
                System.out.println("Enter [1] if you wish to enter another Shopping Item");
                System.out.println("Enter [2] if you wish to exit application");
                System.out.println("Enter [3] if you wish to save your Shopping List");
                String userChoiceInput = sc.nextLine();

                switch (userChoiceInput){
                    case "0":
                        shoppingList.showPostings();
                        break;
                    case "1":
                        break;
                    case "2":
                        runtimeCondition = true;
                        break;
                    case "3":
                        todoList.save();
                        runtimeCondition = true;
                        break;
                }
            }
        }else if (listOption.equals("2")){
            promptForSavedFile();
        } else{
            System.out.println("Error Please select one of the valid options");
        }
        sc.close();
    }

    private String promptForListName() {
        System.out.println("Please Enter a name for your list");
        return sc.nextLine();
    }

    private String promptForShoppingOrTodoList(){
        System.out.println("Enter [0] if you would like to curate a TODO LIST and [1] for a SHOPPING LIST or if you wish to view your SAVED LIST [2]");
        return sc.nextLine();
    }

    //MODIFIES: this
    //EFFECTS: prompts the user to enter a to-do list posting and records it
    private String promptForTodoPosting(){
        System.out.println("Please enter your to-do posting");
        String userListInput = sc.nextLine();
        return userListInput;
    }


    //EFFECTS: prompts the user to view the to-do list, enter a new to-do list posting
    //         or terminate the application
    private String promptForOptions(){
        System.out.println("Enter [0] if you wish to view your Todo List");
        System.out.println("Enter [1] if you wish to enter another to-do posting");
        System.out.println("Enter [2] if you wish to exit application");
        System.out.println("Enter [3] if you wish to save your Todo List");
        String value = sc.next();
        return value;
    }

    private void promptForSavedFile(){
        System.out.println("Please enter the name of the list you wish to retrieve: ");
        String fileName = sc.nextLine();
        try {
            todoList.load(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " CANNOT BE FOUND!");
        }
    }
}
