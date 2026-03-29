package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class viewExampleController implements Initializable {

    @FXML
    private Button Bt_escuchar;
    @FXML
    private Button Bt_albums;
    @FXML
    private Button Bt_art;
    @FXML
    private Button BT_Pls;
    @FXML
    
    private ImageView SongIVW;
    @FXML
    private Label SongLabel;
    @FXML
    private Label AlbumLabel;
    

    
//DECLARAR VOLUMESLIDER.........................................................
    
    private void handleVolumeChange() {
        double volume = volumeSlider.getValue() / 100.0;
        if (activeAlbumController != null) {
            activeAlbumController.setMediaPlayerVolume(volume);
        }
    }
    
//DECLARACIONES.................................................................
    
    @FXML
    public BorderPane bp;

    @FXML
     ScrollPane ap;
    
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
    private ImageView playIcon;

    @FXML
    private Label toastLabel;

    @FXML
    private Slider progressSlider;

    @FXML
    private Label currentTimeLabel;

    @FXML
    private Label totalTimeLabel;

    private boolean progressSliderDragging = false;
    
    public Media media;
    
    public static MediaPlayer mediaPlayer;
    
    
    
    @FXML
    private Button Sing_in_Button;
    
//DECLARACIONES DE PAGINAS......................................................
    
    private Testing_Controller test;
    
    private L_L_A_Controller lon;
    
    private Days_Controller dayz;
            
    private Lateralus_Controller Lat;  
    
    private Deftones_Koi_No_Yokan_Controller KNY;
    
    private Deftones_White_Pony_Controller deftonesController;
    
    private Thriller_Controller thrillerController;
    
    private The_Getaway_Controller TGA;
            
    private Californication_Controller Cali;
    
    private WDTY_Controller_1 WDTY_1;
    
    private WDTY_Controller_2 WDTY_2;
    
    private Lisa_Page Lis;
    
    private ASAP_Page_Controller Sap;
    
    private Deftones_Page_Controller Deft;
    
    private Damn_Controller damn;
    
    private Trench_Controller trench;
    
    private Blurryface_Controller Blurry;
    
    private Mr_Morale_Controller mr;
    
    private Kendrick_Lamar_Page_Controller Kend;
    
    private Tool_Page_Controller tool;
    
    private RHCP_Page_Controller red;
    
    private TOP_Page_Controller top;
    
    private Down_page DP;
    
    private viewExampleController mainController;

    private AlbumController activeAlbumController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//INICIALIZAR VOLUMESLIDER......................................................

          volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            double volume = newValue.doubleValue() / 100.0;
            if (activeAlbumController != null) {
                activeAlbumController.setMediaPlayerVolume(volume);
            }
        }
    });

        Platform.runLater(() -> {
            ap.setVvalue(0);
            setActiveNavButton(Bt_escuchar);
            progressSlider.setDisable(true);
        });

    }

//PROGRESS SLIDER...............................................................

    @FXML
    private void onProgressSliderPressed(javafx.scene.input.MouseEvent event) {
        progressSliderDragging = true;
    }

    @FXML
    private void onProgressSliderReleased(javafx.scene.input.MouseEvent event) {
        if (mediaPlayer != null) {
            double total = mediaPlayer.getTotalDuration().toSeconds();
            mediaPlayer.seek(Duration.seconds(progressSlider.getValue() / 100.0 * total));
        }
        progressSliderDragging = false;
    }

    public void setPlayIcon(boolean playing) {
        if (playing) {
            playIcon.setImage(new Image(getClass().getResourceAsStream("/view/Pausa.png")));
        } else {
            playIcon.setImage(new Image(getClass().getResourceAsStream("/view/Reproducir.png")));
        }
    }

    public void updateProgressBar(Duration current, Duration total) {
        if (!progressSliderDragging && total != null && total.toSeconds() > 0) {
            progressSlider.setDisable(false);
            double progress = current.toSeconds() / total.toSeconds() * 100.0;
            progressSlider.setValue(progress);
            currentTimeLabel.setText(formatTime(current));
            totalTimeLabel.setText(formatTime(total));
        }
    }

    private String formatTime(Duration d) {
        int totalSecs = (int) d.toSeconds();
        int min = totalSecs / 60;
        int sec = totalSecs % 60;
        return String.format("%d:%02d", min, sec);
    }

//NAVEGACION ACTIVA.............................................................

    private static final String STYLE_ACTIVE   = "-fx-background-color: #FFFFFF; -fx-border-color: #05B2A8; -fx-border-radius: 6; -fx-border-width: 2;";
    private static final String STYLE_INACTIVE = "-fx-background-color: transparent;";

    private void setActiveNavButton(Button active) {
        Bt_escuchar.setStyle(STYLE_INACTIVE);
        Bt_albums.setStyle(STYLE_INACTIVE);
        Bt_art.setStyle(STYLE_INACTIVE);
        BT_Pls.setStyle(STYLE_INACTIVE);
        active.setStyle(STYLE_ACTIVE);
    }

//TOAST NOTIFICATION...........................................................

    public void showToast(String message) {
        toastLabel.setText(message);
        toastLabel.setOpacity(0.0);
        toastLabel.setTranslateY(30.0);
        toastLabel.setVisible(true);

        // Entrada: slide up + fade in
        TranslateTransition slideIn = new TranslateTransition(Duration.millis(300), toastLabel);
        slideIn.setFromY(30.0);
        slideIn.setToY(0.0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), toastLabel);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition enterAnim = new ParallelTransition(slideIn, fadeIn);

        // Pausa visible
        PauseTransition pause = new PauseTransition(Duration.seconds(2.0));

        // Salida: fade out
        FadeTransition fadeOut = new FadeTransition(Duration.millis(400), toastLabel);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> toastLabel.setVisible(false));

        new SequentialTransition(enterAnim, pause, fadeOut).play();
    }

//CONFIGURACION DE CAMBIO DE PAGINA.............................................    
    
    void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/" + page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(viewExampleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }
    
//ACCIONES...................................................................... 
   
    public ImageView getSongImageView() {
        return SongIVW;
    }

    public static void setMediaPlayer(MediaPlayer player) {
        mediaPlayer = player;
    }

    @FXML
    private void Escuchar_Page(MouseEvent event) {
        System.out.println("Se ha accedido a la página: Inicial");
        bp.setCenter(ap);
        Platform.runLater(() -> ap.setVvalue(0));
        setActiveNavButton(Bt_escuchar);
    }

    @FXML
private void Deftones_White_Pony_Page(MouseEvent event) {
   try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Deftones_White_Pony_Page.fxml"));
        Parent root = loader.load();
        deftonesController = loader.getController();
        if (deftonesController != null) {
            deftonesController.setMainController(this);
            activeAlbumController = deftonesController; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Deftones_White_Pony_Page"); // Agregar esta línea
        } else {
            System.out.println("No se pudo obtener el controlador de Deftones White Pony.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

   void White_Pony_Page(MouseEvent event) {
   try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Deftones_White_Pony_Page.fxml"));
        Parent root = loader.load();
        deftonesController = loader.getController();
        if (deftonesController != null) {
            deftonesController.setMainController(this);
            activeAlbumController = deftonesController; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Deftones_White_Pony_Page"); // Agregar esta línea
        } else {
            System.out.println("No se pudo obtener el controlador de Deftones White Pony.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
   void Koi_No_Yokan(MouseEvent event) {
   try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Deftones_Koi_No_Yokan_Page_.fxml"));
        Parent root = loader.load();
        KNY = loader.getController();
        if (KNY != null) {
            KNY.setMainController(this);
            activeAlbumController = KNY; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Deftones_White_Pony_K_N_Y");
        } else {
            System.out.println("No se pudo obtener el controlador de Deftones K N Y.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    @FXML
    private void Thriller_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Thriller_Page.fxml"));
        Parent root = loader.load();
        thrillerController = loader.getController();
        if (thrillerController != null) {
            thrillerController.setMainController(this);
            activeAlbumController = thrillerController; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Thriller_Page"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Thriller.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @FXML
    private void WDTY_Page(MouseEvent event) {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WDTY_Page.fxml"));
        Parent root = loader.load();
        WDTY_1 = loader.getController();
        if (WDTY_1 != null) {
            WDTY_1.setMainController(this);
            activeAlbumController = WDTY_1; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: WDTY_Page"); 
        } else {
            System.out.println("No se pudo obtener el controlador de WDTY.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    void WDTY_Page_2(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WDTY_Page_2.fxml"));
        Parent root = loader.load();
        WDTY_2 = loader.getController();
        if (WDTY_2 != null) {
            WDTY_2.setMainController(this);
            activeAlbumController = WDTY_2; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: WDTY_Page_2"); 
        } else {
            System.out.println("No se pudo obtener el controlador de WDTY.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    void WDTY_Page_1(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/WDTY_Page.fxml"));
        Parent root = loader.load();
        WDTY_1 = loader.getController();
        if (WDTY_1 != null) {
            WDTY_1.setMainController(this);
            activeAlbumController = WDTY_1; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: WDTY_Page_1"); 
        } else {
            System.out.println("No se pudo obtener el controlador de WDTY.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    void Lisa_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Lisa_Page.fxml"));
        Parent root = loader.load();
        Lis = loader.getController();
        if (Lis != null) {
            Lis.setMainController(this);
            activeAlbumController = Lis; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Lisa"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Lisa.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    
    
    @FXML
    private void A$AP_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Asap.fxml"));
        Parent root = loader.load();
        Sap = loader.getController();
        if (Sap != null) {
            Sap.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    @FXML
    void Testing(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Asap_Rocky_Testing.fxml"));
        Parent root = loader.load();
        test = loader.getController();
        if (test != null) {
            test.setMainController(this);
            activeAlbumController = test; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    void Long(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Asap_Rocky_L_L_A.fxml"));
        Parent root = loader.load();
        lon = loader.getController();
        if (lon != null) {
            lon.setMainController(this);
            activeAlbumController = lon; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    void ASAP_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Asap.fxml"));
        Parent root = loader.load();
        Sap = loader.getController();
        if (Sap != null) {
            Sap.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    

    @FXML
    private void TOOL_page(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Tool.fxml"));
        Parent root = loader.load();
        tool = loader.getController();
        if (tool != null) {
            tool.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    
    @FXML
    void Lateralus(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Tool_Lateralus.fxml"));
        Parent root = loader.load();
        Lat = loader.getController();
        if (Lat != null) {
            Lat.setMainController(this);
            activeAlbumController = Lat; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    
    void Days(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Tool_10_000_Days.fxml"));
        Parent root = loader.load();
        dayz = loader.getController();
        if (dayz != null) {
            dayz.setMainController(this);
            activeAlbumController = dayz; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    
    void TooL_page(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Tool.fxml"));
        Parent root = loader.load();
        tool = loader.getController();
        if (tool != null) {
            tool.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }

    @FXML
    private void RHCP_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_RHCP.fxml"));
        Parent root = loader.load();
        red = loader.getController();
        if (red != null) {
            red.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    void rhcp_Page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_RHCP.fxml"));
        Parent root = loader.load();
        red = loader.getController();
        if (red != null) {
            red.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    
    void The_Getaway(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RHCP_The_Getaway.fxml"));
        Parent root = loader.load();
        TGA = loader.getController();
        if (TGA != null) {
            TGA.setMainController(this);
            activeAlbumController = TGA; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    
    void California(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RHCP_Californication.fxml"));
        Parent root = loader.load();
        Cali = loader.getController();
        if (Cali != null) {
            Cali.setMainController(this);
            activeAlbumController = Cali; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }

    @FXML
    private void TOP_page(MouseEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_TOP.fxml"));
        Parent root = loader.load();
        top = loader.getController();
        if (top != null) {
            top.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    
    @FXML
    void Trench(MouseEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TOP_Trench.fxml"));
        Parent root = loader.load();
        trench = loader.getController();
        if (trench != null) {
            trench.setMainController(this);
            activeAlbumController = trench; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    
    void Blurryface(MouseEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TOP_Blurryface.fxml"));
        Parent root = loader.load();
        Blurry = loader.getController();
        if (Blurry != null) {
            Blurry.setMainController(this);
            activeAlbumController = Blurry; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }
    
    void ToP_page(MouseEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_TOP.fxml"));
        Parent root = loader.load();
        top = loader.getController();
        if (top != null) {
            top.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }

    @FXML
    private void Kedrick_page(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Kendrick_Lamar.fxml"));
        Parent root = loader.load();
        Kend = loader.getController();
        if (Kend != null) {
            Kend.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    void Ken_page(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Kendrick_Lamar.fxml"));
        Parent root = loader.load();
        Kend = loader.getController();
        if (Kend != null) {
            Kend.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    void Damn(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Kendrick_Damn.fxml"));
        Parent root = loader.load();
        damn = loader.getController();
        if (damn != null) {
            damn.setMainController(this);
            activeAlbumController = damn; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    void Mr_Morale(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Kendrick_Mr_Morale.fxml"));
        Parent root = loader.load();
        mr = loader.getController();
        if (mr != null) {
            mr.setMainController(this);
            activeAlbumController = mr; 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
    @FXML
    private void Deftones_page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Deftones.fxml"));
        Parent root = loader.load();
        Deft = loader.getController();
        if (Deft != null) {
            Deft.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }

    void Deft_page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Page_Deftones.fxml"));
        Parent root = loader.load();
        Deft = loader.getController();
        if (Deft != null) {
            Deft.setMainController(this); 
            bp.setCenter(root);
            System.out.println("Se ha accedido a la página: Asap"); 
        } else {
            System.out.println("No se pudo obtener el controlador de Asap.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
        
        
    }
    
    @FXML
    private void Down_page(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Down_page.fxml"));
        Parent root = loader.load();
        DP = loader.getController();
        if (DP != null) {
            DP.setMainController(this); 
            bp.setCenter(root);
        } else {
            System.out.println("No se pudo obtener el controlador de WDTY.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
    

    
//CONTROLREPRODUCTOR............................................................

    @FXML
    private void shuffleMedia(ActionEvent event) {
        if (activeAlbumController != null) {
            activeAlbumController.toggleRandomMode();
        }
    }

    @FXML
    private void resetMedia(ActionEvent event) {
        
         if (deftonesController != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
         
    }
    
         if (thrillerController != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
   
    }   
         
         if (WDTY_1 != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
         }
    
        
        if (WDTY_2 != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        
        if (Lis != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (KNY != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        
        if (damn != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        
        if (mr != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        
        if (trench != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        
        if (Blurry != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (TGA != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (Cali != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (Lat != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (dayz != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (test != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
        if (lon != null) {
    showToast("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
  
    }
  
         
}
    
    @FXML
    private void play_pauseMedia(ActionEvent event) {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                playIcon.setImage(new Image(getClass().getResourceAsStream("/view/Reproducir.png")));
            } else {
                mediaPlayer.play();
                playIcon.setImage(new Image(getClass().getResourceAsStream("/view/Pausa.png")));
            }
        }
}

    @FXML
    private void NextMedia(ActionEvent event) {
        
         if (deftonesController != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    
    }
    
         if (thrillerController != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    
    
    }
         
         if (WDTY_1 != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (WDTY_2 != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (Lis != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (KNY != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (damn != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (mr != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (trench != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (Blurry != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (TGA != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (Cali != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (Lat != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (dayz != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         
         if (test != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
         if (lon != null) {
    showToast("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    

    }
}

    @FXML
    private void bucleMedia(ActionEvent event) {
        if (activeAlbumController != null) {
            activeAlbumController.toggleLoopMode();
        }
    }

    @FXML
    private void Iniciar_Sesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Elegir_Tipo_Usuario.fxml"));
             Parent root = loader.load();
             Elegir_Tipo_Usuario_Controller controller = loader.getController();
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
             Stage currentStage = (Stage) Sing_in_Button.getScene().getWindow();
             currentStage.close();
             if (getMediaPlayer() != null) {
                 getMediaPlayer().stop();
             }
    }
    
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @FXML
    private void Page_Ab(ActionEvent event) {
        showToast("Esta característica solo está disponible para usuarios registrados, por favor inicie sesión.");
    }



    @FXML
    private void Page_Art(ActionEvent event) {
        showToast("Solo los usuarios registrados pueden ver todos los artistas, por favor inicie sesión.");
    }



    @FXML
    private void Page_plast(ActionEvent event) {
        showToast("Solo los usuarios registrados pueden ver todas las playlist, por favor inicie sesión.");
    }
    
public void setMainController(viewExampleController mainController) {
    this.mainController = mainController;
}

    public void setSongLabel(String songName) {
        SongLabel.setText(songName);
    }
    
    public void setAlbumLabel(String albumName) {
        AlbumLabel.setText(albumName);
    }
    
}
          
        

