/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import static controller.viewExampleController.mediaPlayer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import java.util.prefs.Preferences;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class Interfaz_Artista implements Initializable {
    
    

    @FXML
    private Button lisabt;
    @FXML
    private Button shuffleButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button playButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button bucleButton;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ImageView SongIVW;
    @FXML
    private Label SongLabel;
    @FXML
    private Label AlbumLabel;
    
    private Logout_Controller logout;

    private Map<String, String> albumImages = new HashMap<>();
    private ArrayList<File> songs;
    private MediaPlayer mediaPlayer;
    private ArrayList<String> songsPaths = new ArrayList<>();
    private int currentSongIndex = 0;
    private boolean randomMode = false;
    private boolean loopMode = false;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label Label_Seguidores;
    @FXML
    private Label Label_Reproducciones;
    
    private static final String REPRODUCCIONES_KEY = "reproducciones";
    
    private int numeroSeguidores = 0;
    private static final String SEGUIDORES_KEY = "seguidores";
    @FXML
    private Button Logout_Button;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadSongs();
        
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            double volume = newValue.doubleValue() / 100.0;
            setMediaPlayerVolume(volume);
        }
    });
        
        
        int reproducciones = cargarReproducciones();
        Label_Reproducciones.setText(String.valueOf(reproducciones));
        
        numeroSeguidores = cargarSeguidores();
        Label_Seguidores.setText(String.valueOf(numeroSeguidores));
        
        lisabt.setOnAction(event -> playSong(songsPaths.get(0)));
       
    }    

    private void loadSongs() {
          
        songsPaths.add("S_C_O_O_T_0_5/LISA - COVER.mp3");
        albumImages.put("S_C_O_O_T_0_5/LISA - COVER.mp3", "Mini_Images/Lisa Mini.png");
        
    }
    
    public void playOrPause() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                System.out.println("Estado del reproductor: PAUSANDO");
                mediaPlayer.pause();
            } else {
                System.out.println("Estado del reproductor: REANUDANDO");
                mediaPlayer.play();
            }
        }
    }

    private void initializeMediaPlayer(String songPath) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        Media media = new Media(new File(songPath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> playNextSong());
    }

    public void playNextSong() {
        if (isRandomMode()) {
            String randomSongPath = getRandomSong();
            playSong(randomSongPath);
        } else {
            if (loopMode) {
                playSong(songsPaths.get(currentSongIndex));
                return;
            }

            currentSongIndex = (currentSongIndex + 1) % songsPaths.size();
            String nextSongPath = songsPaths.get(currentSongIndex);
            playSong(nextSongPath);
        }
    }

    private boolean isRandomMode() {
        return randomMode;
    }

    public void toggleRandomMode() {
        randomMode = !randomMode;
        String message = randomMode ? "Modo aleatorio activado" : "Modo aleatorio desactivado";
        JOptionPane.showMessageDialog(null, message);
    }

    private String getRandomSong() {
        int randomIndex;
        do {
            randomIndex = (int) (Math.random() * songsPaths.size());
        } while (randomIndex == currentSongIndex);
        return songsPaths.get(randomIndex);
    }
    
    public void playSong(String songPath) {
    if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
    Media media = new Media(new File(songPath).toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();
    currentSongIndex = songsPaths.indexOf(songPath);

    String[] parts = songPath.split("/");
    String songName = parts[parts.length - 1]; 
    String albumName = parts[0]; 
    AlbumLabel.setText(albumName);
    SongLabel.setText(songName); 

    System.out.println("Reproduciendo canción: " + songName + " del álbum: " + albumName);

    mediaPlayer.setOnEndOfMedia(() -> {
        playNextSong();
        SongLabel.setText(songName);
    });

    String albumImagePath = albumImages.get(songPath);
    if (albumImagePath != null && SongIVW != null) {
        System.out.println("Ruta de la imagen del álbum: " + albumImagePath);
        Image albumImage = new Image(new File(albumImagePath).toURI().toString());
        SongIVW.setImage(albumImage);
        System.out.println("Imagen del álbum cargada correctamente en el ImageView.");
    } else {
        System.out.println("No se encontró la ruta de la imagen del álbum o el ImageView no está inicializado.");
    }
}
    
    public void playPreviousSong() {
    if (isRandomMode()) {
        String randomSongPath = getRandomSong();
        playSong(randomSongPath);
    } else {
        if (loopMode && currentSongIndex == 0) {
            playSong(songsPaths.get(currentSongIndex)); 
            return;
        }
        
        if (loopMode) {
            currentSongIndex = (currentSongIndex - 1 + songsPaths.size()) % songsPaths.size();
        } else if (currentSongIndex > 0) {
            currentSongIndex--; 
        }
        
        String previousSongPath = songsPaths.get(currentSongIndex);
        playSong(previousSongPath); 
    }
}
    
    @FXML
    private void pylisa(MouseEvent event) {
    }

    
    @FXML
    private void shuffleMedia(ActionEvent event) {
        toggleRandomMode();
    }

    @FXML
    private void resetMedia(ActionEvent event) {
        playPreviousSong();
    }

    @FXML
    private void play_pauseMedia(ActionEvent event) {
        playOrPause();
    }

    @FXML
    private void NextMedia(ActionEvent event) {
        playNextSong();
    }

    @FXML
    private void bucleMedia(ActionEvent event) {
    toggleLoopMode();
}
    
    public void setMediaPlayerVolume(double volume) {
    if (mediaPlayer != null) {
        mediaPlayer.setVolume(volume);
    }
}

    public void toggleLoopMode() {
    loopMode = !loopMode;
    String message = loopMode ? "Modo de bucle activado" : "Modo de bucle desactivado";
    JOptionPane.showMessageDialog(null, message);
}
    private int cargarReproducciones() {
        Preferences prefs = Preferences.userNodeForPackage(Interfaz_Artista.class);
        return prefs.getInt("reproducciones", 0);
    }
    
        private int incrementarReproducciones() {
        Preferences prefs = Preferences.userNodeForPackage(Interfaz_Artista.class);
        int reproduccionesActuales = prefs.getInt("reproducciones", 0);
        int nuevasReproducciones = reproduccionesActuales + 1;
        prefs.putInt("reproducciones", nuevasReproducciones);
        return nuevasReproducciones;
        
    }
       private int cargarSeguidores() {
        Preferences prefs = Preferences.userNodeForPackage(Interfaz_Artista.class);
        return prefs.getInt(SEGUIDORES_KEY, 0);
    }

    private void guardarSeguidores(int numeroSeguidores) {
        Preferences prefs = Preferences.userNodeForPackage(Interfaz_Artista.class);
        prefs.putInt(SEGUIDORES_KEY, numeroSeguidores);
    }

    public void incrementarSeguidores() {
        numeroSeguidores++;

        Label_Seguidores.setText(String.valueOf(numeroSeguidores));

        guardarSeguidores(numeroSeguidores);
    }
    
    public void actualizarSeguidores(int nuevoNumeroSeguidores) {

        Label_Seguidores.setText(Integer.toString(nuevoNumeroSeguidores));
    }
    
         public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @FXML
    private void Logout(MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Logout.fxml"));
             Parent root = loader.load();
             Logout_Controller controller = loader.getController();
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
             Stage currentStage = (Stage) Logout_Button.getScene().getWindow();
             currentStage.close();
             getMediaPlayer().stop();
    }
        
}



