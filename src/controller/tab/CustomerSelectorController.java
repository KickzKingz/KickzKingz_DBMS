/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tab;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.Customer;

/**
 * FXML Controller class
 *
 * @author Kent
 */
public class CustomerSelectorController implements Initializable {
    
    @FXML
    private ComboBox customerComboBox;
    private ObservableList<String> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateCustomerComboBox();
        
    }    
    
    private void populateCustomerComboBox(){
        data = FXCollections.observableArrayList();
        try{
            Connection conn = DriverManager.getConnection
        ("jdbc:derby:KickzKingzDB");
            String sql = "Select * from CUSTOMERS";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                String name = rs.getString(1) + ", "
                        + rs.getString(2);
//                c.setName_First(rs.getString(2));
//                c.setCUST_ID(rs.getString(3));
//                c.setState(rs.getString(4));
//                c.setCity(rs.getString(5)); 
//                c.setZip(rs.getString(6));
//                c.setAddress(rs.getString(7));
//                c.setEmail(rs.getString(8));
//                c.setEmail(rs.getString(9));
                data.add(name);
            }
            customerComboBox = new ComboBox();
            customerComboBox.setItems(data);
            conn.close();
            //rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerSelectorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
