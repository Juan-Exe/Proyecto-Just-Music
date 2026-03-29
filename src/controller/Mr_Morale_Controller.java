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
public class Mr_Morale_Controller implements Initializable, AlbumController {

    @FXML
    private Button BT_UIGf;
    @FXML
    private Button BT_N95;
    @FXML
    private Button BT_Wrld;
    @FXML
    private Button BT_DH;
    @FXML
    private Button BT_FT;
    @FXML
    private Button BT_Rch;
    @FXML
    private Button BT_RchSprt;
    @FXML
    private Button BT_WCT;
    @FXML
    private Button BT_Phrst;

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
    
    @FXML
    private Button BT_CMout;
    @FXML
    private Button BT_Crown;
    @FXML
    private Button BT_SHill;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadSongs();
        
    BT_UIGf.setOnAction(event -> playSong(songsPaths.get(0), mainController, mainController_1));
    
    BT_N95.setOnAction(event -> playSong(songsPaths.get(1), mainController, mainController_1));
    
    BT_Wrld.setOnAction(event -> playSong(songsPaths.get(2), mainController, mainController_1));
    
    BT_DH.setOnAction(event -> playSong(songsPaths.get(3), mainController, mainController_1));
    
    BT_FT.setOnAction(event -> playSong(songsPaths.get(4), mainController, mainController_1));
    
    BT_Rch.setOnAction(event -> playSong(songsPaths.get(5), mainController, mainController_1));
    
    BT_RchSprt.setOnAction(event -> playSong(songsPaths.get(6), mainController, mainController_1));
    
    BT_WCT.setOnAction(event -> playSong(songsPaths.get(7), mainController, mainController_1));
    
    BT_Phrst.setOnAction(event -> playSong(songsPaths.get(8), mainController, mainController_1));
    
    BT_CMout.setOnAction(event -> playSong(songsPaths.get(9), mainController, mainController_1));
    
    BT_Crown.setOnAction(event -> playSong(songsPaths.get(10), mainController, mainController_1));
    
    BT_SHill.setOnAction(event -> playSong(songsPaths.get(11), mainController, mainController_1));
        
 
        
    } 
    
    private void loadSongs() {
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/01 Kendrick Lamar - United In Grief.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/01 Kendrick Lamar - United In Grief.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/02 Kendrick Lamar - N95.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/02 Kendrick Lamar - N95.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/03 Kendrick Lamar - Worldwide Steppers.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/03 Kendrick Lamar - Worldwide Steppers.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/04 Kendrick Lamar - Die Hard.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/04 Kendrick Lamar - Die Hard.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/05 Kendrick Lamar - Father Time.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/05 Kendrick Lamar - Father Time.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/06 Kendrick Lamar - Rich (Interlude).mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/06 Kendrick Lamar - Rich (Interlude).mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/07 Kendrick Lamar - Rich Spirit.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/07 Kendrick Lamar - Rich Spirit.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/08 Kendrick Lamar - We Cry Together.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/08 Kendrick Lamar - We Cry Together.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/09 Kendrick Lamar - Purple Hearts.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/09 Kendrick Lamar - Purple Hearts.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/10 Kendrick Lamar - Count Me Out.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/10 Kendrick Lamar - Count Me Out.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/11 Kendrick Lamar - Crown.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/11 Kendrick Lamar - Crown.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/12 Kendrick Lamar - Silent Hill.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/12 Kendrick Lamar - Silent Hill.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/13 Kendrick Lamar - Savior (Interlude).mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/13 Kendrick Lamar - Savior (Interlude).mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/14 Kendrick Lamar - Savior.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/14 Kendrick Lamar - Savior.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/15 Kendrick Lamar - Auntie Diaries.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/15 Kendrick Lamar - Auntie Diaries.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/16 Kendrick Lamar - Mr. Morale.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/16 Kendrick Lamar - Mr. Morale.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/17 Kendrick Lamar - Mother I Sober.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/17 Kendrick Lamar - Mother I Sober.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/18 Kendrick Lamar - Mirror.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/18 Kendrick Lamar - Mirror.mp3","Mini_Images/Mr Morale Mini.png");
        
    songsPaths.add("Kendrick Lamar – Mr. Morale & The Big Steppers/19 Kendrick Lamar - The Heart Part 5.mp3");
    albumImages.put("Kendrick Lamar – Mr. Morale & The Big Steppers/19 Kendrick Lamar - The Heart Part 5.mp3","Mini_Images/Mr Morale Mini.png");
        
       
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
   