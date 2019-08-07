package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ListItemCell extends ListCell<String> {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label listNameLabel;

//    @FXML
//    private JFXButton deleteList;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ListItemCell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                deleteList.setText("Delete");
//                deleteList.setOnAction(event -> getListView().getItems().remove(getItem()));

                listNameLabel.setText(item);

                setText(null);
                setGraphic(anchorPane);
            }
        }
    }
}
