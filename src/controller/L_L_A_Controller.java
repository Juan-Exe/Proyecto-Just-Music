/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Platform;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class L_L_A_Controller implements Initializable, AlbumController {

    @FXML
    private Button BT_LLA;
    @FXML
    private Button BT_Gold;
    @FXML
    private Button BT_PMW;
    @FXML
    private Button BT_LVL;
    @FXML
    private Button BT_HLL;
    @FXML
    private Button BT_Pain;
    @FXML
    private Button BT_FkP;
    @FXML
    private Button BT_WFTN;
    @FXML
    private Button BT_1T;
    @FXML
    private Button BT_FK;
    @FXML
    private Button BT_Phnx;
    @FXML
    private Button BT_Sddly;

    private viewExampleController mainController;
   
    private viewExampleController_1 mainController_1;
    
    private ArrayList<File> songs;
    
    private MediaPlayer mediaPlayer;
    
    private ArrayList<String> songsPaths = new ArrayList<>();
    
    private int currentSongIndex = 0;
    
    private Random random = new Random();
    
    private boolean randomMode = false;
    
    private boolean loopMode = false;

    private ImageView songImageView;
    
    private Map<String, String> albumImages = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadSongs();
        
    BT_LLA.setOnAction(event -> playSong(songsPaths.get(0), mainController, mainController_1));
    
    BT_Gold.setOnAction(event -> playSong(songsPaths.get(1), mainController, mainController_1));
    
    BT_PMW.setOnAction(event -> playSong(songsPaths.get(2), mainController, mainController_1));
    
    BT_LVL.setOnAction(event -> playSong(songsPaths.get(3), mainController, mainController_1));
    
    BT_HLL.setOnAction(event -> playSong(songsPaths.get(4), mainController, mainController_1));
    
    BT_Pain.setOnAction(event -> playSong(songsPaths.get(5), mainController, mainController_1));
    
    BT_FkP.setOnAction(event -> playSong(songsPaths.get(6), mainController, mainController_1));
    
    BT_WFTN.setOnAction(event -> playSong(songsPaths.get(7), mainController, mainController_1));
    
    BT_1T.setOnAction(event -> playSong(songsPaths.get(8), mainController, mainController_1));
    
    BT_FK.setOnAction(event -> playSong(songsPaths.get(9), mainController, mainController_1));
    
    BT_Phnx.setOnAction(event -> playSong(songsPaths.get(10), mainController, mainController_1));
    
    BT_Sddly.setOnAction(event -> playSong(songsPaths.get(11), mainController, mainController_1));
        
    
    }  
    
    private void loadSongs() {   
        
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/01 A$AP Rocky - Long Live A$AP.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/01 A$AP Rocky - Long Live A$AP.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/02 A$AP Rocky - Goldie.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/02 A$AP Rocky - Goldie.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/03 A$AP Rocky - PMW (All I Really Need).mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/03 A$AP Rocky - PMW (All I Really Need).mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/04 A$AP Rocky - LVL.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/04 A$AP Rocky - LVL.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/05 A$AP Rocky - Hell.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/05 A$AP Rocky - Hell.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/06 A$AP Rocky - Pain.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/06 A$AP Rocky - Pain.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/07 A$AP Rocky - F__kin' Problems.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/07 A$AP Rocky - F__kin' Problems.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/08 A$AP Rocky - Wild for the Night.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/08 A$AP Rocky - Wild for the Night.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/09 A$AP Rocky - 1Train.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/09 A$AP Rocky - 1Train.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/10 A$AP Rocky - Fashion Killa.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/10 A$AP Rocky - Fashion Killa.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/11 A$AP Rocky - Phoenix.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/11 A$AP Rocky - Phoenix.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/12 A$AP Rocky - Suddenly.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/12 A$AP Rocky - Suddenly.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/13 A$AP Rocky - Jodye.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/13 A$AP Rocky - Jodye.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/14 A$AP Rocky - Ghetto Symphony.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/14 A$AP Rocky - Ghetto Symphony.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/15 A$AP Rocky - Angels.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/15 A$AP Rocky - Angels.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/16 A$AP Rocky - I Come Apart.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/16 A$AP Rocky - I Come Apart.mp3","Mini_Images/Long live asap.png");
    
    songsPaths.add("A$AP Rocky – LONG.LIVE.A$AP/17 A$AP Rocky - Purple Swag REMIX.mp3");
    albumImages.put("A$AP Rocky – LONG.LIVE.A$AP/17 A$AP Rocky - Purple Swag REMIX.mp3","Mini_Images/Long live asap.png");
    
    }
    
    public void setMediaPlayerVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }
    
    
     private void initializeMediaPlayer() {

    if (mediaPlayer != null) {
        mediaPlayer.stop();
    }
    
    String firstSongPath = songsPaths.get(0);
    Media media = new Media(new File(firstSongPath).toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setOnEndOfMedia(() -> {
        playNextSong();
    });
}
     
    public void playOrPause() {
     if (mediaPlayer != null) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            System.out.println("Estado del reproductor: PAUSANDO");
            String pausedSong = songsPaths.get(currentSongIndex);
            System.out.println("Canción en pausa: " + pausedSong);
            mediaPlayer.pause();
            mainController.setPlayIcon(false);
            mainController_1.setPlayIcon(false);
        } else {
            System.out.println("Estado del reproductor: REANUDANDO");
            String resumedSong = songsPaths.get(currentSongIndex);
            System.out.println("Reanudando canción: " + resumedSong);
            mediaPlayer.play();
            mainController.setPlayIcon(true);
            mainController_1.setPlayIcon(true);
        }
    }
}
     
     
    private String getRandomSong() {
      int randomIndex;
    do {
        randomIndex = random.nextInt(songsPaths.size());
    } while (randomIndex == currentSongIndex);
    return songsPaths.get(randomIndex);
}


  public void playNextSong() {
    System.out.println("Boton de pasar cancion presionado");
    if (isRandomMode()) {
        String randomSongPath = getRandomSong();
        playSong(randomSongPath, mainController, mainController_1);
    } else {
        if (loopMode) {
            playSong(songsPaths.get(currentSongIndex), mainController, mainController_1);
            return;
        }

        currentSongIndex = (currentSongIndex + 1) % songsPaths.size();
        String nextSongPath = songsPaths.get(currentSongIndex);
        playSong(nextSongPath, mainController, mainController_1);
    }
}

    private boolean isRandomMode() {
    return randomMode;
}

    public String toggleRandomMode() {
    randomMode = !randomMode; 

    String message = randomMode ? "Modo aleatorio activado" : "Modo aleatorio desactivado";
    JOptionPane.showMessageDialog(null, message);

    System.out.println(message);

    if (randomMode) {
        int randomIndex;
        do {
            randomIndex = random.nextInt(songsPaths.size());
        } while (randomIndex == currentSongIndex); 
        return songsPaths.get(randomIndex);
    } else {

        return songsPaths.get(currentSongIndex);
    }
}


    private void playSong(String songPath, viewExampleController mainController, viewExampleController_1 mainController_1) {
    // Verificar qué controlador se debe usar para reproducir la canción
    if (mainController != null) {
        playSong(songPath, mainController);
    } else if (mainController_1 != null) {
        playSong(songPath, mainController_1);
    } else {
  
        System.out.println("Error: No se proporcionó ningún controlador válido.");
    }
}

// Método para reproducir la canción en el controlador 1
private void playSong(String songPath, viewExampleController mainController) {
    if (mainController.getMediaPlayer() != null) {
        mainController.getMediaPlayer().stop();
        mainController.getMediaPlayer().dispose();
        mainController.setMediaPlayer(null);
    }
    if (mediaPlayer != null) {
        mediaPlayer.stop();
        mediaPlayer.dispose();
        mediaPlayer = null;
    }
    Media media = new Media(new File(songPath).toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mainController.setMediaPlayer(mediaPlayer);
    mediaPlayer.play();
    mainController.setPlayIcon(true);
    mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
        Platform.runLater(() -> mainController.updateProgressBar(newTime, mediaPlayer.getTotalDuration()));
    });
    currentSongIndex = songsPaths.indexOf(songPath);

    String[] parts = songPath.split("/");
    String album = parts[0];
    String songName = parts[1].substring(3); 
    int songNumber = currentSongIndex + 1; 
    String albumName = parts[0]; 
    mainController.setAlbumLabel(albumName);
    mainController.setSongLabel(songName); 

    System.out.println("Reproduciendo canción #" + songNumber + ": " + songName + " del álbum: " + album);

    mediaPlayer.setOnEndOfMedia(() -> {
        playNextSong();
        mainController.setSongLabel(songName);
    });

    String albumImagePath = albumImages.get(songPath);
    if (albumImagePath != null && songImageView != null) {
        System.out.println("Ruta de la imagen del álbum: " + albumImagePath);
        Image albumImage = new Image(new File(albumImagePath).toURI().toString());
        songImageView.setImage(albumImage);
        System.out.println("Imagen del álbum cargada correctamente en el ImageView.");
    } else {
        System.out.println("No se encontró la ruta de la imagen del álbum o el ImageView no está inicializado.");
    }
}


private void playSong(String songPath, viewExampleController_1 mainController_1) {
    if (mainController_1.getMediaPlayer() != null) {
        mainController_1.getMediaPlayer().stop();
        mainController_1.getMediaPlayer().dispose();
        mainController_1.setMediaPlayer(null);
    }
    if (mediaPlayer != null) {
        mediaPlayer.stop();
        mediaPlayer.dispose();
        mediaPlayer = null;
    }
    Media media = new Media(new File(songPath).toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mainController_1.setMediaPlayer(mediaPlayer);
    mediaPlayer.play();
    mainController_1.setPlayIcon(true);
    mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
        Platform.runLater(() -> mainController_1.updateProgressBar(newTime, mediaPlayer.getTotalDuration()));
    });
    currentSongIndex = songsPaths.indexOf(songPath);

    String[] parts = songPath.split("/");
    String album = parts[0];
    String songName = parts[1].substring(3); 
    int songNumber = currentSongIndex + 1; 
    String albumName = parts[0]; 
    mainController_1.setAlbumLabel(albumName);
    mainController_1.setSongLabel(songName); 

    System.out.println("Reproduciendo canción #" + songNumber + ": " + songName + " del álbum: " + album);

    mediaPlayer.setOnEndOfMedia(() -> {
        playNextSong();
        mainController_1.setSongLabel(songName);
    });

    String albumImagePath = albumImages.get(songPath);
    if (albumImagePath != null && songImageView != null) {
        System.out.println("Ruta de la imagen del álbum: " + albumImagePath);
        Image albumImage = new Image(new File(albumImagePath).toURI().toString());
        songImageView.setImage(albumImage);
        System.out.println("Imagen del álbum cargada correctamente en el ImageView.");
    } else {
        System.out.println("No se encontró la ruta de la imagen del álbum o el ImageView no está inicializado.");
    }
}


        
    

    public void playPreviousSong() {
    if (isRandomMode()) {
        String randomSongPath = getRandomSong();
        playSong(randomSongPath, mainController, mainController_1);
    } else {
        if (loopMode && currentSongIndex == 0) {
            playSong(songsPaths.get(currentSongIndex), mainController, mainController_1);
            return;
        }

        if (loopMode) {
            currentSongIndex = (currentSongIndex - 1 + songsPaths.size()) % songsPaths.size();
        } else if (currentSongIndex > 0) {
            currentSongIndex--;
        }

        String previousSongPath = songsPaths.get(currentSongIndex);
        playSong(previousSongPath, mainController, mainController_1);
    }
}
    
    
    public void toggleLoopMode() {
    loopMode = !loopMode;
        System.out.println("modo bucle activado");
    String message = loopMode ? "Modo de bucle activado" : "Modo de bucle desactivado";
    JOptionPane.showMessageDialog(null, message);
}
    
    public void setMainController(viewExampleController mainController) {
        this.mainController = mainController;
        this.songImageView = mainController.getSongImageView();
    
    }
    
    public void setMainController_1(viewExampleController_1 mainController_1) {
        this.mainController_1 = mainController_1;
        this.songImageView = mainController_1.getSongImageView();
    
    }
    
}
