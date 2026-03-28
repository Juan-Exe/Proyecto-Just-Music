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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class viewExampleController implements Initializable {

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
        
        if (deftonesController != null) {
            deftonesController.setMediaPlayerVolume(volume);
        }
        if (thrillerController != null) {
        thrillerController.setMediaPlayerVolume(volume);
        }
        
        if (WDTY_1 != null) {
        WDTY_1.setMediaPlayerVolume(volume);
        
        }
        
        if (WDTY_2 != null) {
        WDTY_2.setMediaPlayerVolume(volume);
        
        }
        
        if (Lis != null) {
        Lis.setMediaPlayerVolume(volume);
        
        }
        
        if (KNY != null) {
        KNY.setMediaPlayerVolume(volume);
       
        }
        
        if (damn != null) {
        damn.setMediaPlayerVolume(volume);
       
        }
        
        if (mr != null) {
              mr.setMediaPlayerVolume(volume);
       
        }
        
        if (trench != null) {
              trench.setMediaPlayerVolume(volume);
       
        }
        
        if (Blurry != null) {
              Blurry.setMediaPlayerVolume(volume);
       
        }
        
        if (TGA != null) {
              TGA.setMediaPlayerVolume(volume);
       
        }
        
        if (Cali != null) {
              Cali.setMediaPlayerVolume(volume);
       
        }
        
        if (dayz != null) {
              dayz.setMediaPlayerVolume(volume);
       
        }
        
        if (Lat != null) {
              Lat.setMediaPlayerVolume(volume);
       
        }
        
        if (test != null) {
              test.setMediaPlayerVolume(volume);
       
        }
        
        if (lon != null) {
              lon.setMediaPlayerVolume(volume);
       
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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//INICIALIZAR VOLUMESLIDER......................................................
        
          volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
              
        @Override
        
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            double volume = newValue.doubleValue() / 100.0;
            
            if (deftonesController != null) {
                deftonesController.setMediaPlayerVolume(volume);
            }
            if (thrillerController != null) {
                thrillerController.setMediaPlayerVolume(volume);
            }
            if (WDTY_1 != null) {
                WDTY_1.setMediaPlayerVolume(volume);
            }
            
             if (WDTY_2 != null) {
                WDTY_2.setMediaPlayerVolume(volume);
            }
             if (Lis != null) {
                Lis.setMediaPlayerVolume(volume);
            }
              if (KNY != null) {
                KNY.setMediaPlayerVolume(volume);
            }
              if (damn != null) {
              damn.setMediaPlayerVolume(volume);
              
            }
              if (mr != null) {
              mr.setMediaPlayerVolume(volume);
    
        }
              if (trench != null) {
              trench.setMediaPlayerVolume(volume);
       
        }
              if (Blurry != null) {
              Blurry.setMediaPlayerVolume(volume);
       
        }
              if (TGA != null) {
              TGA.setMediaPlayerVolume(volume);
       
        }
        
              if (Cali != null) {
              Cali.setMediaPlayerVolume(volume);
       
        }
              if (dayz != null) {
              dayz.setMediaPlayerVolume(volume);
       
        }
        
        if (Lat != null) {
              Lat.setMediaPlayerVolume(volume);
       
        }
        
        if (test != null) {
              test.setMediaPlayerVolume(volume);
       
        }
        
        if (lon != null) {
              lon.setMediaPlayerVolume(volume);
       
        }
              
        }
    });

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
    }

    @FXML
private void Deftones_White_Pony_Page(MouseEvent event) {
   try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Deftones_White_Pony_Page.fxml"));
        Parent root = loader.load();
        deftonesController = loader.getController();
        if (deftonesController != null) {
            deftonesController.setMainController(this); 
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
        
         if (deftonesController != null) {
        String randomSong = deftonesController.toggleRandomMode();
    }
         if (thrillerController != null) {
        String randomSong = thrillerController.toggleRandomMode();
    
    }
         
         if (WDTY_1 != null) {
        String randomSong = WDTY_1.toggleRandomMode();
         
    }
         if (WDTY_2 != null) {
        String randomSong = WDTY_2.toggleRandomMode();
        }
        
        if (Lis != null) {
        String randomSong = Lis.toggleRandomMode();
        } 
        
        if (KNY != null) {
        String randomSong = KNY.toggleRandomMode();
        }
         
        if (damn != null) {
        String randomSong = damn.toggleRandomMode();
        }
        
        if (mr != null) {
        String randomSong = mr.toggleRandomMode();
        }
        
        if (trench != null) {
        String randomSong = trench.toggleRandomMode();
        }
        
        if (Blurry != null) {
        String randomSong = Blurry.toggleRandomMode();
        }
        
        if (TGA != null) {
        String randomSong = TGA.toggleRandomMode();
        }
        
        if (Cali != null) {
        String randomSong = Cali.toggleRandomMode();
        }
        
        if (dayz != null) {
        String randomSong = dayz.toggleRandomMode();
        }
        
        if (Lat != null) {
        String randomSong = Lat.toggleRandomMode();
        }
        
        if (test != null) {
        String randomSong = test.toggleRandomMode();
        }
        
        if (lon != null) {
        String randomSong = lon.toggleRandomMode();
        }
        
    }

    @FXML
    private void resetMedia(ActionEvent event) {
        
         if (deftonesController != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
         
    }
    
         if (thrillerController != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
   
    }   
         
         if (WDTY_1 != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
         }
    
        
        if (WDTY_2 != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        
        if (Lis != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (KNY != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        
        if (damn != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        
        if (mr != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        
        if (trench != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        
        if (Blurry != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (TGA != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (Cali != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (Lat != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (dayz != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (test != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
        if (lon != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar a la canción anterior solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
  
    }
  
         
}
    
    @FXML
    private void play_pauseMedia(ActionEvent event) {
      
         if (deftonesController != null) {
        deftonesController.playOrPause();
   
    }
     
         if (thrillerController != null) {
        thrillerController.playOrPause();
    
    }
         
         if (WDTY_1 != null) {
        WDTY_1.playOrPause();
   
    }
    
         if (WDTY_2 != null) {
        WDTY_2.playOrPause();
   
    }
         if (Lis != null) {
        Lis.playOrPause();
        }
         
         if (KNY != null) {
        KNY.playOrPause();
        }
         
         if (damn != null) {
        damn.playOrPause();
        }
         
         if (mr != null) {
        mr.playOrPause();
        }
         
         if (trench != null) {
        trench.playOrPause();
        }
         
         if (Blurry != null) {
        Blurry.playOrPause();
        }
         
         if (TGA != null) {
        TGA.playOrPause();
        }
        
        if (Cali != null) {
        Cali.playOrPause();
        }
        
        if (Lat != null) {
        Lat.playOrPause();
        }
        
        if (dayz != null) {
        dayz.playOrPause();
        }
        
        if (test != null) {
        test.playOrPause();
        }
        
        if (lon != null) {
        lon.playOrPause();
        }
         
}

    @FXML
    private void NextMedia(ActionEvent event) {
        
         if (deftonesController != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    
    }
    
         if (thrillerController != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    
    
    }
         
         if (WDTY_1 != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (WDTY_2 != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (Lis != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (KNY != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (damn != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (mr != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (trench != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (Blurry != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (TGA != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (Cali != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (Lat != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (dayz != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         
         if (test != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
         if (lon != null) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("La funcion de pasar canción solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    

    }
}

    @FXML
    private void bucleMedia(ActionEvent event) {
        
         if (deftonesController != null) {
        deftonesController.toggleLoopMode();

    }
    
         if (thrillerController != null) {
        thrillerController.toggleLoopMode();
 
    }
         
         if (WDTY_1 != null) {
        WDTY_1.toggleLoopMode();
   
    }
    
         if (WDTY_2 != null) {
        WDTY_2.toggleLoopMode();
    
    }
         if (Lis != null) {
        Lis.toggleRandomMode();
        }
         
         if (KNY != null) {
        KNY.toggleLoopMode();
        } 
         
         if (damn != null) {
        damn.toggleLoopMode();
        } 
         
         if (mr != null) {
        mr.toggleLoopMode();
        } 
         
         if (trench != null) {
        trench.toggleLoopMode();
        } 
         
         if (Blurry != null) {
        Blurry.toggleLoopMode();
        }
         
          if (TGA != null) {
        TGA.toggleLoopMode();
        }
        
        if (Cali != null) {
        Cali.toggleLoopMode();
        }
        
        if (Lat != null) {
        Lat.toggleLoopMode();
        }
        
        if (dayz != null) {
        dayz.toggleLoopMode();
        }
        
        if (test != null) {
        test.toggleLoopMode();
        }
        
        if (lon != null) {
        lon.toggleLoopMode();
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
          Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("Esta característica solo esta disponible para usuarios registrados por favor inicie sesion.");
    alert.show();
    }

   

    @FXML
    private void Page_Art(ActionEvent event) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("Solo los usuarios registrados pueden ver todos los artistas por favor inicie sesion.");
    alert.show();
    }

    

    @FXML
    private void Page_plast(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Advertencia");
    alert.setHeaderText(null);
    alert.setContentText("Solo los usuarios registrados pueden ver todas las playlist por favor inicie sesion.");
    alert.show();
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
          
        

