package main.controller;

import javafx.application.Platform;
import main.model.Task;
import com.joestelmach.natty.*;

import java.util.List;

public class CommandController {

    private MainController mainController;

    private Parser nattyParser = new Parser();

    CommandController() {}

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private void parse(String text) {
        /*
        Parser parser = new Parser();
        List groups = parser.parse("the day before next thursday");
        for(DateGroup group:groups) {
          List dates = group.getDates();
          int line = group.getLine();
          int column = group.getPosition();
          String matchingValue = group.getText();
          String syntaxTree = group.getSyntaxTree().toStringTree();
          Map> parseMap = group.getParseLocations();
          boolean isRecurreing = group.isRecurring();
          Date recursUntil = group.getRecursUntil();
        }
         */
        if (text.toLowerCase().equals("exit")) {
            Platform.exit();
            System.exit(0);
        } else if (text.toLowerCase().equals("clear")) {
            mainController.getTaskList().clear();
        } else {
            List<DateGroup> groups = nattyParser.parse(text);
            for (DateGroup group : groups) {
                String matchingValue = group.getText();
                mainController.getTaskList().add(new Task(matchingValue));
            }
        }
    }

    public void handleCommand(String text) {
        parse(text);
    }
}
