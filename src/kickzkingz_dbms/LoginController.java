/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kickzkingz_dbms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kent
 */
public class LoginController {
    @FXML private Text signinmessage;
    
    @FXML protected void handleSignInButtonAction(ActionEvent event) {
        //signinmessage.setText("Sign in button presssed");
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
        
    }
    
}
