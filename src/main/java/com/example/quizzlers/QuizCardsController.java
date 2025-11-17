package com.example.quizzlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.function.Predicate;

public class QuizCardsController {
    public Label quizCardsNameLabel;
    public Label quizCardsInfoLabel;
    public Button quizCardsConfirmAnswerButton;
    private int currentCorrectAnswerIndex = -1;

    @FXML
    public ListView<String> quizCardsNameListView;
    public Label correctOrWrongLabel;
    public Button quizCardsNextButton;
    ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>(AddCardController.getCardList());
    public final int MAX_OPTION_AMOUNT = 4;
    int numOptions = 0;
    ArrayList<Integer> randomlyPickedOptions;
    ObservableList<String> cardItems = FXCollections.observableArrayList();

    public void initialize() {
        numOptions = getOptionAmount();
        randomlyPickedOptions = new ArrayList<Integer>(getOptionAmount());

        randomizeCurrentList();
        resetOptionList();

        setRandomlyPickedAnswerIndex();
        updateInfoLabel();

        quizCardsNextButton.setDisable(true);
    }

    public void resetOptionList()
    {
        cardItems.clear();
        for (int i = 0; i < randomlyPickedOptions.size(); i++)
        {
            //System.out.println("Item #" + i + " is equal to " + randomlyPickedOptionsArray[i]);
            cardItems.add(cardList.get(randomlyPickedOptions.get(i)).getName());
        }
        quizCardsNameListView.setItems(cardItems);
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

    public void setRandomlyPickedAnswerIndex()
    {
        currentCorrectAnswerIndex = (int) (Math.random() * randomlyPickedOptions.size());
    }

    public void updateInfoLabel() {
        int correctCardIndex = randomlyPickedOptions.get(currentCorrectAnswerIndex);
        quizCardsInfoLabel.setText(cardList.get(correctCardIndex).getDefinition());
    }

    public void onConfirmAnswerButtonClick(ActionEvent event) {

        int selectedIndex = quizCardsNameListView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            System.out.println("Selected item: " + selectedIndex);

            if(selectedIndex == currentCorrectAnswerIndex)
            {
                System.out.println("User's selection is " + selectedIndex + ". Answer was " + currentCorrectAnswerIndex + ",");
                correctOrWrongLabel.setText("Correct!");
                correctOrWrongLabel.setTextFill(Color.GREEN);
            }
            else
            {
                System.out.println("User's selection is " + selectedIndex + ". Answer was " + currentCorrectAnswerIndex + ",");
                correctOrWrongLabel.setText("Incorrect!");
                correctOrWrongLabel.setTextFill(Color.RED);
            }

            quizCardsConfirmAnswerButton.setDisable(true);
            quizCardsNextButton.setDisable(false);
        } else {
            System.out.println("No item selected.");
        }
    }

    public void onNextButtonClick(ActionEvent event) {
        quizCardsConfirmAnswerButton.setDisable(false);
        quizCardsNextButton.setDisable(true);

        randomizeCurrentList();
        resetOptionList();

        setRandomlyPickedAnswerIndex();
        updateInfoLabel();

        correctOrWrongLabel.setText("");
    }
}