package com.example.quizzlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddCardController {
    public Label cardDefinitionLabel;
    public TextArea inputNameTextbox;
    public Label cardNameLabel;
    public TextArea inputDefinitionTextbox;

    static ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>();
    public Label warningLabel;

    private QuizzlersController mainController;

    public void setMainController(QuizzlersController controller) {
        mainController = controller;
    }

    @FXML
    public void onConfirmAddButtonClick(ActionEvent event) {
        try {
            validateNewCard();
            cardList.add(new DefinitionCard(inputNameTextbox.getText(), inputDefinitionTextbox.getText()));

            if (cardList.size() == 1 && mainController != null) {
                mainController.enableCardActions();
            }

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

        } catch (CardAlreadyExistsException e) {
            warningLabel.setText("Cannot add card. Name or definition is already used.");
            System.out.println("User attempted to add card with an already used name or definition.");
        }
    }

    public void validateNewCard() throws CardAlreadyExistsException {
        for (int i = 0; i < cardList.size(); i++) {
            if (inputNameTextbox.getText().equalsIgnoreCase(cardList.get(i).getName()) ||
                    inputDefinitionTextbox.getText().equalsIgnoreCase(cardList.get(i).getDefinition())) {

                throw new CardAlreadyExistsException();
            }
        }
    }

    public static ArrayList<DefinitionCard> getCardList()
    {
        return cardList;
    }
}
