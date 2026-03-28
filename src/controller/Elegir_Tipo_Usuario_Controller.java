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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class Elegir_Tipo_Usuario_Controller implements Initializable {

    @FXML
    private Button Button_Artista;
    @FXML
    private Button Button_Oyente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Sing_in_Artista(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login_Artista.fxml"));
    Parent root = loader.load();
    Login_Artista controller = loader.getController();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.sizeToScene();
        stage.setResizable(false);
        stage.show(); 

    Stage currentStage = (Stage) Button_Artista.getScene().getWindow();
    currentStage.close();
   } 


    @FXML
    private void Sing_in_Oyente(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login_Oyente.fxml"));
    Parent root = loader.load();
    Login_Oyente controller2 = loader.getController();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.sizeToScene();
        stage.setResizable(false);
        stage.show();

    Stage currentStage = (Stage) Button_Oyente.getScene().getWindow();
    currentStage.close();
   } 
}
