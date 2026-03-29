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
public class Trench_Controller implements Initializable, AlbumController {


    
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
    private Button BT_Jump;
    @FXML
    private Button BT_Lev;
    @FXML
    private Button BT_Morph;
    @FXML
    private Button BT_MBlood;
    @FXML
    private Button BT_Chl;
    @FXML
    private Button BT_Smith;
    @FXML
    private Button BT_Ngvs;
    @FXML
    private Button BT_Thyp;
    @FXML
    private Button BT_NATN;
    @FXML
    private Button BT_CML;
    @FXML
    private Button BT_Band;
    @FXML
    private Button BT_PCHt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadSongs();
        
    BT_Jump.setOnAction(event -> playSong(songsPaths.get(0), mainController, mainController_1));
    
    BT_Lev.setOnAction(event -> playSong(songsPaths.get(1), mainController, mainController_1));
    
    BT_Morph.setOnAction(event -> playSong(songsPaths.get(2), mainController, mainController_1));
    
    BT_MBlood.setOnAction(event -> playSong(songsPaths.get(3), mainController, mainController_1));
    
    BT_Chl.setOnAction(event -> playSong(songsPaths.get(4), mainController, mainController_1));
    
    BT_Smith.setOnAction(event -> playSong(songsPaths.get(5), mainController, mainController_1));
    
    BT_Ngvs.setOnAction(event -> playSong(songsPaths.get(6), mainController, mainController_1));
    
    BT_Thyp.setOnAction(event -> playSong(songsPaths.get(7), mainController, mainController_1));
    
    BT_NATN.setOnAction(event -> playSong(songsPaths.get(8), mainController, mainController_1));
    
    BT_CML.setOnAction(event -> playSong(songsPaths.get(9), mainController, mainController_1));
    
    BT_Band.setOnAction(event -> playSong(songsPaths.get(10), mainController, mainController_1));
    
    BT_PCHt.setOnAction(event -> playSong(songsPaths.get(11), mainController, mainController_1));
        
    
    } 
    
    private void loadSongs() {
        
    songsPaths.add("Twenty One Pilots – Trench/01 Twenty One Pilots - Jumpsuit.mp3");
    albumImages.put("Twenty One Pilots – Trench/01 Twenty One Pilots - Jumpsuit.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/02 Twenty One Pilots - Levitate.mp3");
    albumImages.put("Twenty One Pilots – Trench/02 Twenty One Pilots - Levitate.mp3","Mini_Images/Trench Mini.png");
    
    songsPaths.add("Twenty One Pilots – Trench/03 Twenty One Pilots - Morph.mp3");
    albumImages.put("Twenty One Pilots – Trench/03 Twenty One Pilots - Morph.mp3","Mini_Images/Trench Mini.png");
    
    songsPaths.add("Twenty One Pilots – Trench/04 Twenty One Pilots - My Blood.mp3");
    albumImages.put("Twenty One Pilots – Trench/04 Twenty One Pilots - My Blood.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/05 Twenty One Pilots - Chlorine.mp3");
    albumImages.put("Twenty One Pilots – Trench/05 Twenty One Pilots - Chlorine.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/06 Twenty One Pilots - Smithereens.mp3");
    albumImages.put("Twenty One Pilots – Trench/06 Twenty One Pilots - Smithereens.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/07 Twenty One Pilots - Neon Gravestones.mp3");
    albumImages.put("Twenty One Pilots – Trench/07 Twenty One Pilots - Neon Gravestones.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/08 Twenty One Pilots - The Hype.mp3");
    albumImages.put("Twenty One Pilots – Trench/08 Twenty One Pilots - The Hype.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/09 Twenty One Pilots - Nico and the Niners.mp3");
    albumImages.put("Twenty One Pilots – Trench/09 Twenty One Pilots - Nico and the Niners.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/10 Twenty One Pilots - Cut My Lip.mp3");
    albumImages.put("Twenty One Pilots – Trench/10 Twenty One Pilots - Cut My Lip.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/11 Twenty One Pilots - Bandito.mp3");
    albumImages.put("Twenty One Pilots – Trench/11 Twenty One Pilots - Bandito.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/12 Twenty One Pilots - Pet Cheetah.mp3");
    albumImages.put("Twenty One Pilots – Trench/12 Twenty One Pilots - Pet Cheetah.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/13 Twenty One Pilots - Legend.mp3");
    albumImages.put("Twenty One Pilots – Trench/13 Twenty One Pilots - Legend.mp3","Mini_Images/Trench Mini.png");
        
    songsPaths.add("Twenty One Pilots – Trench/14 Twenty One Pilots - Leave the City.mp3");
    albumImages.put("Twenty One Pilots – Trench/14 Twenty One Pilots - Leave the City.mp3","Mini_Images/Trench Mini.png");
       
    
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

