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
import database.SQLExecuter;
import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.User;

/**
 *
 * @author Kent
 */
public class LoginController {

    @FXML
    private Text signinmessage;
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passwordField;
    private User user;

    @FXML
    protected void handleSignInButtonAction(ActionEvent event) {

        String userName = userField.getText().trim();
        String password = passwordField.getText();
        signinmessage.setVisible(false);

        if (SQLExecuter.checkPassword(password, userName)) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            Stage newStage = new Stage();
            MainScreen main = new MainScreen();
            try {
                main.start(newStage);
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            signinmessage.setVisible(true);
            signinmessage.setFill(Color.RED);
            signinmessage.setText("Invalid login.");
        }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        private final EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>(){
//
//        @Override
//        public void handle(KeyEvent t) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//            
//        };
//   
//        }
}

