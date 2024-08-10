/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.util.CustomDialogBase;

/**
 *
 * @author Kerolos Raouf
 */
public class OnlineModeController extends BoardController{
    public boolean currentPlayerSymbol;
    public String opponentName;
    public boolean opponentLeft;
    static GamePlayBoard gamePlayBoard;

    public OnlineModeController(boolean symbol, String name)
    {
        currentPlayerSymbol = symbol;
        opponentName = name;
        opponentLeft = false;
    }
    
    public void setMoveToOnline(int i ,int j,boolean symbol)
    {
        addToMoves(i, j);
        if(symbol)
        {
            simulationBoard[i][j] = 'x';         
        }else
        {
            simulationBoard[i][j] = 'o';
        }
    }
    
    public String convertMoveToStirng(int i,int j)
    {
        String str = "";
        str += String.valueOf(i);
        str += String.valueOf(j);
        return str;
    }
    
    public void surrender(){
        PlayerMessageBody pl = new PlayerMessageBody();
        pl.setOpponentName(PlayerDataHandler.opponent.getUsername());
        pl.setState(SocketRoute.SURRENDER);
        try {
            PlayerDataHandler.getInstance().sendMessage(pl, (success) -> {
            });
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(OnlineModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void handleSurrenderResponse(){
        ((OnlineModeController) GamePlayBoard.boardController).opponentLeft = true;
        gamePlayBoard.doStuffOnGetResult(0);
    }

    void leaveMatch()
    {
        PlayerMessageBody pl = new PlayerMessageBody();
        pl.setState(SocketRoute.LEAVE_MATCH);
        try {
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(OnlineModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void countWin(String userName){
        PlayerMessageBody pl = new PlayerMessageBody();
        pl.setUsername(userName);
        pl.setState(SocketRoute.INCREMENT_SCORE);
        try {
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(OnlineModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void handleLeaveResponse(){
        ((OnlineModeController) GamePlayBoard.boardController).opponentLeft = true;
        new CustomDialogBase("Opponent left the room.", null, "Ok", null, null);
        gamePlayBoard.btnRematch.setDisable(true);
    }
}
