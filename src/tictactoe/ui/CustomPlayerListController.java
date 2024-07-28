/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;

/**
 *
 * @author Ghazala
 */
public class CustomPlayerListController {
    
    static void handleInvite(CustomPlayerListTile customPlayerListTile, Player player){
        try {
            SocketConnectionController  scc = SocketConnectionController.getInstance();
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setState(SocketRoute.REQUEST_TO_PLAY);
            pl.setOpponentName(player.getUsername());
            scc.getPlayerDataHandler().sendMessage(pl);
            scc.setPlayerDataHandlerFunction(customPlayerListTile::receiveResponse);
        } catch (InstantiationException ex) {
            Logger.getLogger(CustomPlayerListController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (JsonProcessingException ex) {
                Logger.getLogger(CustomPlayerListController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
