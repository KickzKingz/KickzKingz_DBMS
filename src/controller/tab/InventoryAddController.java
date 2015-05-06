/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import database.SQLExecuter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Context;

/**
 *
 * @author Kent
 */
public class InventoryAddController {
    @FXML
    private TextField modelTextBox;
    
    @FXML
    private TextField colorwayTextBox;
    
    @FXML
    private TextField sizeTextBox;
    
    @FXML
    private TextField conditionTextBox;
    
    @FXML
    private TextField priceTextBox;
    
    @FXML
    private TextField costTextBox;
    
    @FXML
    private Label addMessageLabel;
    
    @FXML
    private void handleAddButtonAction(ActionEvent event)
    {
         String model, size, colorway, condition, price, cost;
        if (modelTextBox.getText().equals("") ||
                conditionTextBox.getText().equals("") ||
                sizeTextBox.getText().equals("") ||
                priceTextBox.getText().equals("") ||
                costTextBox.getText().equals("") ||
                colorwayTextBox.getText().equals(""))
        {
            addMessageLabel.setTextFill(Color.RED);
            addMessageLabel.setText("Must complete all fields");
        }else
        {
            model = modelTextBox.getText();
            size = sizeTextBox.getText();
            colorway = colorwayTextBox.getText();
            condition = conditionTextBox.getText();
            price = priceTextBox.getText();
            cost = costTextBox.getText();
            SQLExecuter.addItem
                (model, colorway, size, condition, cost, price);
            //System.out.println("Ite.");
            InventoryController.getInventoryController().buildData();
            addMessageLabel.setTextFill(Color.GREEN);
            addMessageLabel.setText("Item added.");
        }
    }
}
