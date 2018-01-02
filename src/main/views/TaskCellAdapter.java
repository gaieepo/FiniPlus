package main.views;

import javafx.scene.control.ListCell;
import main.models.Task;
import main.views.TaskCell;

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