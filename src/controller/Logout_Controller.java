/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class Logout_Controller implements Initializable {

    private viewExampleController viewExampleController;
    
    @FXML
    private Button Logout_Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/viewExampleController.fxml"));
             Parent root = loader.load();
             viewExampleController = loader.getController();
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
             Stage currentStage = (Stage) Logout_Button.getScene().getWindow();
             currentStage.close();
        
        
    }
    
}
