/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Kerolos Raouf
 */
public class BoardTwoPlayersController  {

    
    private static int twoPlayersCurrentPlayer;
    private static char[][] simulationBoard;
    
    static{
        twoPlayersCurrentPlayer = 1;
        simulationBoard = new char[3][3];
        
        for(int i = 0 ;i < 3;i++)
        {
            for(int j = 0 ;j < 3;j++)
            {
                simulationBoard[i][j] = '.';
            }
        }
    }
    
    
    static int setMove(int i ,int j)
    {

        if(simulationBoard[i][j] == '.')
        {
            if(twoPlayersCurrentPlayer == 1)
            {
                simulationBoard[i][j] = 'x';
                twoPlayersCurrentPlayer = 0;
                return 1;
                
            }else
            {
                simulationBoard[i][j] = 'o';
                twoPlayersCurrentPlayer = 1;
                return 0;
            }
        }else
        {
            return -1;
        }
    }

    
}
