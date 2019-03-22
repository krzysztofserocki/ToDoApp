package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.model.User;

public class SignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField signupFirstName;

    @FXML
    private JFXTextField signupLastName;

    @FXML
    private JFXTextField signupUsername;

    @FXML
    private JFXPasswordField signupPassword;

    @FXML
    private JFXCheckBox signupCheckBoxMale;

    @FXML
    private JFXCheckBox signupCheckBoxFemale;

    @FXML
    private JFXTextField signupLocation;

    @FXML
    private JFXButton signupButton;

    @FXML
    void initialize() {

        signupButton.setOnAction(event -> {
            createUser();
        });
    }


    private void createUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = signupFirstName.getText();
        String lastname = signupLastName.getText();
        String username = signupUsername.getText();
        String password = signupPassword.getText();
        String location = signupLocation.getText();

        String gender = "";
        if (signupCheckBoxFemale.isSelected()) {
            gender = "Female";
        } else gender = "Male";

        User user = new User(name, lastname, username, password, location, gender);

        databaseHandler.signUpUser(user);
    }
}
