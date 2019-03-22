package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Database.DatabaseHandler;
import sample.model.Task;

public class AddItemFormController {
    private DatabaseHandler databaseHandler;
    private int userId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField taskField;

    @FXML
    private JFXTextField descriptionField;

    @FXML
    private JFXButton saveTaskButton;

    @FXML
    private Label successLabel;

    @FXML
    private JFXButton todosButton;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();

        saveTaskButton.setOnAction(event -> {
            Task task = new Task();

            java.sql.Timestamp timestamp =
                    new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());

            String taskText = taskField.getText().trim();
            String taskDescription = descriptionField.getText().trim();

            if (!taskText.equals("") || !taskDescription.equals("")) {

                System.out.println(AddItemController.userId);
                task.setUserId(AddItemController.userId);
                task.setDatecreated(timestamp);
                task.setDescription(taskDescription);
                task.setTask(taskText);

                successLabel.setVisible(true);
                todosButton.setVisible(true);
                int taskNumber = 2;
                todosButton.setText("My 2DO's: " + taskNumber);

                taskField.setText("");
                taskField.requestFocus();
                descriptionField.setText("");


                todosButton.setOnAction(event1 -> {
                    // Send users to the list screen
                });

                databaseHandler.insertTask(task);

                System.out.println("Task Added Successfully!");
            } else {
                successLabel.setVisible(true);
            }


        });
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
