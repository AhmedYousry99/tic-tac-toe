/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import tictactoe.domain.DifficultyLevel;

/**
 *
 * @author Kerolos Raouf
 */
public class SinglePlayerModeController extends BoardController {
    
    private DifficultyLevel difficultyLevel;

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
            if(getBoardState() == -1)doComputerMove();
        }
    }
    
    
    private void doComputerMove()
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
        
    }
    
    private void doDifficultMove()
    {
        
    }
    
    
    
    
    
    
    
    
}
