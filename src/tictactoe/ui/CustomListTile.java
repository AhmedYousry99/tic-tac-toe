/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import tictactoe.ui.util.VoidCallable;

/**
 *
 * @author Shyasuo
 */
public class CustomListTile extends HBox{
    
    protected final Button replayButton;
    protected final HBox hBox;
    protected final Label label;
    protected final Region spacer;

    public CustomListTile(String description, VoidCallable replay) {
        hBox = new HBox();
        label = new Label();
        replayButton = new Button();
        spacer = new Region();
        setHgrow(spacer, Priority.ALWAYS);
        setStyle("-fx-background-color: #050046;");
        
        replayButton.setAlignment(javafx.geometry.Pos.CENTER);
        replayButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        replayButton.setMnemonicParsing(false);
        replayButton.setPrefWidth(125.0);
        replayButton.setStyle("-fx-background-color: D38CC4; -fx-background-radius: 10;");
        replayButton.setText("Replay");
        replayButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        replayButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        replayButton.setFont(new Font("Agency FB Bold", 24.0));
        
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setText(description);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        label.setFont(new Font("Agency FB Bold", 24.0));
        
        
        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(50.0);
    
        getChildren().add(label);
        getChildren().add(spacer);
        getChildren().add(replayButton);
    }
    
    
            
        
    
}
