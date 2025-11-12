package com.example.quizzlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddCardController {
    public Label cardDefinitionLabel;
    public TextArea inputNameTextbox;
    public Label cardNameLabel;
    public TextArea inputDefinitionTextbox;

    static ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>();
    public Label warningLabel;

    @FXML
    protected void onConfirmAddButtonClick(ActionEvent event) {
        // Take information and create new card
        if (validateNewCard())
        {
            cardList.add(new DefinitionCard(inputNameTextbox.getText(), inputDefinitionTextbox.getText(), "Default Category"));

            // Close everything

            // Get the source of the event (e.g., a Button)
            Node source = (Node) event.getSource();
            // Get the Scene from the Node
            Stage stage = (Stage) source.getScene().getWindow();
            // Close the Stage
            stage.close();
        }
        else
        {
            warningLabel.setText("Cannot add card. Name or definition is already used.");
            System.out.println(("You already have a card with that name or definition."));
        }
    }

    public boolean validateNewCard()
    {
        // Check if name already exists
        for (int i = 0; i < cardList.size(); i++)
        {
            if (inputNameTextbox.getText().equalsIgnoreCase(cardList.get(i).getName()) || inputDefinitionTextbox.getText().equalsIgnoreCase(cardList.get(i).getDefinition()))
            {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<DefinitionCard> getCardList()
    {
        return cardList;
    }
}
