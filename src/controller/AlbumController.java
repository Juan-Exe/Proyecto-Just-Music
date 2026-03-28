package controller;

public interface AlbumController {
    void playOrPause();
    void playNextSong();
    void playPreviousSong();
    void setMediaPlayerVolume(double volume);
    String toggleRandomMode();
    void toggleLoopMode();
}
