/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tab;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Kent
 */
public class InventoryAdd {
    public void start() throws Exception {
        Stage stage = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource
            ("/view/tab/InventoryAddWindow.fxml"));
        stage.setTitle("Add Item");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.initModality(Modality.APPLICATION_MODAL);
        //scene.getStylesheets().add()
        stage.show();
    }
}
