package view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TodoListViewCell extends ListCell<String> {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label todoContent;

    @FXML
    private Label timeStamp;

    @FXML
    private JFXButton deleteButton;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        // if empty and no Todoitem
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TodoListCell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            deleteButton.setText("Delete");
//            deleteButton.setOnAction(event -> getListView().getItems().remove(getItem()));
//
//            todoContent.setText(item);
            setUpButtons(item);

            setText(null);
            setGraphic(anchorPane);
        }
    }

    private void setUpButtons(String item) {
        deleteButton.setText("Delete");
        deleteButton.setOnAction(event -> getListView().getItems().remove(getItem()));

        todoContent.setText(item);
    }
}
