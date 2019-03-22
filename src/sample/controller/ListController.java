package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class ListController {

    @FXML
    private JFXListView<String> listTask;

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXTextField listDescriptionField;

    @FXML
    private JFXButton listSaveTaskButton;

    ObservableList<String> listView =
            FXCollections.observableArrayList("John", "Paulo", "Bond",
                    "Java", "FX", "Cos", "tam", "fsad", "asdfa", "dfasdf", "sadasd");

    @FXML
    void initialize() {
        listTask.setItems(listView);
    }
}
