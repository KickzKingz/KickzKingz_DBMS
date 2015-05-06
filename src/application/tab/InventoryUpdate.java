/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tab;

import application.MainScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.InventoryItem;

/**
 *
 * @author Kent
 */
public class InventoryUpdate {

    public void start(String screenname,String title) throws Exception {
        Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource(screenname));
        stage.setTitle(title);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.initModality(Modality.APPLICATION_MODAL);
        //scene.getStylesheets().add()
        stage.show();
    }
}
