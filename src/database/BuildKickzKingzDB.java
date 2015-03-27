
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
                    "Name_Last CHAR(50), " +
                    "Name_First CHAR(50), " +
                    "USER_ID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Password CHAR(50))");
            System.out.println("Created the Users table...");
            
            System.out.println("Creating the Customers table...");
            stmt.execute("CREATE TABLE Customers (" +
                    "Name_Last CHAR(50), " +
                    "Name_First CHAR(50), " +
                    "CUST_ID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "State CHAR(50), " +
                    "City CHAR(20), " +
                    "Zip CHAR(5), " +
                    "Address CHAR(50), " +
                    "Email VARCHAR(50), " +
                    "Phone CHAR(10))");
            System.out.println("Created the Customers table...");
            
            System.out.println("Creating the Inventory table...");
            stmt.execute("CREATE TABLE Inventory (" +
                    "Model CHAR(50), " +
                    "Colorway CHAR(50), " +
                    "INV_ID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Condition CHAR(2), " +
                    "Size CHAR(20), " +
                    "Price CHAR(5), " +
                    "Paid CHAR(50))");
            System.out.println("Created the Inventory table...");
            
            System.out.println("Creating the Transactions table...");
            stmt.execute("CREATE TABLE Transactions (" +
                    "CUST_ID CHAR(10), " +
                    "INV_ID CHAR(10), " +
                    "TRANS_ID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Date CHAR(50), " +
                    "FOREIGN KEY(CUST_ID) REFERENCES Customers(CUST_ID), " +
                    "FOREIGN KEY(INV_ID) REFERENCES Inventory(INV_ID))");
            System.out.println("Created the Transactions table...");
            
            System.out.println("Creating the Events table...");
            stmt.execute("CREATE TABLE Events (" +
                    "Name CHAR(50), " +
                    "Location CHAR(50), " +
                    "EVENT_ID CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Date CHAR(50), " +
                    "Time CHAR(20), " +
                    "Zip CHAR(5), " +
                    "Description CHAR(50))");
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
