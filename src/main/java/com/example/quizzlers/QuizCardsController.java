package com.example.quizzlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class QuizCardsController {
    public Label quizCardsNameLabel;
    public Label quizCardsInfoLabel;
    public Button quizCardsConfirmAnswerButton;

    @FXML
    public ListView<String> quizCardsNameListView;
    ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>(AddCardController.getCardList());

    public void initialize() {
        ObservableList<String> cardItems = FXCollections.observableArrayList();

        for (int i = 0; i < cardList.size(); i++)
        {
            cardItems.add(cardList.get(i).getName());
        }
        quizCardsNameListView.setItems(cardItems);
    }

    public void onConfirmAnswerButtonClick(ActionEvent event) {
    }
}