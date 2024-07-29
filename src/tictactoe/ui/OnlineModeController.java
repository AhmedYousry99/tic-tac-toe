/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

/**
 *
 * @author Kerolos Raouf
 */
public class OnlineModeController extends BoardController{
    public boolean currentPlayerSymbol;
    public String opponentName;

    public OnlineModeController(boolean symbol, String name)
    {
        currentPlayerSymbol = symbol;
        opponentName = name;
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
    
}
