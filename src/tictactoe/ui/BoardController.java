/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import tictactoe.data.MainFileController;
import tictactoe.ui.util.CustomDialogBase;

/**
 * FXML Controller class
 *
 * @author Kerolos Raouf
 */
public class BoardController  {

    
    private int currentPlayerTwoPlayersMode;
    int playerXXWinsTwoPlayersMode,playerOOWinsTwoPlayersMode,roundsTwoPlayersMode;
    private char[][] simulationBoard;
    boolean gameInProgressTwoPlayersMode;
    private String moves;
    
    
    BoardController()
    {
        moves = "";
        playerXXWinsTwoPlayersMode = 0;
        playerOOWinsTwoPlayersMode = 0;
        roundsTwoPlayersMode = 1;
        
        
        gameInProgressTwoPlayersMode = true;
        currentPlayerTwoPlayersMode = 1;
        simulationBoard = new char[3][3];
        
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                simulationBoard[i][j] = '.';
            }
        }
    }

    
    
    int setMove(int i ,int j)
    {
        
        moves += String.valueOf(i);
        moves += String.valueOf(j);
        moves += ',';
        
        if(simulationBoard[i][j] == '.' && gameInProgressTwoPlayersMode)
        {
            if(currentPlayerTwoPlayersMode == 1)
            {
                simulationBoard[i][j] = 'x';
                currentPlayerTwoPlayersMode = 0;
                return 1;
                
            }else
            {
                simulationBoard[i][j] = 'o';
                currentPlayerTwoPlayersMode = 1;
                return 0;
            }
        }else
        {
            return -1;
        }
    }
    
    void resetTwoPlayersModeGame()
    {
        currentPlayerTwoPlayersMode = 1;
        gameInProgressTwoPlayersMode = true;
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                simulationBoard[i][j] = '.';
            }
        }
    }
    
    int getTwoPlayersModeBoardState()
    {
        int dots = 0;
        int x=0,o=0;
        int dix = 0,dio=0;
        int dix2 = 0,dio2=0;
        for(int i = 0 ;i < 3;i++)
        {
            x = o = 0;
            for(int j = 0 ;j < 3;j++)
            {        
                if(simulationBoard[i][j] == '.')dots++;
                if(simulationBoard[i][j] == 'x')x++;
                if(simulationBoard[i][j] == 'o')o++;
                if(i == j &&simulationBoard[i][j] == 'x')dix++;
                if(i == j &&simulationBoard[i][j] == 'o')dio++;
                if(i + j == 2 &&simulationBoard[i][j] == 'x')dix2++;
                if(i + j == 2 &&simulationBoard[i][j] == 'o')dio2++;
            }
            if(x == 3 || dix == 3 || dix2 == 3)return 1;
            if(o == 3 || dio == 3 || dio2 == 3)return 0;
        }
        
        for(int j = 0 ;j < 3;j++)
        {
            x = o = 0;
            for(int i = 0 ;i < 3;i++)
            {        
                if(simulationBoard[i][j] == 'x')x++;
                if(simulationBoard[i][j] == 'o')o++;
            }
            if(x == 3)return 1;
            if(o == 3)return 0;
        }

        if(dots == 0)return 2;
        
         return -1;
    }
    
    void showDialogToSaveMatch(String mode ,char winnerChar)
    {
        
        
        CustomDialogBase dialog = new CustomDialogBase(
                winnerChar + "! is the winner. \n Do you want to save the match.",
                "Save",
                "Cancel", 
                ()->{
                    MainFileController mf = new MainFileController();
            try {
                int xWins = (winnerChar == 'X') ? playerXXWinsTwoPlayersMode-1:playerXXWinsTwoPlayersMode;
                int oWins = (winnerChar == 'O') ? playerOOWinsTwoPlayersMode-1:playerOOWinsTwoPlayersMode;
                String temp = String.valueOf(roundsTwoPlayersMode-1) + "," 
                        + String.valueOf(xWins) + ","
                        + String.valueOf(oWins) + "," + moves;
                mf.writeFileInDirectory(mode, temp);
                moves = "";
            } catch (IOException ex) {
                Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
                }, 
                ()->{});
    }

    
}
