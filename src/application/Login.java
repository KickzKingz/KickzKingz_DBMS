/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kent
 */
public class Login extends Application {
    
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        Parent root =(Parent)loader.load();
        primaryStage.setTitle("KickzKingz DBMS");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("/view/Login.css").toExternalForm());
        primaryStage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Application.launch(Login.class, args);
    }

}
