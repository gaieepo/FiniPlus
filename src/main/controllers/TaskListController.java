package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.models.Context;
import main.views.TaskCellAdapter;

public class TaskListController {
    @FXML
    public ListView taskListView;

    @FXML
    private void initialize() {
        taskListView.setItems(Context.getInstance().getTasks());
        taskListView.setCellFactory(param -> new TaskCellAdapter());
    }
}
