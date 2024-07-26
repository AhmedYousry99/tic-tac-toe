/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import tictactoe.resources.ResourcesLocation;






/**
 *
 * @author Ghazala
 */
public class MusicController {
    
       private static MediaPlayer mediaPlayer;
       private String url;

    public MusicController ()
    {
        url = ResourcesLocation.class.getResource("audios/background_music.mp3").toExternalForm();
        mediaPlayer = new MediaPlayer(new Media(url));
        mediaPlayer.setOnEndOfMedia(()->{
            mediaPlayer.seek(Duration.ZERO);
        });
        //audioClip.setCycleCount(100);
        mediaPlayer.play();
      
    }
    
    public static void pauseMusic()
    {
        mediaPlayer.pause();
    }
    
    public static void startMusic()
    {
        mediaPlayer.play();
    }
        
   

}

       
   

  