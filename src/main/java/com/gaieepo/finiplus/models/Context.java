package com.gaieepo.finiplus.models;

import com.joestelmach.natty.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Context {
    private static Context ourInstance = null;

    private ObservableList<Task> tasks;
    private Parser parser;

    public static Context getInstance() {
        if (ourInstance == null) {
            ourInstance = new Context();
        }
        return ourInstance;
    }

    private Context() {
        this.tasks = FXCollections.observableArrayList();
        this.parser = new Parser();
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public Parser getParser() {
        return parser;
    }
}
