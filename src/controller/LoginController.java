/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.MainScreen;

/**
 *
 * @author Kent
 */
public class LoginController {
    @FXML private Text signinmessage;
    
    @FXML protected void handleSignInButtonAction(ActionEvent event) {
        
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Stage newStage = new Stage();
            MainScreen main = new MainScreen();
            main.start(newStage);
            
            signinmessage.setText("Sign in button presssed");
//        Node source = (Node)event.getSource();
//        Stage stage = (Stage)source.getScene().getWindow();
//        stage.close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
