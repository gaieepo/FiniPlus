package main.util;

import javafx.scene.control.ListCell;
import main.model.Task;
import main.model.TaskCell;

/**
 * Created by gaieepo on 30/5/2016.
 */
public class TaskCellAdapter extends ListCell<Task> {
    @Override
    protected void updateItem(Task item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            TaskCell taskCell = new TaskCell();
            taskCell.getDescription().textProperty().bind(item.descriptionProperty());
            setGraphic(taskCell);
        } else {
            setGraphic(null);
        }
    }
}