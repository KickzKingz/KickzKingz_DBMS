/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import controller.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author Kent
 */
public class SQLExecuter {

    private static final String DB_URL = "jdbc:derby:KickzKingzDB";

    public static void main(String[] args)
            throws Exception {

        try ( //Create a connection to the database.
                Connection conn = DriverManager.getConnection(DB_URL);
                //Create a Statement object
                Statement stmt = conn.createStatement()) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter an SQL Statement..");
            String sql = keyboard.nextLine();
            stmt.execute(sql);
            conn.close();
            System.out.println("Done");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    public static void removeRecord(String tableName, String _id)
    {
        int id = Integer.parseInt(_id);
        String sql = "DELETE FROM " + tableName + " WHERE INV_ID = ?";
        try{
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                System.out.println("Item " + id + " removed from collection.");
            }
        } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     *
     * @param sql
     * @return
     */
    private static void execute(String sql) {
        //final String DB_URL = "jdbc:derby:KickzKingzDB";

        try {
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY,
                        ResultSet.TYPE_SCROLL_INSENSITIVE);
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("SQL executed.");
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static boolean checkPassword(String password, String username) {
        String selectSQL = "SELECT PASSWORD, USER_ID FROM USERS WHERE USER_ID = '"
                + username + "'";
        boolean flag = false;
        if (username.equals("") || password.equals("")) {
            flag = false;
        } else {
            try {
                Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY,
                        ResultSet.TYPE_SCROLL_INSENSITIVE);
                ResultSet rs = stmt.executeQuery(selectSQL);
                String uName = "";
                String pw = "";
                try {
                    while (rs.next()) {
                        uName = rs.getString("user_id");
                        pw = rs.getString("password");
                    }
                    if (uName.equals(username)) {
                        if (pw.equals(password)) {
                            flag = true;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("SQL executed.");
                conn.close();

            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        return flag;
    }
    
    public static void updateItemRecord(String model, String colorway, String size, 
            String condition, String cost, String price, String id) {
        int _id = Integer.parseInt(id);
        try {
            String updateSQL = "Update Inventory Set Model='" + model + "', " +
                    "Colorway='" + colorway + "', " +
                    "Condition='" + condition + "', " +
                    "Size='" + size + "', " +
                    "Price='" + price + "', " +
                    "Cost='" + cost + "' " +
                    "Where INV_ID=?";
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                PreparedStatement pstmt = conn.prepareStatement(updateSQL);
                pstmt.setInt(1, _id);
                pstmt.executeUpdate();
                System.out.println("SQL executed.");
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void sellItem(String inv_id, String cust_id) {
         try {
            String updateSQL = "Update Inventory Where ";
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                Statement stmt = conn.createStatement();
                stmt.executeQuery(updateSQL);
                System.out.println("SQL executed.");
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    public static void addItem(String model, String colorway, String size, 
            String condition, String cost, String price)
    {
        try{
            String insertSQL = "INSERT INTO INVENTORY "
                    + "(MODEL, COLORWAY, CONDITION, SIZE, PRICE, COST) " 
                    + "VALUES "
                    + "('" + model + "', "
                    + "'" + colorway + "', "
                    + "'" + condition + "', "
                    + "'" + size + "', "
                    + "'" + price + "', "
                    + "'" + cost + "')";
            Connection c = DriverManager.getConnection(DB_URL);
            Statement stmt = c.createStatement();
            stmt.executeUpdate(insertSQL);
            System.out.println("Item inserted");
            c.close();
        }
        catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
