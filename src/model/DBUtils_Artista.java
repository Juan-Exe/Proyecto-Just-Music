package model;

import controller.Interfaz_Artista;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DBUtils_Artista {

    // Usuarios artista hardcodeados: correo -> contraseña
    private static final Map<String, String> USERS_ARTISTA = new HashMap<>();

    static {
        USERS_ARTISTA.put("artista@justmusic.com", "artista123");
        USERS_ARTISTA.put("scoot@justmusic.com", "scoot123");
    }

    public boolean singUpUser(ActionEvent event, String correo, String contraseña) throws IOException {
        if (USERS_ARTISTA.containsKey(correo)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Just Music");
            alert.setHeaderText(null);
            alert.setContentText("Este correo ya está registrado.");
            alert.getDialogPane().setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #05B2A8; -fx-border-width: 2; -fx-border-radius: 8; -fx-background-radius: 8;");
            alert.getDialogPane().lookupButton(javafx.scene.control.ButtonType.OK).setStyle("-fx-background-color: #05B2A8; -fx-text-fill: white; -fx-background-radius: 6;");
            alert.showAndWait();
            return false;
        }

        USERS_ARTISTA.put(correo, contraseña);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InterfazArtista.fxml"));
        Parent root = loader.load();
        Interfaz_Artista controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        return true;
    }

    public boolean logInUser(ActionEvent event, String correo, String contraseña) throws IOException {
        if (!USERS_ARTISTA.containsKey(correo)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Just Music");
            alert.setHeaderText(null);
            alert.setContentText("Las credenciales dadas son incorrectas.");
            alert.getDialogPane().setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #05B2A8; -fx-border-width: 2; -fx-border-radius: 8; -fx-background-radius: 8;");
            alert.getDialogPane().lookupButton(javafx.scene.control.ButtonType.OK).setStyle("-fx-background-color: #05B2A8; -fx-text-fill: white; -fx-background-radius: 6;");
            alert.showAndWait();
            return false;
        }

        String savedPassword = USERS_ARTISTA.get(correo);
        if (!savedPassword.equals(contraseña)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Just Music");
            alert.setHeaderText(null);
            alert.setContentText("Las credenciales dadas son incorrectas.");
            alert.getDialogPane().setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #05B2A8; -fx-border-width: 2; -fx-border-radius: 8; -fx-background-radius: 8;");
            alert.getDialogPane().lookupButton(javafx.scene.control.ButtonType.OK).setStyle("-fx-background-color: #05B2A8; -fx-text-fill: white; -fx-background-radius: 6;");
            alert.showAndWait();
            return false;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InterfazArtista.fxml"));
        Parent root = loader.load();
        Interfaz_Artista controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
        return true;
    }
}
