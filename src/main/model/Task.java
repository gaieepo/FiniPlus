package main.model;

import javafx.beans.property.*;
import main.util.Constant;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

/**
 * Created by gaieepo on 30/5/2016.
 */
public class Task {

    private StringProperty description;

    private ObjectProperty<LocalDateTime> startDateTime;

    private ObjectProperty<LocalDateTime> endDateTime;

    private IntegerProperty priority;

    private BooleanProperty isRecur;

    private BooleanProperty isCompleted;

    private ObjectProperty<Period> interval;

    private ObjectProperty<LocalDateTime> recursUntil;

    private StringProperty id;

    private ObjectProperty<Constant.TaskType> type;

    private List<StringProperty> tags;

    public Task(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime.get();
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime.set(startDateTime);
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime.get();
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime.set(endDateTime);
    }
}
