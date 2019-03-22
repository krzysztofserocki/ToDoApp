package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.animations.Shaker;

public class AddItemController {

    public static int userId;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label noTaskLabel;

    @FXML
    private ImageView addButton;

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Shaker shaker = new Shaker(addButton);
            shaker.shake();

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), addButton);
            FadeTransition labelTransition = new FadeTransition(Duration.millis(2000), noTaskLabel);

            // Remove components to show AddItemForm view
            System.out.println("Add clicked!");

            addButton.relocate(0,20);
            addButton.setOpacity(0);

            noTaskLabel.relocate(0, 145);
            noTaskLabel.setOpacity(0);

            fadeTransition.setFromValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();

            labelTransition.setFromValue(1f);
            labelTransition.setToValue(0f);
            labelTransition.setCycleCount(1);
            labelTransition.setAutoReverse(false);
            labelTransition.play();


            try {
                AnchorPane formPane =
                        FXMLLoader.load(getClass().getResource("/sample/view/addItemForm.fxml"));
                FadeTransition rootTransition = new FadeTransition(Duration.millis(1000), formPane);

                AddItemController.userId = getUserId();

                rootTransition.setFromValue(0f);
                rootTransition.setToValue(1f);
                rootTransition.setCycleCount(1);
                rootTransition.setAutoReverse(false);
                rootTransition.play();

                rootPane.getChildren().setAll(formPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }
}
