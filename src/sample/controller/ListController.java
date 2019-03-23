package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import sample.Database.DatabaseHandler;
import sample.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() throws SQLException {

        tasks = FXCollections.observableArrayList();

        databaseHandler = new DatabaseHandler();
        ResultSet resultSet = databaseHandler.getTasksByUser(AddItemController.userId);

        while (resultSet.next()) {
            Task task = new Task();

            task.setTaskId(resultSet.getInt("taskid"));
            task.setTask(resultSet.getString("task"));
            task.setDatecreated(resultSet.getTimestamp("datecreated"));
            task.setDescription(resultSet.getString("description"));

            tasks.addAll(task);
        }

        listTask.setItems(tasks);
        listTask.setCellFactory(CellController -> new CellController());

        listSaveTaskButton.setOnAction(event -> {
            addNewTask();
            System.out.println("Save task clicked!");
        });
    }

    public void addNewTask() {
        listSaveTaskButton.setOnAction(event -> {
            if (!listTaskField.getText().equals("")
                    || !listDescriptionField.getText().equals("")) {
                Task myNewTask = new Task();

                myNewTask.setUserId(AddItemController.userId);
                myNewTask.setTask(listTaskField.getText().trim());
                myNewTask.setDescription(listDescriptionField.getText().trim());
                myNewTask.setDatecreated(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));

                databaseHandler.insertTask(myNewTask);

                listDescriptionField.setText("");
                listTaskField.setText("");
                listTaskField.requestFocus();
            }
        });
    }

}

