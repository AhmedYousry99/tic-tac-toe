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

    public VideoFXMLController(String url) {
        this.url = url;
        Media media = new Media(url);
        mediaplayer = new MediaPlayer(media);
        
    }
    
    

    void play(){
        mediaplayer.play();
    }
}
