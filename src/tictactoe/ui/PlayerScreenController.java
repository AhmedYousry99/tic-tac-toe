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
import tictactoe.TicTacToe;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.CustomPlayerListTile;


/**
 *
 * @author Shyasuo
 */
public class PlayerScreenController {
    
    public static void getAllPlayers(List<CustomPlayerListTile> listTiles, PlayersScreenBase playersScreenBase){
        try {
            SocketConnectionController.initialize("172.16.14.195");
            SocketConnectionController.getInstance().setPlayerDataHandlerFunction(playersScreenBase::addPlayersToList);
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.ALL_PLAYERS);
            Thread th = new Thread(SocketConnectionController.getInstance().getPlayerDataHandler());
            th.start();
            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl, SocketRoute.ALL_PLAYERS);
                    TicTacToe.primaryStage.setOnCloseRequest((e) -> {
                    th.stop();
        });
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
