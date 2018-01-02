package main.java.com.gaieepo.finiplus.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.java.com.gaieepo.finiplus.models.Context;
import main.java.com.gaieepo.finiplus.models.Task;

public class CommandController {
    @FXML
    private TextField commandTextField;

    @FXML
    private void keyListener(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            handleCommand();
            commandTextField.clear();
        }
    }

    private void handleCommand() {
        String commandText = commandTextField.getText();
        if (commandText.toLowerCase().equals("exit")) {
            Platform.exit();
            System.exit(0);
        } else if (commandText.toLowerCase().equals("clear")) {
            Context.getInstance().getTasks().clear();
        } else {
            parse(commandText);
            Context.getInstance().getTasks().add(new Task(commandText));
        }
    }

    private void parse(String commandText) {
        System.out.println("Parsing");
//        List<DateGroup> groups = Context.getInstance().getParser().parse(commandText);
//        for(DateGroup group:groups) {
//            List dates = group.getDates();
//            int line = group.getLine();
//            int column = group.getPosition();
//            String matchingValue = group.getText();
//            String syntaxTree = group.getSyntaxTree().toStringTree();
//            Map parseMap = group.getParseLocations();
//            boolean isRecurring = group.isRecurring();
//            Date recursUntil = group.getRecursUntil();
//        }
    }
}