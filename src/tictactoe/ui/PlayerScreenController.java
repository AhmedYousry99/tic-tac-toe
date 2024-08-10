/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import tictactoe.ui.PlayersScreenBase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import tictactoe.TicTacToe;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.CustomPlayerListTile;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.ScreenController;


/**
 *
 * @author Shyasuo
 */
public class PlayerScreenController {
    
    public static PlayersScreenBase playersScreenBase;
    
    public static void getAllPlayers(){
        try {
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.ALL_PLAYERS);
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void handleGetAllPlayersResponse(PlayerMessageBody pl){
        playersScreenBase.addPlayersToList(pl);
    }
    
       public static void logOut(){
        try {
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.LOG_OUT);
           PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public static void logOutResponse(){
        try {
            SocketConnectionController.getInstance().disconnectFromServer();
        } catch (InstantiationException | IOException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
            PlayerDataHandler.player = null;
            PlayerDataHandler.opponent = null;
           playersScreenBase.logOut();
       }
    
}
