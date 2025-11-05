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

    @FXML
    protected void onConfirmAddButtonClick(ActionEvent event) {
        // Take information and create new card
        cardList.add(new DefinitionCard(inputNameTextbox.getText(), inputDefinitionTextbox.getText(), "Default Category"));

        // Close everything

        // Get the source of the event (e.g., a Button)
        Node source = (Node) event.getSource();
        // Get the Scene from the Node
        Stage stage = (Stage) source.getScene().getWindow();
        // Close the Stage
        stage.close();
    }

    public static ArrayList<DefinitionCard> getCardList()
    {
        return cardList;
    }
}
