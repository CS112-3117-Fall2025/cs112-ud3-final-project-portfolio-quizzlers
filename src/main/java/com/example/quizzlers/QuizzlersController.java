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
            addCardStage.setTitle("Add Card");

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
        try {
            Stage browseCardsStage = new Stage();
            browseCardsStage.setTitle("Browse Cards");

            // Ensure the path to the FXML is correct
            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/com/example/quizzlers/browsecardsview.fxml"));

            // Create a Scene for the new Stage
            Scene newScene = new Scene(newSceneParent);
            browseCardsStage.setScene(newScene);

            // Show the new Stage on the JavaFX Application Thread
            browseCardsStage.show();

        } catch (IOException e) {
            // Log the error to help debug
            e.printStackTrace();
        }
    }
    @FXML
    protected void onQuizButtonClick() {
        try {
            Stage quizCardsStage = new Stage();
            quizCardsStage.setTitle("Quiz Cards");

            // Ensure the path to the FXML is correct
            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/com/example/quizzlers/quizcardsview.fxml"));

            // Create a Scene for the new Stage
            Scene newScene = new Scene(newSceneParent);
            quizCardsStage.setScene(newScene);

            // Show the new Stage on the JavaFX Application Thread
            quizCardsStage.show();

        } catch (IOException e) {
            // Log the error to help debug
            e.printStackTrace();
        }
    }
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}