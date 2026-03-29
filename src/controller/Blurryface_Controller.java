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
public class Blurryface_Controller implements Initializable, AlbumController {

    @FXML
    private Button BT_Heavy;
    @FXML
    private Button BT_SO;
    @FXML
    private Button BT_Rde;
    @FXML
    private Button BT_FrLcl;
    @FXML
    private Button BT_TNMH;
    @FXML
    private Button BT_LBoy;
    @FXML
    private Button BT_TJdg;
    @FXML
    private Button BT_Dbut;
    @FXML
    private Button BT_Plrz;
    @FXML
    private Button BT_WDBTV;
    @FXML
    private Button BT_MM;
    @FXML
    private Button BT_Htown;
    
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
        
    BT_Heavy.setOnAction(event -> playSong(songsPaths.get(0), mainController, mainController_1));
    
    BT_SO.setOnAction(event -> playSong(songsPaths.get(1), mainController, mainController_1));
    
    BT_Rde.setOnAction(event -> playSong(songsPaths.get(2), mainController, mainController_1));
    
    BT_FrLcl.setOnAction(event -> playSong(songsPaths.get(3), mainController, mainController_1));
    
    BT_TNMH.setOnAction(event -> playSong(songsPaths.get(4), mainController, mainController_1));
    
    BT_LBoy.setOnAction(event -> playSong(songsPaths.get(5), mainController, mainController_1));
    
    BT_TJdg.setOnAction(event -> playSong(songsPaths.get(6), mainController, mainController_1));
    
    BT_Dbut.setOnAction(event -> playSong(songsPaths.get(7), mainController, mainController_1));
    
    BT_Plrz.setOnAction(event -> playSong(songsPaths.get(8), mainController, mainController_1));
    
    BT_WDBTV.setOnAction(event -> playSong(songsPaths.get(9), mainController, mainController_1));
    
    BT_MM.setOnAction(event -> playSong(songsPaths.get(10), mainController, mainController_1));
    
    BT_Htown.setOnAction(event -> playSong(songsPaths.get(11), mainController, mainController_1));
        
    
    }
    
    private void loadSongs() {
        
    songsPaths.add("Twenty One Pilots – Blurryface/01 Twenty One Pilots - Heavydirtysoul.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/01 Twenty One Pilots - Heavydirtysoul.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/02 Twenty One Pilots - Stressed Out.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/02 Twenty One Pilots - Stressed Out.mp3","Mini_Images/Blurryface Mini.png");
    
    songsPaths.add("Twenty One Pilots – Blurryface/03 Twenty One Pilots - Ride.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/03 Twenty One Pilots - Ride.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/04 Twenty One Pilots - Fairly Local.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/04 Twenty One Pilots - Fairly Local.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/05 Twenty One Pilots - Tear in My Heart.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/05 Twenty One Pilots - Tear in My Heart.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/06 Twenty One Pilots - Lane Boy.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/06 Twenty One Pilots - Lane Boy.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/07 Twenty One Pilots - The Judge.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/07 Twenty One Pilots - The Judge.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/08 Twenty One Pilots - Doubt.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/08 Twenty One Pilots - Doubt.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/09 Twenty One Pilots - Polarize.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/09 Twenty One Pilots - Polarize.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/10 Twenty One Pilots - We Don t Believe What s on TV.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/10 Twenty One Pilots - We Don t Believe What s on TV.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/11 Twenty One Pilots - Message Man.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/11 Twenty One Pilots - Message Man.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/12 Twenty One Pilots - Hometown.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/12 Twenty One Pilots - Hometown.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/13 Twenty One Pilots - Not Today.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/13 Twenty One Pilots - Not Today.mp3","Mini_Images/Blurryface Mini.png");
 
    songsPaths.add("Twenty One Pilots – Blurryface/14 Twenty One Pilots - Goner.mp3");
    albumImages.put("Twenty One Pilots – Blurryface/14 Twenty One Pilots - Goner.mp3","Mini_Images/Blurryface Mini.png");
 
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
        } else {
            System.out.println("Estado del reproductor: REANUDANDO");
            String resumedSong = songsPaths.get(currentSongIndex);
            System.out.println("Reanudando canción: " + resumedSong);
            mediaPlayer.play();
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
