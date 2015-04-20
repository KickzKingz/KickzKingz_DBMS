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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;



/**
 *
 * @author Kent
 */
public class TransactionController implements Initializable {
    
    @FXML private ComboBox reportChoiceBox;
    @FXML private Button reportButton;
    @FXML private TableView transactionTable;
    
    @FXML private void reportButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void reportComboBoxSelectionChanged(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transactionTable.getColumns().addAll(SQLExecuter.getTableColumns("TRANSACTIONS"));
        transactionTable.setItems(SQLExecuter.buildData("TRANSACTIONS"));
        transactionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
