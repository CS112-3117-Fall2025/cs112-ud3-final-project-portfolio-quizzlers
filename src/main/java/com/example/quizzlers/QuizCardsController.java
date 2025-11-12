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
    public final int MAX_OPTION_AMOUNT = 4;
    int numOptions = 0;
    ArrayList<Integer> randomlyPickedOptions;

    public void initialize() {
        numOptions = getOptionAmount();
        randomlyPickedOptions = new ArrayList<Integer>(getOptionAmount());
        ObservableList<String> cardItems = FXCollections.observableArrayList();
        randomizeCurrentList();

        for (int i = 0; i < randomlyPickedOptions.size(); i++)
        {
            //System.out.println("Item #" + i + " is equal to " + randomlyPickedOptionsArray[i]);
            cardItems.add(cardList.get(randomlyPickedOptions.get(i)).getName());
        }
        quizCardsNameListView.setItems(cardItems);
        quizCardsInfoLabel.setText(cardList.get(randomlyPickAnswer()).getDefinition());
    }
    public int getOptionAmount()
    {
        int cardAmount = cardList.size();
        if (cardAmount >= MAX_OPTION_AMOUNT)
        {
            return MAX_OPTION_AMOUNT;
        }
        else
        {
            return cardAmount;
        }
    }

    public void randomizeCurrentList() {
        System.out.println("Current # of cards: " + cardList.size());
        randomlyPickedOptions.clear();

        int randomNum = (int) (Math.random() * cardList.size());
        randomlyPickedOptions.add(randomNum);
        System.out.println("Item #0 in the list picked index " + randomNum);

        for (int i = 1; i < numOptions; i++) {
            boolean isDuplicate;
            do {
                isDuplicate = false;
                randomNum = (int) (Math.random() * cardList.size());
                for (int j = 0; j < i; j++) {
                    if (randomlyPickedOptions.get(j) == randomNum) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            randomlyPickedOptions.add(randomNum);
            System.out.println("Item #" + i + " in the list picked index " + randomNum);
        }
    }

    public int randomlyPickAnswer()
    {
        return (int) (Math.random() * randomlyPickedOptions.size());
    }

    public void onConfirmAnswerButtonClick(ActionEvent event) {
    }
}