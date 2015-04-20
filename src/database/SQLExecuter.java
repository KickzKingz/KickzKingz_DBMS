/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import controller.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;
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
            ex.printStackTrace();
        }
    }
    
    public static String[] removeItemRecord(String id)
    {
        String sql = "DELETE * FROM Inventory WHERE INV_ID=" + id;
        String[] record = new String[7];
        try{
             Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL executed.");
            conn.close();
        } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        return record;
    }

    /**
     *
     * @param sql
     * @return
     */
    private static void execute(String sql) {
        //final String DB_URL = "jdbc:derby:KickzKingzDB";

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement(ResultSet.CONCUR_READ_ONLY,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL executed.");
            conn.close();

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
    
    public static ObservableList<ObservableList> buildData(String tablename)
    {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try{
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from " + tablename;
            
            ResultSet  rs = c.createStatement().executeQuery(sql);
            
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            //c.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Error on building data");
        }
        return data;
    }
    
    public static  ArrayList<TableColumn>getTableColumns(String tablename)
    {
        ArrayList<TableColumn> columns = new ArrayList<>();
        try{
            Connection c = DriverManager.getConnection(DB_URL);
            String sql = "SELECT * from " + tablename;
            ResultSet  rs = c.createStatement().executeQuery(sql);
            
            for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
            {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                //col.setMinWidth(75);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> p) {
                        return new SimpleStringProperty(p.getValue().get(j).toString());
                    }
                });
                columns.add(col);
            }
            //c.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Error getting column names.");
        }
        
        return columns;
    }
}
