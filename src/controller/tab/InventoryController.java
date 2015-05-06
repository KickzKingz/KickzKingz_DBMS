/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import application.tab.CustomerSelector;
import application.tab.InventoryAdd;
import application.tab.InventoryUpdate;
import database.SQLExecuter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Context;
import model.Customer;
import model.InventoryItem;

/**
 *
 * @author Kent
 */
public class InventoryController implements Initializable {
    
    private final static InventoryController ic = new InventoryController();
    

    @FXML
    private Button inventoryAddButton;
    @FXML
    private Button inventoryRemoveButton;
    @FXML
    private Button inventoryUpdateButton;
    @FXML
    private static TableView<InventoryItem> inventoryTable;

    private static ObservableList<InventoryItem> data;

    @FXML
    private TableColumn<InventoryItem, String> tableColumnINV_ID = 
            new TableColumn();

    @FXML
    private TableColumn<InventoryItem, String> tableColumnModel = 
            new TableColumn();

    @FXML
    private TableColumn<InventoryItem, String> tableColumnColorway = 
            new TableColumn();

    @FXML
    private TableColumn<InventoryItem, String> tableColumnSize = 
            new TableColumn();

    @FXML

    private TableColumn<InventoryItem, String> tableColumnPrice = 
            new TableColumn();

    @FXML
    private TableColumn<InventoryItem, String> tableColumnCost = 
            new TableColumn();

    @FXML
    private TableColumn<InventoryItem, String> tableColumnCondition = 
            new TableColumn();

    @FXML
    private void inventoryAddButtonClicked(ActionEvent event) {
        //Stage newStage = new Stage();
        InventoryAdd add = new InventoryAdd();
        try{
            add.start();
        }catch (Exception ex){
            Logger.getLogger(InventoryController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void inventoryRemoveButtonClicked(ActionEvent event) {

        InventoryItem item = 
                inventoryTable.getSelectionModel().getSelectedItem();

        item = inventoryTable.getSelectionModel().getSelectedItem();

        SQLExecuter.removeRecord("Inventory", item.getINV_ID());
        data.removeAll(data);
        buildData();
    }

    @FXML
    private void inventoryUpdateButtonClicked(ActionEvent event) {
        
            Context.getInstance().setCurrentInventoryItem
                (inventoryTable.getSelectionModel().getSelectedItem()); 
                    
            //Stage newStage = new Stage();
            InventoryUpdate update = new InventoryUpdate();
        try {
            update.start("/view/tab/InventoryUpdateWindow.fxml","Update Item");
        } catch (Exception ex) {
            Logger.getLogger(InventoryController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    protected void handleSellButtonAction(ActionEvent event) {
        Context.getInstance().setCurrentInventoryItem
                (inventoryTable.getSelectionModel().getSelectedItem());
        try {
            //InventoryItem item;
            //item = inventoryTable.getSelectionModel().getSelectedItem();
            CustomerSelector cs = new CustomerSelector();
            //Stage stage = new Stage();
            cs.start();
            //SQLExecuter.sellItem(item.getINV_ID(), cs.getCUST_ID());
        } catch (Exception ex) {
            Logger.getLogger(InventoryController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inventoryTable.setColumnResizePolicy
        (TableView.CONSTRAINED_RESIZE_POLICY);
        tableColumnINV_ID.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("INV_ID"));
        tableColumnColorway.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Colorway"));
        tableColumnModel.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Model"));
        tableColumnSize.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Size"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Price"));
        tableColumnCost.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Cost"));
        tableColumnCondition.setCellValueFactory(new PropertyValueFactory
                <InventoryItem, String>("Conditon"));
        
        buildData();

    }

    public static void buildData() {

        final String DB_URL
                = "jdbc:derby:KickzKingzDB";

        data = FXCollections.observableArrayList();

        try {
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from INVENTORY WHERE Sold='N'";
            ResultSet rs = c.createStatement().executeQuery(sql);

            inventoryTable.getColumns().addAll();

            while (rs.next()) {
                InventoryItem item = new InventoryItem();
                item.setINV_ID(rs.getString(3));
                item.setModel(rs.getString(1));
                item.setColorway(rs.getString(2));
                item.setSize(rs.getString(5));
                item.setCondition(rs.getString(4));
                item.setPrice(rs.getString(6));
                item.setCost(rs.getString(7));
                data.add(item);
            }
            inventoryTable.setItems(data);
            inventoryTable.setColumnResizePolicy
                (TableView.CONSTRAINED_RESIZE_POLICY);
            c.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error on building data");
        }
    }
    
    public static InventoryController getInventoryController(){
        return ic;
    }

}
