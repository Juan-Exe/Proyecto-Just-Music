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
public class Testing_Controller implements Initializable, AlbumController {

    @FXML
    private Button BT_DR;
    @FXML
    private Button BT_AF;
    @FXML
    private Button BT_TT;
    @FXML
    private Button BT_FKKslp;
    @FXML
    private Button BT_PTL;
    @FXML
    private Button BT_CLDRP;
    @FXML
    private Button BT_BCK;
    @FXML
    private Button BT_GNB;
    @FXML
    private Button BT_BM;
    @FXML
    private Button BT_OG;
    @FXML
    private Button BT_Kdss;
    @FXML
    private Button BT_HD43;

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
        
    BT_DR.setOnAction(event -> playSong(songsPaths.get(0), mainController, mainController_1));
    
    BT_AF.setOnAction(event -> playSong(songsPaths.get(1), mainController, mainController_1));
    
    BT_TT.setOnAction(event -> playSong(songsPaths.get(2), mainController, mainController_1));
    
    BT_FKKslp.setOnAction(event -> playSong(songsPaths.get(3), mainController, mainController_1));
    
    BT_PTL.setOnAction(event -> playSong(songsPaths.get(4), mainController, mainController_1));
    
    BT_CLDRP.setOnAction(event -> playSong(songsPaths.get(5), mainController, mainController_1));
    
    BT_BCK.setOnAction(event -> playSong(songsPaths.get(6), mainController, mainController_1));
    
    BT_GNB.setOnAction(event -> playSong(songsPaths.get(7), mainController, mainController_1));
    
    BT_BM.setOnAction(event -> playSong(songsPaths.get(8), mainController, mainController_1));
    
    BT_OG.setOnAction(event -> playSong(songsPaths.get(9), mainController, mainController_1));
    
    BT_Kdss.setOnAction(event -> playSong(songsPaths.get(10), mainController, mainController_1));
    
    BT_HD43.setOnAction(event -> playSong(songsPaths.get(11), mainController, mainController_1));
        
    
    }
    
    private void loadSongs() {   
        
    
    songsPaths.add("A$AP Rocky – TESTING/01 A$AP Rocky - Distorted Records.mp3");
    albumImages.put("A$AP Rocky – TESTING/01 A$AP Rocky - Distorted Records.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/02 A$AP_Rocky_A$AP_Forever_REMIX_feat_Moby,_T_I_Kid_Cudi.mp3");
    albumImages.put("A$AP Rocky – TESTING/02 A$AP_Rocky_A$AP_Forever_REMIX_feat_Moby,_T_I_Kid_Cudi.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/03 A$AP Rocky - Tony Tone.mp3");
    albumImages.put("A$AP Rocky – TESTING/03 A$AP Rocky - Tony Tone.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/04 A$AP Rocky - Fukk Sleep.mp3");
    albumImages.put("A$AP Rocky – TESTING/04 A$AP Rocky - Fukk Sleep.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/05 A$AP Rocky - Praise The Lord (Da Shine).mp3");
    albumImages.put("A$AP Rocky – TESTING/05 A$AP Rocky - Praise The Lord (Da Shine).mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/06 A$AP Rocky - CALLDROPS.mp3");
    albumImages.put("A$AP Rocky – TESTING/06 A$AP Rocky - CALLDROPS.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/07 A$AP Rocky - Buck Shots.mp3");
    albumImages.put("A$AP Rocky – TESTING/07 A$AP Rocky - Buck Shots.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/08 A$AP Rocky - Gunz N Butter.mp3");
    albumImages.put("A$AP Rocky – TESTING/08 A$AP Rocky - Gunz N Butter.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/09 A$AP Rocky - Brotha Man.mp3");
    albumImages.put("A$AP Rocky – TESTING/09 A$AP Rocky - Brotha Man.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/10 A$AP Rocky - OG Beeper.mp3");
    albumImages.put("A$AP Rocky – TESTING/10 A$AP Rocky - OG Beeper.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/11 A$AP Rocky - Kids Turned Out Fine.mp3");
    albumImages.put("A$AP Rocky – TESTING/11 A$AP Rocky - Kids Turned Out Fine.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/12 A$AP Rocky - Hun43rd.mp3");
    albumImages.put("A$AP Rocky – TESTING/12 A$AP Rocky - Hun43rd.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/13 A$AP Rocky - Changes.mp3");
    albumImages.put("A$AP Rocky – TESTING/13 A$AP Rocky - Changes.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/14 A$AP Rocky - Black Tux, White Collar.mp3");
    albumImages.put("A$AP Rocky – TESTING/14 A$AP Rocky - Black Tux, White Collar.mp3","Mini_Images/Testing Mini.png");
    
    songsPaths.add("A$AP Rocky – TESTING/15 A$AP Rocky - Purity.mp3");
    albumImages.put("A$AP Rocky – TESTING/15 A$AP Rocky - Purity.mp3","Mini_Images/Testing Mini.png");
    
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
