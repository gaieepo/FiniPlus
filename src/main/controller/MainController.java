package main.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import main.model.Task;
import main.util.TaskCellAdapter;

public class MainController {

    private ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    private ListView<Task> lv;

    @FXML
    private Label toast;

    @FXML
    private Button elohim;

    private int taskIndex = 0;

    public MainController() {
        taskList.add(new Task("Task 1"));
    }

    @FXML
    private void initialize() {
        lv.setItems(taskList);
        lv.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {
            @Override
            public ListCell<Task> call(ListView<Task> param) {
                return new TaskCellAdapter();
            }
        });

        lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
                toast.setText(newValue.getDescription());
            }
        });

        elohim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                taskList.get(0).setDescription((100 - taskIndex) + "");
                taskIndex++;
            }
        });
    }
}
