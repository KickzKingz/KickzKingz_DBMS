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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Customer;

/**
 *
 * @author Kent
 */
public class CustomerController implements Initializable{
    @FXML private Button customerAddButton;
    @FXML private Button customerRemoveButton;
    @FXML private Button customerUpdateButton;
    @FXML private TableView<Customer> customersTable;
    
    private ObservableList<Customer> data;
    
    @FXML TableColumn<Customer, String> tableColumnName_Last;
    
    @FXML TableColumn<Customer, String> tableColumnName_First;
    
    @FXML TableColumn<Customer, String> tableColumnCUST_ID;
    
    @FXML TableColumn<Customer, String> tableColumnState;
    
    @FXML TableColumn<Customer, String> tableColumnCity;
    
    @FXML TableColumn<Customer, String> tableColumnZip;
    
    @FXML TableColumn<Customer, String> tableColumnAddress;
    
    @FXML TableColumn<Customer, String> tableColumnEmail;
    
    @FXML TableColumn<Customer, String> tableColumnPhone;
    
    
    @FXML private void customerAddButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void customerRemoveButtonClicked(ActionEvent event) {
        
    }
    
    @FXML private void customerUpdateButtonClicked(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //customersTable.getColumns().addAll(SQLExecuter.getTableColumns("CUSTOMERS"));
        //customersTable.setItems(SQLExecuter.buildData("CUSTOMERS"));
        customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableColumnName_Last.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name_Last"));
        tableColumnName_First.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name_First"));
        tableColumnCUST_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("CUST_ID"));
        tableColumnState.setCellValueFactory(new PropertyValueFactory<Customer, String>("State"));
        tableColumnCity.setCellValueFactory(new PropertyValueFactory<Customer, String>("City"));
        tableColumnZip.setCellValueFactory(new PropertyValueFactory<Customer, String>("Zip"));
        tableColumnAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<Customer, String>("Email"));
        tableColumnPhone.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone"));
        buildData();
        
    }
    
    private void buildData() {

        final String DB_URL
                = "jdbc:derby:KickzKingzDB";

        data = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from CUSTOMERS";
            ResultSet rs = conn.createStatement().executeQuery(sql);

//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                //col.setMinWidth(75);
//                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                    @Override
//                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> p) {
//                        return new SimpleStringProperty(p.getValue().get(j).toString());
//                    }
//                });
//                customersTable.getColumns().addAll(col);
//            }

            while (rs.next()) {
                Customer c = new Customer();
                c.setName_Last(rs.getString(1));
                c.setName_First(rs.getString(2));
                c.setCUST_ID(rs.getString(3));
                c.setState(rs.getString(4));
                c.setCity(rs.getString(5));
                c.setZip(rs.getString(6));
                c.setAddress(rs.getString(7));
                c.setEmail(rs.getString(8));
                c.setEmail(rs.getString(9));
                data.add(c);
                }
            customersTable.setItems(data);
            customersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            conn.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error on building data");

        }

    }
}
