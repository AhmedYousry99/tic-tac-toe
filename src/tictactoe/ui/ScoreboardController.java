/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.util.CustomDialogBase;

/**
 *
 * @author Shyasuo
 */
public class ScoreboardController {
    
    public static ScoreboardBase scoreboardBase;
    
    public static void getScoreboardPlayers(){
        try {
            PlayerMessageBody pl= new PlayerMessageBody();
            pl.setState(SocketRoute.SCORE_BOARD);
            System.out.println("sending request to get score board");
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PlayerScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
