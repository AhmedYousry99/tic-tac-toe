/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

/**
 *
 * @author Shyasuo
 */
public class scoreboardListTile extends HBox{
    protected final Label usernameLabel;
    protected final Label scoreLabel;

    public scoreboardListTile(String userName, String score)
    {
        this.usernameLabel = new Label(userName);
        this.scoreLabel = new Label(score);

        setHgrow(usernameLabel, Priority.ALWAYS);
        setHgrow(scoreLabel, Priority.ALWAYS);
        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(50.0);
        setWidth(USE_PREF_SIZE);

        usernameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        usernameLabel.setMaxWidth(Double.MAX_VALUE);
        usernameLabel.setText(userName);
        usernameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        usernameLabel.setFont(new Font("Agency FB Bold", 36.0));

        scoreLabel.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel.setMaxWidth(Double.MAX_VALUE);
        scoreLabel.setText(score);
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        scoreLabel.setFont(new Font("Agency FB Bold", 36.0));
        
        getChildren().add(usernameLabel);
        getChildren().add(scoreLabel);

    }
    
    
}
