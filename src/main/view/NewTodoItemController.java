package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import observer.OnClickObserver;
import observer.Subject;

import java.util.List;

public class NewTodoItemController extends Subject {

    @FXML
    private JFXTextArea newTodoItem;

    @FXML
    private JFXButton saveNewTodoButton;

    @FXML
    private JFXDatePicker newTodoItemDueDate; //Won't be implemented

    private ObservableList<String> todoList;
    private List<String> currentList;

    @FXML
    void initialize() {
        saveNewTodoButton.setText("Save New Todo Item");
        saveNewTodoButton.setOnAction(event -> {
            String newTodoString = newTodoItem.getText();
//            String newDueDate = newTodoItemDueDate.getValue().toString();
//            TodoItem newTodo = new TodoItem(newTodoString, newDueDate);
            todoList.add(newTodoString);
            currentList.add(newTodoString);

            notifyObservers();

            closeCurrentStage();
        });
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) saveNewTodoButton.getScene().getWindow();
        stage.close();
    }

    public void setNewTodoItem(ObservableList<String> todoList, List<String> currentList, OnClickObserver observer) {
        this.todoList = todoList;
        this.currentList = currentList;
        addObserver(observer);
    }
}
