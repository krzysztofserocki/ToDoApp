package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

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
    private JFXButton signupButton;

    @FXML
    void initialize() {

    }
}
