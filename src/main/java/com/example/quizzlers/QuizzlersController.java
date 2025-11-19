package com.example.quizzlers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizzlersController {
    public Button addCardButton;
    public Button browseCardsButton;
    public Button quizButton;
    public Button exitButton;

    @FXML
    public void initialize() {
        browseCardsButton.setDisable(true);
        quizButton.setDisable(true);
    }

    public void enableCardActions() {
        browseCardsButton.setDisable(false);
        quizButton.setDisable(false);
    }

    @FXML
    protected void onAddCardButtonClick() {
        try {
            Stage addCardStage = new Stage();
            addCardStage.setTitle("Add Card");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quizzlers/addcardview.fxml"));
            Parent newSceneParent = loader.load();

            AddCardController addCardController = loader.getController();
            addCardController.setMainController(this);

            Scene newScene = new Scene(newSceneParent);
            addCardStage.setScene(newScene);

            addCardStage.initModality(Modality.APPLICATION_MODAL);
            addCardStage.setResizable(false);
            addCardStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onBrowseCardsButtonClick() {
        try {
            Stage browseCardsStage = new Stage();
            browseCardsStage.setTitle("Browse Cards");

            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/com/example/quizzlers/browsecardsview.fxml"));

            Scene newScene = new Scene(newSceneParent);
            browseCardsStage.setScene(newScene);

            browseCardsStage.initModality(Modality.APPLICATION_MODAL);
            browseCardsStage.setResizable(false);
            browseCardsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onQuizButtonClick() {
        try {
            Stage quizCardsStage = new Stage();
            quizCardsStage.setTitle("Quiz Cards");

            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/com/example/quizzlers/quizcardsview.fxml"));

            Scene newScene = new Scene(newSceneParent);
            quizCardsStage.setScene(newScene);

            quizCardsStage.initModality(Modality.APPLICATION_MODAL);
            quizCardsStage.setResizable(false);
            quizCardsStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
}
