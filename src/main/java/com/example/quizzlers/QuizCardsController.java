package com.example.quizzlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class QuizCardsController {
    public Label quizCardsNameLabel;
    public Label quizCardsInfoLabel;
    public Button quizCardsConfirmAnswerButton;

    public ListView<String> quizCardsNameListView;
    public Label correctOrWrongLabel;
    public Button quizCardsNextButton;

    QuizManager quizManager;
    ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>(AddCardController.getCardList());

    public void initialize() {
        quizManager = new QuizManager(new ArrayList<Card>(cardList));

        quizCardsNameListView.setItems(quizManager.getCardItems());
        quizCardsInfoLabel.setText(quizManager.getCorrectDefinition());

        quizCardsNextButton.setDisable(true);
    }

    @FXML
    public void onConfirmAnswerButtonClick(ActionEvent event) {
        int selectedIndex = quizCardsNameListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            if (selectedIndex == quizManager.getCorrectAnswerIndex()) {
                correctOrWrongLabel.setText("Correct!");
                correctOrWrongLabel.setTextFill(Color.GREEN);
            } else {
                correctOrWrongLabel.setText("Incorrect!");
                correctOrWrongLabel.setTextFill(Color.RED);
            }

            quizCardsConfirmAnswerButton.setDisable(true);
            quizCardsNextButton.setDisable(false);
        }
    }

    @FXML
    public void onNextButtonClick(ActionEvent event) {
        quizCardsConfirmAnswerButton.setDisable(false);
        quizCardsNextButton.setDisable(true);

        quizManager.nextQuestion();

        quizCardsNameListView.setItems(quizManager.getCardItems());
        quizCardsInfoLabel.setText(quizManager.getCorrectDefinition());

        correctOrWrongLabel.setText("");
    }
}
