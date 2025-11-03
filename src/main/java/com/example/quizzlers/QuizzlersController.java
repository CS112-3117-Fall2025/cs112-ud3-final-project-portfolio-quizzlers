package com.example.quizzlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizzlersController {
    public Label cardDefinitionLabel;
    public Button addCardButton;
    public Button browseCardsButton;
    public Button quizButton;
    public Button exitButton;
    public TextArea inputDefinitionTextbox;
    public TextArea inputNameTextbox;
    @FXML
    private Label cardNameLabel;

    @FXML
    protected void onAddCardButtonClick() {
        try {
            Stage addCardStage = new Stage();
            addCardStage.setTitle("New Window");

            // Ensure the path to the FXML is correct
            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/com/example/quizzlers/addcardview.fxml"));

            // Create a Scene for the new Stage
            Scene newScene = new Scene(newSceneParent);
            addCardStage.setScene(newScene);

            // Show the new Stage on the JavaFX Application Thread
            addCardStage.show();

        } catch (IOException e) {
            // Log the error to help debug
            e.printStackTrace();
        }
    }

    @FXML
    protected void onBrowseCardsButtonClick() {
        cardNameLabel.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onQuizButtonClick() {
        cardNameLabel.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}