package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class AddItemFormController {

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
    void initialize() {
        assert taskField != null : "fx:id=\"taskField\" was not injected: check your FXML file 'addItemForm.fxml'.";
        assert descriptionField != null : "fx:id=\"descriptionField\" was not injected: check your FXML file 'addItemForm.fxml'.";
        assert saveTaskButton != null : "fx:id=\"saveTaskButton\" was not injected: check your FXML file 'addItemForm.fxml'.";

    }
}
