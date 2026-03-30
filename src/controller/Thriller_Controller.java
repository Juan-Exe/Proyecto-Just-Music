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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Platform;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DAMIANA
 */
public class Thriller_Controller implements Initializable, AlbumController {

    @FXML
    private javafx.scene.layout.VBox songListVBox;
    @FXML
    private ScrollPane songListScroll;

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
        buildSongList();
        songListScroll.getStylesheets().add(getClass().getResource("/view/scrollbar.css").toExternalForm());
    }

    private void buildSongList() {
        songListVBox.getChildren().clear();
        for (int i = 0; i < songsPaths.size(); i++) {
            final int index = i;
            String path = songsPaths.get(i);
            String fileName = new File(path).getName();
            String songName = fileName.replaceFirst("^\\d+\\s+", "").replaceFirst("\\.mp3$", "");
            if (songName.contains(" - ")) {
                songName = songName.substring(songName.indexOf(" - ") + 3);
            }
            HBox row = new HBox();
            row.setPrefWidth(950);
            row.setPrefHeight(42);
            row.setAlignment(Pos.CENTER_LEFT);
            row.setStyle("-fx-background-color: " + (i % 2 == 0 ? "#F0F0F0" : "#FFFFFF") + "; -fx-cursor: hand;");
            row.setPadding(new Insets(0, 10, 0, 10));
            Label numLabel = new Label(String.valueOf(i + 1));
            numLabel.setPrefWidth(40);
            numLabel.setStyle("-fx-text-fill: #888888; -fx-font-size: 13;");
            numLabel.setFont(new javafx.scene.text.Font("Microsoft Sans Serif", 13));
            Label nameLabel = new Label(songName);
            nameLabel.setStyle("-fx-text-fill: #333333; -fx-font-size: 13;");
            nameLabel.setFont(new javafx.scene.text.Font("Microsoft Sans Serif", 13));
            row.getChildren().addAll(numLabel, nameLabel);
            row.setOnMouseClicked(event -> playSong(songsPaths.get(index), mainController, mainController_1));
            row.setOnMouseEntered(e -> row.setStyle("-fx-background-color: #05B2A8; -fx-cursor: hand;"));
            row.setOnMouseExited(e -> row.setStyle("-fx-background-color: " + (index % 2 == 0 ? "#F0F0F0" : "#FFFFFF") + "; -fx-cursor: hand;"));
            songListVBox.getChildren().add(row);
        }
    }

    private void loadSongs() {

        songsPaths.add("Michael Jackson – Thriller/01 Michael Jackson - Wanna Be Startin' Somethin'.mp3");
        albumImages.put("Michael Jackson – Thriller/01 Michael Jackson - Wanna Be Startin' Somethin'.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/02 Michael Jackson - Baby Be Mine.mp3");
        albumImages.put("Michael Jackson – Thriller/02 Michael Jackson - Baby Be Mine.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/03 Michael Jackson - The Girl Is Mine.mp3");
        albumImages.put("Michael Jackson – Thriller/03 Michael Jackson - The Girl Is Mine.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/04 Michael Jackson - Thriller.mp3");
        albumImages.put("Michael Jackson – Thriller/04 Michael Jackson - Thriller.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/05 Michael Jackson - Beat It (Single Version).mp3");
        albumImages.put("Michael Jackson – Thriller/05 Michael Jackson - Beat It (Single Version).mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/06 Michael Jackson - Billie Jean.mp3");
        albumImages.put("Michael Jackson – Thriller/06 Michael Jackson - Billie Jean.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/07 Michael Jackson - Human Nature.mp3");
        albumImages.put("Michael Jackson – Thriller/07 Michael Jackson - Human Nature.mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/08 Michael Jackson - P.Y.T. (Pretty Young Thing).mp3");
        albumImages.put("Michael Jackson – Thriller/08 Michael Jackson - P.Y.T. (Pretty Young Thing).mp3", "Mini_Images/Thriller mini.png");

        songsPaths.add("Michael Jackson – Thriller/09 Michael Jackson - The Lady in My Life.mp3");
        albumImages.put("Michael Jackson – Thriller/09 Michael Jackson - The Lady in My Life.mp3", "Mini_Images/Thriller mini.png");

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

    if (mainController != null) {
        playSong(songPath, mainController);
    } else if (mainController_1 != null) {
        playSong(songPath, mainController_1);
    } else {
  
        System.out.println("Error: No se proporcionó ningún controlador válido.");
    }
}


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
    

