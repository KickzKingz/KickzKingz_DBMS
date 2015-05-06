/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import database.SQLExecuter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Context;

/**
 *
 * @author Kent
 */
public class InventoryUpdateController implements Initializable {
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
    private Label updateMessageLabel;
    
    @FXML
    private void handleUpdateDoneButtonAction(ActionEvent event)
    {
        String model, size, colorway, condition, price, cost;
        if (modelTextBox.getText().equals("") ||
                conditionTextBox.getText().equals("") ||
                sizeTextBox.getText().equals("") ||
                priceTextBox.getText().equals("") ||
                costTextBox.getText().equals("") ||
                colorwayTextBox.getText().equals(""))
        {
            updateMessageLabel.setTextFill(Color.RED);
            updateMessageLabel.setText("Must complete all fields");
        }else
        {
            model = modelTextBox.getText();
            size = sizeTextBox.getText();
            colorway = colorwayTextBox.getText();
            condition = conditionTextBox.getText();
            price = priceTextBox.getText();
            cost = costTextBox.getText();
            SQLExecuter.updateItemRecord
                (model, colorway, size, condition, cost, price,
                 Context.getInstance().currentInventoryItem().getINV_ID());
            System.out.println("Item updated.");
            InventoryController.getInventoryController().buildData();
            updateMessageLabel.setTextFill(Color.GREEN);
            updateMessageLabel.setText("Item updated.");
        }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorwayTextBox.setText
            (Context.getInstance().currentInventoryItem().getColorway());
        modelTextBox.setText
            (Context.getInstance().currentInventoryItem().getModel());
        priceTextBox.setText
            (Context.getInstance().currentInventoryItem().getPrice());
        costTextBox.setText
            (Context.getInstance().currentInventoryItem().getCost());
        sizeTextBox.setText
            (Context.getInstance().currentInventoryItem().getSize());
        conditionTextBox.setText
            (Context.getInstance().currentInventoryItem().getCondition());
        
    }
    
}
