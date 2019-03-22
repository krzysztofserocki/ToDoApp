package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.model.Task;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ListController {

    @FXML
    private JFXListView<Task> listTask;

    @FXML
    private JFXTextField listTaskField;

    @FXML
    private JFXTextField listDescriptionField;

    @FXML
    private JFXButton listSaveTaskButton;

    private ObservableList<Task> tasks;

    @FXML
    void initialize() {

        Task myTask = new Task();
        Task myTask2 = new Task();

        myTask.setTask("Clean car");
        myTask.setDescription("Have to clean it");
        myTask.setDatecreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));

        myTask2.setTask("Clean clothes");
        myTask2.setDescription("CLEAN THOSE FUCKIN CLOTHES");
        myTask2.setDatecreated(new Timestamp(Calendar.getInstance().getTimeInMillis()));

        tasks = FXCollections.observableArrayList();

        tasks.add(myTask);
        tasks.add(myTask2);

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController-> new CellController());
    }

}

