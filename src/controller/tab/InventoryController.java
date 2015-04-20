/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import database.SQLExecuter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.InventoryItem;

/**
 *
 * @author Kent
 */
public class InventoryController implements Initializable {

    @FXML
    private Button inventoryAddButton;
    @FXML
    private Button inventoryRemoveButton;
    @FXML
    private Button inventoryUpdateButton;
    @FXML
    private TableView<InventoryItem> inventoryTable;

    private ObservableList<InventoryItem> data;
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnINV_ID;
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnModel = new TableColumn();
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnColorway = new TableColumn();
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnSize = new TableColumn();
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnPrice = new TableColumn();
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnCost = new TableColumn();
    
    @FXML
    private TableColumn<InventoryItem, String> tableColumnCondition = new TableColumn();
    

    @FXML
    private void inventoryAddButtonClicked(ActionEvent event) {
        
        InventoryItem item = new InventoryItem();
        
    }

    @FXML
    private void inventoryRemoveButtonClicked(ActionEvent event) {

    }

    @FXML
    private void inventoryUpdateButtonClicked(ActionEvent event) {

    }

    @FXML
    protected void handleSellButtonAction(ActionEvent event) {
        //Cursor cursor = inventoryTable.getCursor();
        //data = inventoryTable.getItems();
        InventoryItem item = new InventoryItem();
        item = inventoryTable.getSelectionModel().getSelectedItem();
        SQLExecuter.removeItemRecord(item.getINV_ID());
        //String[] itemSpecs = SQLExecuter.getItemRecord(id);

        //item.setItemId(itemSpecs[0]);
        //item.setItemCondition(itemSpecs[1]);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inventoryTable.getColumns().addAll(SQLExecuter.getTableColumns("INVENTORY"));
        //inventoryTable.setItems(SQLExecuter.buildData("INVENTORY"));
        inventoryTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableColumnINV_ID.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("INV_ID"));
        tableColumnColorway.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Colorway"));
        tableColumnModel.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Model"));
        tableColumnSize.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Size"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Price"));
        tableColumnCost.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Cost"));
        tableColumnCondition.setCellValueFactory(new PropertyValueFactory<InventoryItem, String>("Conditon"));
        buildData();

    }

    private void buildData() {

        final String DB_URL
                = "jdbc:derby:KickzKingzDB";

        data = FXCollections.observableArrayList();

        try {
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from INVENTORY";
            ResultSet rs = c.createStatement().executeQuery(sql);

//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                //col.setMinWidth(75);
//                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                    @Override
//                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> p) {
//                        return new SimpleStringProperty(p.getValue().get(j).toString());
//                    }
//                });
//                
//                
//            }
            
            inventoryTable.getColumns().addAll();

            while (rs.next()) {
                InventoryItem item = new InventoryItem();
//                ObservableList<String> row = FXCollections.observableArrayList();
//                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
//                    row.add(rs.getString(i));
//                }
                item.setINV_ID(rs.getString(3));
                item.setModel(rs.getString(1));
                item.setColorway(rs.getString(2));
                item.setSize(rs.getString(5));
                item.setCondition(rs.getString(4));
                item.setCost(rs.getString(6));
                item.setPrice(rs.getString(7));
                data.add(item);
            }
            inventoryTable.setItems(data);
            inventoryTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            c.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error on building data");

        }
    }

}
