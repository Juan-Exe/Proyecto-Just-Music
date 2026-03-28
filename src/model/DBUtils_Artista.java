/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Interfaz_Artista;
import controller.Login_Oyente;
import controller.viewExampleController_1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author DAMIANA
 */
public class DBUtils_Artista {
    
    public boolean singUpUser(ActionEvent event, String correo, String contraseña) throws IOException {
        
        boolean registroExitoso = false;
        
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null; 
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/just_music", "just_music_user", "justmusic2024" );
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users_artista WHERE correo = ?");
            psCheckUserExists.setString(1, correo);
            resultSet = psCheckUserExists.executeQuery();
            
            if (resultSet.isBeforeFirst()) {
                System.out.println("El usuario ya existe!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Este Correo ya esta registrado");
                alert.show();
                
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users_artista (correo, contraseña) VALUES (?, ?)");
                psInsert.setString(1, correo);
                psInsert.setString(2, contraseña);
                psInsert.executeUpdate();
                
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setContentText("Registro exitoso");
                 alert.show();
                 
                
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InterfazArtista.fxml"));
                    Parent root = loader.load();
                    Interfaz_Artista controller = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
                
                registroExitoso = true;
                
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists !=null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    
                }
            }
            if (connection != null) {
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
         return registroExitoso;
    }
    
    public boolean logInUser(ActionEvent event, String correo, String contraseña) throws IOException {
        
        boolean loginExitoso = false;
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null; 
        
        try{
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/just_music", "just_music_user", "justmusic2024" );
        preparedStatement = connection.prepareStatement("SELECT contraseña FROM users_artista WHERE correo = ?");
        preparedStatement.setString(1, correo);
        resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.isBeforeFirst()){
                System.out.println("User not found in the database");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Las credenciales dadas son incorrectas");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrivedPassword = resultSet.getString("contraseña");
                    
                    if (retrivedPassword.equals(contraseña)) {
                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Inicio de sesión exitoso");
                        alert.show();
                        
                        
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InterfazArtista.fxml"));
                    Parent root = loader.load();
                    Interfaz_Artista controller = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
                        
                        loginExitoso = true;
                        
                    } else {
                        System.out.println("Passwords did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Las credenciales dadas son incorrectas");
                        alert.show();
                    }
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
         return loginExitoso;
    }
}
