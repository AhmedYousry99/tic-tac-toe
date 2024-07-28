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
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.CustomPlayerListTile;
import tictactoe.ui.util.ScreenController;


/**
 *
 * @author Shyasuo
 */
public class PlayerScreenController {
    
    public static void getAllPlayers(List<CustomPlayerListTile> listTiles, PlayersScreenBase playersScreenBase){
        try {
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.ALL_PLAYERS);
            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl, SocketRoute.ALL_PLAYERS);
        } catch (InstantiationException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public static void signOut(PlayersScreenBase playersScreenBase){
        try {
            SocketConnectionController.getInstance().setPlayerDataHandlerFunction(playersScreenBase::signout);
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.LOG_OUT);
            Thread th = new Thread(SocketConnectionController.getInstance().getPlayerDataHandler());
            Platform.runLater(th);
            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl, SocketRoute.LOG_OUT);
            //System.out.println("done");
            ScreenController.popScreen();
            ScreenController.popScreen();
        } catch (InstantiationException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
