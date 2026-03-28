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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBUtils;

/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class Login_Oyente implements Initializable {

    @FXML
    private Button BIngresar;
    @FXML
    private TextField IngreseUsuario;
    @FXML
    private TextField IngreseContraseña;
    @FXML
    private Button Button_Registrarse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   @FXML
    private void Ingresar(ActionEvent event) {
    String correo = IngreseUsuario.getText();
    String contraseña = IngreseContraseña.getText();
    
    DBUtils dbUtils = new DBUtils();
    try {
        boolean loginExitoso = dbUtils.logInUser(event, correo, contraseña);
        
        if (loginExitoso) {
            Stage currentStage = (Stage) BIngresar.getScene().getWindow();
            currentStage.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @FXML
    private void Registrarse(ActionEvent event) throws IOException {
        
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SingUp_Oyente.fxml"));
    Parent root = loader.load();
    SingUp_Oyente controller3 = loader.getController();
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.sizeToScene();
        stage.setResizable(false);
        stage.show(); 
    
    Stage currentStage = (Stage) Button_Registrarse.getScene().getWindow();
    currentStage.close();
        
    }
    
}
