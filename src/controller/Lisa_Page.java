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
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Platform;
import javax.swing.JOptionPane;


public class Lisa_Page implements Initializable, AlbumController {

    @FXML
    private javafx.scene.layout.VBox songListVBox;
    @FXML
    private ScrollPane songListScroll;
    @FXML
    private Button Seguir_BT;

    private Interfaz_Artista interfazArtistaController;

    public void setInterfazArtistaController(Interfaz_Artista interfazArtistaController) {
        this.interfazArtistaController = interfazArtistaController;
    }

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
            row.setOnMouseClicked(event -> {
                playSong(songsPaths.get(index), mainController, mainController_1);
                incrementarReproducciones();
            });
            row.setOnMouseEntered(e -> row.setStyle("-fx-background-color: #05B2A8; -fx-cursor: hand;"));
            row.setOnMouseExited(e -> row.setStyle("-fx-background-color: " + (index % 2 == 0 ? "#F0F0F0" : "#FFFFFF") + "; -fx-cursor: hand;"));
            songListVBox.getChildren().add(row);
        }
    }

    private void loadSongs() {
        songsPaths.add("S_C_O_O_T_0_5/LISA - COVER.mp3");
        albumImages.put("S_C_O_O_T_0_5/LISA - COVER.mp3", "Mini_Images/Lisa Mini.png");
    }

    public void setMediaPlayerVolume(double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }

    public void playOrPause() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                if (mainController != null) mainController.setPlayIcon(false);
                if (mainController_1 != null) mainController_1.setPlayIcon(false);
            } else {
                mediaPlayer.play();
                if (mainController != null) mainController.setPlayIcon(true);
                if (mainController_1 != null) mainController_1.setPlayIcon(true);
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
        String songName = parts[1].substring(0, parts[1].lastIndexOf('.'));
        mainController.setAlbumLabel(album);
        mainController.setSongLabel(songName);
        mediaPlayer.setOnEndOfMedia(() -> {
            playNextSong();
            mainController.setSongLabel(songName);
        });
        String albumImagePath = albumImages.get(songPath);
        if (albumImagePath != null && songImageView != null) {
            Image albumImage = new Image(new File(albumImagePath).toURI().toString());
            songImageView.setImage(albumImage);
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
        String songName = parts[1].substring(0, parts[1].lastIndexOf('.'));
        mainController_1.setAlbumLabel(album);
        mainController_1.setSongLabel(songName);
        mediaPlayer.setOnEndOfMedia(() -> {
            playNextSong();
            mainController_1.setSongLabel(songName);
        });
        String albumImagePath = albumImages.get(songPath);
        if (albumImagePath != null && songImageView != null) {
            Image albumImage = new Image(new File(albumImagePath).toURI().toString());
            songImageView.setImage(albumImage);
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

    private void incrementarSeguidores() {
        Preferences prefs = Preferences.userNodeForPackage(Lisa_Page.class);
        int seguidoresActuales = prefs.getInt("seguidores", 0);
        prefs.putInt("seguidores", seguidoresActuales + 1);
    }

    private int obtenerSeguidores() {
        Preferences prefs = Preferences.userNodeForPackage(Lisa_Page.class);
        return prefs.getInt("seguidores", 0);
    }

    @FXML
    private void Seguir_Artista(ActionEvent event) {
        boolean usuarioRegistrado = mainController_1 != null;
        if (usuarioRegistrado) {
            Seguir_BT.setText("Siguiendo");
            JOptionPane.showMessageDialog(null, "Empezaste a seguir a este artista");
            incrementarSeguidores();
            if (interfazArtistaController != null) {
                interfazArtistaController.actualizarSeguidores(obtenerSeguidores());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Para seguir a este artista tienes que estar registrado");
        }
    }

    public void setMainController(viewExampleController mainController) {
        this.mainController = mainController;
        this.songImageView = mainController.getSongImageView();
    }

    public void setMainController_1(viewExampleController_1 mainController_1) {
        this.mainController_1 = mainController_1;
        this.songImageView = mainController_1.getSongImageView();
    }

    private void incrementarReproducciones() {
        Preferences prefs = Preferences.userNodeForPackage(Interfaz_Artista.class);
        int reproduccionesActuales = prefs.getInt("reproducciones", 0);
        prefs.putInt("reproducciones", reproduccionesActuales + 1);
    }
}
