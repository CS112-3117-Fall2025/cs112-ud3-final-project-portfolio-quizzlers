package com.example.quizzlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class BrowseCardsController {
    public Label browseCardsInfoLabel;
    public Label browseCardsNameLabel;

    @FXML
    private ListView<String> browseCardsNameListView;
    ArrayList<DefinitionCard> cardList = new ArrayList<DefinitionCard>(AddCardController.getCardList());

    public void initialize() {
        ObservableList<String> cardItems = FXCollections.observableArrayList();

        for (int i = 0; i < cardList.size(); i++)
        {
            cardItems.add(cardList.get(i).getName());
        }
        browseCardsNameListView.setItems(cardItems);
    }

    @FXML
    protected void onCardNameListClicked()
    {
        String selectedItem = browseCardsNameListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            System.out.println("Selected item: " + selectedItem);

            // Loop through all items in list
            for (int i = 0; i < cardList.size(); i++)
            {
                // Check if name is equal to selectedItem
                if(cardList.get(i).getName().equals(selectedItem))
                {
                    // Set definition label to match selectedItem's definition
                    browseCardsInfoLabel.setText(cardList.get(i).getDefinition());
                }
            }
        } else {
            System.out.println("No item selected.");
        }
    }
}