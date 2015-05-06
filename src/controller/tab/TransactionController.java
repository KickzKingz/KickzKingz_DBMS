/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import database.SQLExecuter;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaction;



/**
 *
 * @author Kent
 */
public class TransactionController implements Initializable {
    
    @FXML private ComboBox reportChoiceBox;
    @FXML private Button reportButton;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> tableColumnCUST_ID;
    @FXML private TableColumn<Transaction, String> tableColumnINV_ID;
    @FXML private TableColumn<Transaction, String> tableColumnTRANS_ID;
    @FXML private TableColumn<Transaction, Date> tableColumnDate;
    
    private ObservableList<Transaction> data;
    
    @FXML private void reportButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void reportComboBoxSelectionChanged(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //transactionTable.getColumns().addAll(SQLExecuter.getTableColumns("TRANSACTIONS"));
        //transactionTable.setItems(SQLExecuter.buildData("TRANSACTIONS"));
        //transactionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableColumnCUST_ID.setCellValueFactory(new PropertyValueFactory<Transaction, String>("CUST_ID"));
        tableColumnINV_ID.setCellValueFactory(new PropertyValueFactory<Transaction, String>("INV_ID"));
        tableColumnTRANS_ID.setCellValueFactory(new PropertyValueFactory<Transaction, String>("TRANS_ID"));
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<Transaction, Date>("Date"));
        buildData();
    }
    
    private void buildData() {

        final String DB_URL
                = "jdbc:derby:KickzKingzDB";

        data = FXCollections.observableArrayList();

        try {
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from Transactions";
            ResultSet rs = c.createStatement().executeQuery(sql);

            transactionTable.getColumns().addAll();

            while (rs.next()) {
                Transaction t = new Transaction();
                t.setCUST_ID(rs.getString(1));
                t.setINV_ID(rs.getString(2));
                t.setTRANS_ID(rs.getString(3));
                t.setDate(rs.getDate(4));
                data.add(t);
            }
            transactionTable.setItems(data);
            transactionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            c.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error on building data");

        }
    }
}
