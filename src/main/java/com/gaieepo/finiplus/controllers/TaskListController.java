package main.java.com.gaieepo.finiplus.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.java.com.gaieepo.finiplus.models.Context;
import main.java.com.gaieepo.finiplus.views.TaskCellAdapter;

public class TaskListController {
    @FXML
    public ListView taskListView;

    @FXML
    private void initialize() {
        taskListView.setItems(Context.getInstance().getTasks());
        taskListView.setCellFactory(param -> new TaskCellAdapter());
    }
}
