package ui;

import Model.Todo;
import Model.TodoList;

import java.util.Scanner;

public class main {
    private TodoList todoList = new TodoList();
    private boolean runtimeCondition = false;
    private Scanner sc = new Scanner(System.in);


    public static void main(String[] args){
        main run = new main();
        run.initiateProgram();

    }

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
                todoList.addToList(todo);

                System.out.println("Enter [0] if you wish to view your Todo List");
                System.out.println("Enter [1] if you wish to enter another to-do posting");
                System.out.println("Enter [2] if you wish to exit application");
                System.out.println("Enter [3] if you wish to save your Todo List");
                String userChoiceInput = sc.nextLine();

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

        }else{
            System.out.println("Error Please select one of the valid options");
        }

//        System.out.println("Press [1] if you would like to save a new entry or press [0] if you would like to see saved entries");
//        if (sc.nextInt() == 0){
//            Loadable load = new TodoList();
//            load.load();
//        }else {
//            while(!runtimeCondition){
//                String userListInput = promptForTodoPosting();
//                Todo todo = new Todo(userListInput);
//                todoList.add(todo);
//                String userChoiceInput = promptForOptions();
//                switch(userChoiceInput){
//                    case "0": showPostings(todoList);
//                    case "1": break;
//                    case "2": runtimeCondition = true;
//                    case "3": this.save(todoList);
//                }
//            }
//        }
        sc.close();
    }

    private String promptForListName() {
        System.out.println("Please Enter a name for your list");
        return sc.nextLine();
    }

    private String promptForShoppingOrTodoList(){
        System.out.println("Enter [0] if you would like to curate a TODO LIST and [1] for a SHOPPING LIST");
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


}
