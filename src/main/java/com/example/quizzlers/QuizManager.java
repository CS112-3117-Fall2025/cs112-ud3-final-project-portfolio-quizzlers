package com.example.quizzlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class QuizManager {
    ArrayList<Card> cardList;
    public final int MAX_OPTION_AMOUNT = 4;
    int numOptions = 0;
    ArrayList<Integer> randomlyPickedOptions;
    int currentCorrectAnswerIndex = -1;
    ObservableList<String> cardItems = FXCollections.observableArrayList();

    public QuizManager(ArrayList<Card> list) {
        cardList = new ArrayList<Card>(list);
        numOptions = getOptionAmount();
        randomlyPickedOptions = new ArrayList<Integer>(getOptionAmount());
        randomizeCurrentList();
        resetOptionList();
        setRandomlyPickedAnswerIndex();
    }

    public ObservableList<String> getCardItems() {
        return cardItems;
    }

    public int getCorrectAnswerIndex() {
        return currentCorrectAnswerIndex;
    }

    public String getCorrectDefinition() {
        int correctCardIndex = randomlyPickedOptions.get(currentCorrectAnswerIndex);
        return cardList.get(correctCardIndex).getDefinition();
    }

    public int getOptionAmount() {
        int cardAmount = cardList.size();
        if (cardAmount >= MAX_OPTION_AMOUNT) {
            return MAX_OPTION_AMOUNT;
        } else {
            return cardAmount;
        }
    }

    public void randomizeCurrentList() {
        randomlyPickedOptions.clear();

        int randomNum = (int) (Math.random() * cardList.size());
        randomlyPickedOptions.add(randomNum);

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
        }
    }

    public void resetOptionList() {
        cardItems.clear();
        for (int i = 0; i < randomlyPickedOptions.size(); i++) {
            cardItems.add(cardList.get(randomlyPickedOptions.get(i)).getName());
        }
    }

    public void setRandomlyPickedAnswerIndex() {
        currentCorrectAnswerIndex = (int) (Math.random() * randomlyPickedOptions.size());
    }

    public void nextQuestion() {
        randomizeCurrentList();
        resetOptionList();
        setRandomlyPickedAnswerIndex();
    }
}
