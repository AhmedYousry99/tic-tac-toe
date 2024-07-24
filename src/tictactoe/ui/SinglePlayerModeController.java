/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import javafx.animation.PauseTransition;
import javafx.util.Duration;
import tictactoe.domain.DifficultyLevel;

/**
 *
 * @author Kerolos Raouf
 */
public class SinglePlayerModeController extends BoardController {
    
    private DifficultyLevel difficultyLevel;
    private GamePlayBoard currentBoard;

    public SinglePlayerModeController(DifficultyLevel dl) 
    {
        super();
        difficultyLevel = dl;
    }
    
    
    DifficultyLevel getDifficultyLevel()
    {
        return difficultyLevel;
    }

    @Override
    void setMove(int i, int j) {
        if(simulationBoard[i][j] == '.' && isGameInProgress)
        {
            addToMoves(i, j);
            simulationBoard[i][j] = 'x';
            
        }
    }
    
    
    void doComputerMove()
    {
        switch(difficultyLevel)
        {
            case EASY:
                doEasyMove();
                break;
            case INTERMEDIATE:
                doIntermediateMove();
                break;
            case DIFFICULT:
                doDifficultMove();
                break;   
        }
    }
    
    private void doEasyMove()
    {
        boolean ok = true;
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                if(simulationBoard[i][j] == '.')
                {
                    simulationBoard[i][j] = 'o';
                    addToMoves(i, j);
                    ok = false;
                    break;
                }
            }
            if(!ok)break;
        }
    }
    
    private void doIntermediateMove()
    {
        if(simulationBoard[1][1] == '.')
        {
            simulationBoard[1][1] = 'o';
        }
        else if(!isThereWinForPlayer(simulationBoard,'x','o'))
        {
            doEasyMove();
        }
    }
    
    private void doDifficultMove()
    {
        if(simulationBoard[1][1] == '.')
        {
            simulationBoard[1][1] = 'o';
        }
        else if(!isThereWinForPlayer(simulationBoard,'o','o'))
        {
            if(!isThereWinForPlayer(simulationBoard,'x','o'))
            {
                if(!doCornerMove())
                {
                    doEasyMove();
                }
            }
        }
        
    }
    
    /////////
    private boolean isThereWinForPlayer(char grid[][],char Player,char charToPlay)
    {
        for(int i =0;i < 3;i++)
        {
            for(int j =0 ;j < 3;j++)
            {
                if(grid[i][j] == '.')
                {
                    grid[i][j] = Player;
                    if(getBoardState(grid) == getPlayerCharNumber(Player))
                    {
                        simulationBoard[i][j] = charToPlay;
                        return true;
                    }
                    grid[i][j] = '.';
                }
            }
        }
        return false;
    }
    
    
    
    
    
    private boolean doCornerMove()
    {
        if(simulationBoard[1][1] == 'x'){
            if(simulationBoard[0][0] == 'x'
                    || simulationBoard[2][0] == 'x'
                    || simulationBoard[0][2] == 'x'
                    || simulationBoard[2][2] == 'x')
            {
                if(simulationBoard[0][0] == '.'){simulationBoard[0][0] = 'o';return true;} 
                if(simulationBoard[2][0] == '.'){simulationBoard[2][0] = 'o';return true;} 
                if(simulationBoard[0][2] == '.'){simulationBoard[0][2] = 'o';return true;} 
                if(simulationBoard[2][2] == '.'){simulationBoard[2][2] = 'o';return true;} 
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
