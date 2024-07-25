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

    
    protected int currentPlayer;
    int playerXXWins,playerOOWins,roundsNumber;
    protected char[][] simulationBoard;
    boolean isGameInProgress;
    protected String moves;
    
    
    public BoardController()
    {
        moves = "";
        playerXXWins = 0;
        playerOOWins = 0;
        roundsNumber = 1;
        
        
        isGameInProgress = true;
        currentPlayer = 1;
        simulationBoard = new char[3][3];
        
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                simulationBoard[i][j] = '.';
            }
        }
    }

    
    
    void setMove(int i ,int j)
    {

        if(isThisAValidMove(i, j))
        {
            addToMoves(i, j);
            if(currentPlayer == 1)
            {
                simulationBoard[i][j] = 'x';
                currentPlayer = 0;
                
            }else
            {
                simulationBoard[i][j] = 'o';
                currentPlayer = 1;
            }
        }
    }
    
    void resetBoard()
    {
        currentPlayer = 1;
        isGameInProgress = true;
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                simulationBoard[i][j] = '.';
            }
        }
    }
    
    int getBoardState(char grid[][])
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
                if(grid[i][j] == '.')dots++;
                if(grid[i][j] == 'x')x++;
                if(grid[i][j] == 'o')o++;
                if(i == j &&grid[i][j] == 'x')dix++;
                if(i == j &&grid[i][j] == 'o')dio++;
                if(i + j == 2 &&grid[i][j] == 'x')dix2++;
                if(i + j == 2 &&grid[i][j] == 'o')dio2++;
            }
            if(x == 3 || dix == 3 || dix2 == 3)return 1;
            if(o == 3 || dio == 3 || dio2 == 3)return 0;
        }
        
        for(int j = 0 ;j < 3;j++)
        {
            x = o = 0;
            for(int i = 0 ;i < 3;i++)
            {        
                if(grid[i][j] == 'x')x++;
                if(grid[i][j] == 'o')o++;
            }
            if(x == 3)return 1;
            if(o == 3)return 0;
        }

        if(dots == 0)return 2;
        
         return -1;
    }
    
    void showDialogToSaveMatch(String mode ,int winner)
    {
        String message = "Do you want to save the match.";
        
        CustomDialogBase dialog = new CustomDialogBase(
                message,
                "Save",
                "Cancel", 
                ()->{
                    saveMatch(mode, winner);
                }, 
                ()->{moves = "";});
    }
    
    void saveMatch(String mode ,int winner)
    {
        MainFileController mf = new MainFileController();
        try {
                int xWins = (winner == 1) ? playerXXWins-1:playerXXWins;
                int oWins = (winner == 0) ? playerOOWins-1:playerOOWins;
                String temp = String.valueOf(roundsNumber-1) + "," 
                        + String.valueOf(xWins) + ","
                        + String.valueOf(oWins) + "," + moves;
                 mf.writeFileInDirectory(mode, temp);
                 moves = "";
            } catch (IOException ex) {
                Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public char[][] getSimulationBoard()
    {
        return simulationBoard;
    }
    
    protected void addToMoves(int i,int j)
    {
        moves += String.valueOf(i);
        moves += String.valueOf(j);
        moves += ',';
    }
    
    protected char reverserPlayerChar(char player)
    {
        if(player == 'x')return 'o';
        else return 'x';
    }
    
    protected int getPlayerCharNumber(char player)
    {
        if(player == 'x')return 1;
        else return 0;
    }

    void doComputerMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected boolean isThisAValidMove(int i ,int j)
    {
        if(simulationBoard[i][j] == '.' && isGameInProgress)
        {
            return true;
        }else
        {
            return false;
        }
    }
    
}
