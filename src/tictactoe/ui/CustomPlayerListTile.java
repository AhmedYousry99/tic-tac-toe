/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;

/**
 *
 * @author Shyasuo
 */
public class CustomPlayerListTile extends HBox{
    
    protected final Label nameLabel;
    protected final Button OnlineDisabledButton;
    protected final Button AvailableDisabledButton;
    protected final Button inviteButton;
    protected final Region spacer;
    Player player;
    


    public CustomPlayerListTile(Player player)
    {
        nameLabel = new Label();
        OnlineDisabledButton = new Button();
        AvailableDisabledButton = new Button();
        inviteButton = new Button();
        spacer = new Region();
        setHgrow(spacer, Priority.ALWAYS);
        nameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setText(player.getUsername());
        nameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        nameLabel.setFont(new Font("Agency FB Bold", 24.0));
        HBox.setMargin(nameLabel, new Insets(0.0, 0.0, 0.0, 20.0));

        OnlineDisabledButton.setAlignment(javafx.geometry.Pos.CENTER);
        OnlineDisabledButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        OnlineDisabledButton.setMnemonicParsing(false);
        OnlineDisabledButton.setPrefWidth(125.0);
        OnlineDisabledButton.setText("Online");
        OnlineDisabledButton.setStyle((player.isIsActive() ? "-fx-background-color: rgba(142, 211, 140, 1); " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        OnlineDisabledButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        OnlineDisabledButton.setTextFill(javafx.scene.paint.Color.WHITE);
        OnlineDisabledButton.setFont(new Font("Agency FB Bold", 24.0));
        HBox.setMargin(OnlineDisabledButton, new Insets(0.0, 20.0, 0.0, 20.0));

        AvailableDisabledButton.setAlignment(javafx.geometry.Pos.CENTER);
        AvailableDisabledButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        AvailableDisabledButton.setMnemonicParsing(false);
        AvailableDisabledButton.setPrefWidth(125.0);
        AvailableDisabledButton.setStyle((player.isIsPlaying()? "-fx-background-color: rgba(142, 211, 140, 1); " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        AvailableDisabledButton.setText("Available");
        AvailableDisabledButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        AvailableDisabledButton.setTextFill(javafx.scene.paint.Color.WHITE);
        AvailableDisabledButton.setFont(new Font("Agency FB Bold", 24.0));
        HBox.setMargin(AvailableDisabledButton, new Insets(0.0));

        inviteButton.setAlignment(javafx.geometry.Pos.CENTER);
        inviteButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        inviteButton.setMnemonicParsing(false);
        inviteButton.setPrefWidth(125.0);
        inviteButton.setStyle("-fx-background-color: D38CC4; -fx-background-radius: 10;");
        inviteButton.setText("Invite");
        inviteButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        inviteButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        inviteButton.setFont(new Font("Agency FB Bold", 24.0));
        inviteButton.setDisable(player.isIsPlaying() || player.isIsActive());
        inviteButton.setStyle((player.isIsActive() && !player.isIsPlaying() ? "-fx-background-color: D38CC4; " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        
        
        nameLabel.setText(player.getUsername());
        OnlineDisabledButton.setDisable(true);
        AvailableDisabledButton.setDisable(true);
        inviteButton.setDisable(player.isIsPlaying() || !player.isIsActive());
        
        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(50.0);
        getChildren().add(nameLabel);
        getChildren().add(OnlineDisabledButton);
        getChildren().add(AvailableDisabledButton);
        getChildren().add(spacer);
        getChildren().add(inviteButton);
        HBox.setMargin(inviteButton, new Insets(0.0, 20.0, 0.0, 0.0));
    }
    

    
    
    
}
