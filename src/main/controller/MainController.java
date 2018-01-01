package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.model.Task;
import main.util.TaskCellAdapter;

public class MainController {

    public ObservableList<Task> getTaskList() {
        return taskList;
    }

    private ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    private ListView<Task> tasks;

    @FXML
    private Label toast;

    @FXML
    private TextField command;

    private CommandController commandController;

    public MainController() {
        this.commandController = new CommandController();
        this.commandController.setMainController(this);
    }

    @FXML
    private void initialize() {
        tasks.setItems(taskList);
        tasks.setCellFactory(param -> new TaskCellAdapter());
        tasks.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> toast.setText(newValue.getDescription()));
    }

    @FXML
    private void keyListener(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            commandController.handleCommand(command.getText());
            command.clear();
        }
    }
}
