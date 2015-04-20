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
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author Kent
 */
public class CustomerController implements Initializable{
    @FXML private Button customerAddButton;
    @FXML private Button customerRemoveButton;
    @FXML private Button customerUpdateButton;
    @FXML private TableView customersTable;
    
    private ObservableList<ObservableList> data;
    
    @FXML private void customerAddButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void customerRemoveButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void customerUpdateButtonClicked(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        customersTable.getColumns().addAll(SQLExecuter.getTableColumns("CUSTOMERS"));
        customersTable.setItems(SQLExecuter.buildData("CUSTOMERS"));
        customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //buildData();
        
    }
    
    private void buildData() {

        final String DB_URL
                = "jdbc:derby:KickzKingzDB";

        data = FXCollections.observableArrayList();

        try {
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from CUSTOMERS";
            ResultSet rs = c.createStatement().executeQuery(sql);

            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                //col.setMinWidth(75);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> p) {
                        return new SimpleStringProperty(p.getValue().get(j).toString());
                    }
                });
                customersTable.getColumns().addAll(col);
            }

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            customersTable.setItems(data);
            customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            c.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error on building data");

        }

    }
}
