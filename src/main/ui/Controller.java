package ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Loadable;
import model.Saveable;
import model.Weather;
import ui.apicall.QuoteGenerator;
import ui.apicall.WeatherGenerator;
import ui.observer.OnClickObserver;
import ui.view.ListItemCell;
import ui.view.NewTodoItemController;
import ui.view.TodoListViewCell;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable, Saveable, Loadable, OnClickObserver {

    private static final String FILE_NAME = "TODOLIST.txt";
    private static final int QUOTE_TEXT_INDEX = 0;
    private static final int QUOTE_AUTHOR_INDEX = 1;

    @FXML
    private ImageView saveButton;

    @FXML
    private ImageView newTodoItemButton;

    @FXML
    private ImageView refreshQuoteButton;

    @FXML
    private ImageView weatherIcon;

    @FXML
    private Label detailedListItem;

    @FXML
    private Label weatherDetailLabel;

    @FXML
    private Label weatherTemp;

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> listNameListView;

    @FXML
    private Label motivationalTextLabel;

    private Stage stage = new Stage();


    private ObservableList<String> listNameObservableList;
    private ObservableList<String> todoItemObservableList;

    private Map<String, List<String>> todoListMap;

    private List<String> currentList;

    private Weather weather;


    public Controller() {
        todoItemObservableList = FXCollections.observableArrayList();
        listNameObservableList = FXCollections.observableArrayList();

        todoListMap = loadList();
        List<String> keyList = new ArrayList<>(todoListMap.keySet());
        listNameObservableList.addAll(keyList);

        System.out.println(todoListMap);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewSetup();

        listNameListsViewSetup();

        // Setup all the Images for the buttons
        initializeImages();

        // Setup the API Call to retrieve the motivational quote
        retrieveMotivationalQuote();

        // Setup the API Call to retrieve the Weather
        setupWeather();

        setUpButtonActionEvents();

    }

    private void setupWeather() {
        retrieveWeatherInfo();
        setupWeatherIcon();
        weatherDetailLabel.setText(weather.getWeatherInfo());
        weatherTemp.setText(String.format("%.1f", Double.parseDouble(weather.getWeatherTemp()) - 273.15) + " C");
    }

    private void setupWeatherIcon() {
        String weatherId = weather.getWeatherId();
        String weatherIdFirstIndex = weatherId.substring(0, 1);

        if (weatherId.equals("800")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/sun-5-512.png"));
        } else if (weatherIdFirstIndex.equals("8")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/cloudy-512.png"));
        } else if (weatherIdFirstIndex.equals("3")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/little-rain-512.png"));
        } else if (weatherIdFirstIndex.equals("5")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/rain-512.png"));
        } else if (weatherIdFirstIndex.equals("2")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/storm-512.png"));
        } else if (weatherIdFirstIndex.equals("6")) {
            weatherIcon.setImage(new Image("/icons/weatherIcons/snow-512.png"));
        } else {
            weatherIcon.setImage(new Image("/icons/weatherIcons/fog-day-512.png"));
        }
    }

    private void listNameListsViewSetup() {
        listNameListView.setItems(listNameObservableList);
        listNameListView.setCellFactory(listItemView -> new ListItemCell());
        //AUTOMATICALLY SELECTS THE FIRST ITEM IN THE LISTVIEW
        listNameListView.getSelectionModel().select(0);

        //Listener to observe listNameListView on selection
        listNameListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentList = todoListMap.get(newValue);
                todoItemObservableList.clear();
                todoItemObservableList.addAll(currentList);
            }
        });
    }

    private void listViewSetup() {
        listView.setItems(todoItemObservableList);
        listView.setCellFactory(todoItemView -> new TodoListViewCell(this));

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                detailedListItem.setText(listView.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void setUpButtonActionEvents() {
        newTodoItemButton.setOnMouseClicked(event -> {
            newTodoItem();
        });
        saveButton.setOnMouseClicked(event -> {
            saveList();
        });
        refreshQuoteButton.setOnMouseClicked(event -> {
            refreshQuote();
        });
    }

    private void refreshQuote() {
        retrieveMotivationalQuote();
    }

    private void initializeImages() {
        saveButton.setImage(new Image("/icons/saveButton/drawable-xxxhdpi/baseline_save_white_48.png"));
        newTodoItemButton.setImage(new Image("/icons/addButton/drawable-xxxhdpi/baseline_add_box_white_48.png"));
        refreshQuoteButton.setImage(new Image("/icons/refreshButton/drawable-xxxhdpi/baseline_refresh_white_48.png"));
    }


    private void newTodoItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NewTodoItem.fxml"));
        try {
            Parent parent = (Parent) fxmlLoader.load();

            NewTodoItemController controller = fxmlLoader.getController();
            controller.setNewTodoItem(todoItemObservableList, currentList, this);

            stage.setTitle("Add New Todo Posting PLEASE!");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void retrieveMotivationalQuote() {
        ArrayList<String> quoteAuthorList = (ArrayList<String>) QuoteGenerator.getInstance().getQuoteJson();
        String quoteString = quoteAuthorList.get(QUOTE_TEXT_INDEX);
        String authorString = quoteAuthorList.get(QUOTE_AUTHOR_INDEX);
        if (authorString.equals("")) {
            authorString = "Anonymous";
        }
        motivationalTextLabel.setText(quoteString + " - " + authorString);
    }

    private void retrieveWeatherInfo() {
        weather = WeatherGenerator.getInstance().retrieveJsonResponse();
        // PLACEHOLDER FOR NOW
        System.out.println(weather.getWeatherId());
    }

    @Override
    public void saveList() {
        //WRITE Map<String, List<String>> OBJECT INTO A JSON FILE TO BE READ
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // TO CONVERT MAP OBJECT TO json FORMAL, AND RETURN THE json STRING
        String jsonString = gson.toJson(todoListMap);

        try {
            //"WRITE" THE json STRING TO A FILE NAMED: "FILE_NAME"
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(todoListMap);
    }

    @Override
    public Map<String, List<String>> loadList() {
        Map<String, List<String>> tempMap = new HashMap<>();
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            tempMap = gson.fromJson(br, Map.class);
            System.out.println(tempMap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempMap;
    }


    @Override
    public void update() {
        saveList();
    }

    @Override
    public void update(String selectedListText) {
        currentList.remove(selectedListText);
        saveList();
    }
}
