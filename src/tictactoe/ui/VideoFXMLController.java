/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.*;
import java.lang.Thread;
import javafx.animation.PauseTransition;
import javafx.scene.Parent;
import javafx.util.Duration;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.util.ScreenController;

/**
 *
 * @author Ghazala
 */
public class VideoFXMLController{
    
    @FXML
   private MediaPlayer mediaplayer;

    public MediaPlayer getMediaplayer() {
        return mediaplayer;
    }
   private String url;
   private int time;

   private boolean finished = false;
    public VideoFXMLController(String url, int time) {
//        primaryStage.getIcons().add(new Image(ResourcesLocation.class.
//                        getResource("images/icons/xo_icon.png").toExternalForm()));
        
 
        this.url = url;
        Media media = new Media(ResourcesLocation.class.
                        getResource(url).toExternalForm());
        mediaplayer = new MediaPlayer(media);
        this.time = time;
    }
    
    

    void play(){
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> {skipVedio();});
        mediaplayer.play();
        delay.play();
        
    }
    
   void skipVedio()
   {
       if(!finished)
       {
           ScreenController.popScreen();
            mediaplayer.stop();
            
            finished = true;
       }
       
   }
}
