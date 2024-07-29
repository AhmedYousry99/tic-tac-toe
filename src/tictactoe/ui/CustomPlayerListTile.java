/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.JSONParser;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.ScreenController;
import tictactoe.ui.util.VoidCallableParameterizedPMB;

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
    Player opponent;
    


    public CustomPlayerListTile(Player player, VoidCallableParameterizedPMB func)
    {
        nameLabel = new Label();
        OnlineDisabledButton = new Button();
        AvailableDisabledButton = new Button();
        inviteButton = new Button();
        spacer = new Region();
        opponent = player;
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
        OnlineDisabledButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        OnlineDisabledButton.setTextFill(javafx.scene.paint.Color.WHITE);
        OnlineDisabledButton.setFont(new Font("Agency FB Bold", 24.0));
        OnlineDisabledButton.setPickOnBounds(false);
        HBox.setMargin(OnlineDisabledButton, new Insets(0.0, 20.0, 0.0, 20.0));

        AvailableDisabledButton.setAlignment(javafx.geometry.Pos.CENTER);
        AvailableDisabledButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        AvailableDisabledButton.setMnemonicParsing(false);
        AvailableDisabledButton.setPrefWidth(125.0);
        AvailableDisabledButton.setText("Playing");
        AvailableDisabledButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        AvailableDisabledButton.setTextFill(javafx.scene.paint.Color.WHITE);
        AvailableDisabledButton.setFont(new Font("Agency FB Bold", 24.0));
        AvailableDisabledButton.setPickOnBounds(false);
        HBox.setMargin(AvailableDisabledButton, new Insets(0.0));

        inviteButton.setAlignment(javafx.geometry.Pos.CENTER);
        inviteButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        inviteButton.setMnemonicParsing(false);
        inviteButton.setPrefWidth(125.0);
        inviteButton.setText("Invite");
        inviteButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        inviteButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        inviteButton.setFont(new Font("Agency FB Bold", 24.0));
 
        
        
        nameLabel.setText(player.getUsername());
        OnlineDisabledButton.setDisable(true);
        AvailableDisabledButton.setDisable(true);
        inviteButton.setDisable(player.isIsPlaying() && !player.isIsActive());
        inviteButton.setPickOnBounds(!player.isIsPlaying() && player.isIsActive());
        
        setAlignment(javafx.geometry.Pos.CENTER);
        setPrefHeight(50.0);
        getChildren().add(nameLabel);
        getChildren().add(OnlineDisabledButton);
        getChildren().add(AvailableDisabledButton);
        getChildren().add(spacer);
        getChildren().add(inviteButton);
        HBox.setMargin(inviteButton, new Insets(0.0, 20.0, 0.0, 0.0));
        
        //System.out.println(player.isIsActive() + " " + player.isIsPlaying());
        
        OnlineDisabledButton.setStyle((player.isIsActive() ? "-fx-background-color: rgba(142, 211, 140, 1); " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        
        AvailableDisabledButton.setStyle((player.isIsPlaying() ? "-fx-background-color: rgba(142, 211, 140, 1); " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        
        boolean tempInvBtnState = !LoginScreenBase.currentUser.getUsername().equals(opponent.getUsername()) && (player.isIsActive() && !player.isIsPlaying());
        
        //System.out.println(tempInvBtnState);
        inviteButton.setStyle((tempInvBtnState ? "-fx-background-color: D38CC4; " : "-fx-background-color: rgba(125, 125, 125, 1);") + "-fx-background-radius: 10;");
        inviteButton.setDisable(!tempInvBtnState);
        inviteButton.setPickOnBounds(tempInvBtnState);
        inviteButton.setOnAction((event) -> {
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setOpponentName(player.getUsername());
            func.call(pl);
        });

    }

}
