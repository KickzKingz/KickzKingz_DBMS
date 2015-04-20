
package database;

import java.sql.*;

/**
 *
 * @author kent
 */
public class BuildKickzKingzDB {
    public static void main(String[] args) 
            throws Exception
    {
        final String DB_URL = 
                "jdbc:derby:KickzKingzDB;create=true";
        
        try
        {
            //Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);
            
            //Create a Statement object
            Statement stmt = conn.createStatement();
            
            //Create the card table
            System.out.println("Creating the Users table...");
            stmt.execute("CREATE TABLE Users (" +
                    "Name_Last VARCHAR(20), " +
                    "Name_First VARCHAR(20), " +
                    "USER_ID VARCHAR(10) NOT NULL PRIMARY KEY, " +
                    "Password VARCHAR(50))");
            System.out.println("Created the Users table...");
            
            System.out.println("Creating the Customers table...");
            stmt.execute("CREATE TABLE Customers (" +
                    "Name_Last VARCHAR(20), " +
                    "Name_First VARCHAR(20), " +
                    "CUST_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "State CHAR(2), " +
                    "City VARCHAR(20), " +
                    "Zip CHAR(5), " +
                    "Address VARCHAR(50), " +
                    "Email VARCHAR(50), " +
                    "Phone CHAR(10))");
            System.out.println("Created the Customers table...");
            
            System.out.println("Creating the Inventory table...");
            stmt.execute("CREATE TABLE Inventory (" +
                    "Model VARCHAR(50), " +
                    "Colorway VARCHAR(50), " +
                    "INV_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "Condition CHAR(2), " +
                    "Size VARCHAR(10), " +
                    "Price VARCHAR(5), " +
                    "Cost VARCHAR(10))");
            System.out.println("Created the Inventory table...");
            
            System.out.println("Creating the Transactions table...");
            stmt.execute("CREATE TABLE Transactions (" +
                    "CUST_ID INT, " +
                    "INV_ID INT, " +
                    "TRANS_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "Date DATE, " +
                    "FOREIGN KEY(CUST_ID) REFERENCES Customers(CUST_ID), " +
                    "FOREIGN KEY(INV_ID) REFERENCES Inventory(INV_ID))");
            System.out.println("Created the Transactions table...");
            
            System.out.println("Creating the Events table...");
            stmt.execute("CREATE TABLE Events (" +
                    "Name VARCHAR(30), " +
                    "Location VARCHAR(20), " +
                    "EVENT_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "Date DATE, " +
                    "Time TIME, " +
                    "Description VARCHAR(50))");
            System.out.println("Created the Events table...");
            
            //Close the resources
            stmt.close();
            conn.close();
            System.out.println("Done");
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
