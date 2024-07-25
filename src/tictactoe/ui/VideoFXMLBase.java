package tictactoe.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public class VideoFXMLBase extends AnchorPane {

    protected final MediaView mediaView;
    protected final VideoFXMLController videoController;
    protected final Button skipButton;
    
    public VideoFXMLBase(String url, int time) {
        mediaView = new MediaView();
        skipButton = new Button();

        setId("AnchorPane");
        setPrefHeight(1500.0);
        setPrefWidth(1000.0);

           //extra
        mediaView.fitHeightProperty().bind(this.heightProperty());
        mediaView.fitWidthProperty().bind(this.widthProperty());
        mediaView.setLayoutX(4.0);
        mediaView.setLayoutY(1.0);
        mediaView.setPreserveRatio(false);
        
        skipButton.setLayoutX(30.0);
        skipButton.setLayoutY(30.0);
        skipButton.setMnemonicParsing(false);
        skipButton.setStyle("-fx-background-color: #D38CC4; -fx-border-radius: 5;");
        skipButton.setText("Skip");
        skipButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        skipButton.setFont(new Font("Agency FB Bold", 18.0));
        
        videoController = new VideoFXMLController(url, time);
        mediaView.setMediaPlayer(videoController.getMediaplayer());
        videoController.play();
        
        getChildren().add(mediaView);
        getChildren().add(skipButton);
        videoController.play();
        
        skipButton.setOnAction((e)->{videoController.skipVedio();});
    }

//    public VideoFXMLBase() {
//       mediaView = new MediaView();
//       videoController = new VideoFXMLController("file:///" + System.getProperty("user.dir").replace("\\", "/") +"/src/x_beats_o.mp4");  
//    }
    
}
