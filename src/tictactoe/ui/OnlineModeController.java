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
    
    public String convertMoveToStirng(int i,int j)
    {
        String str = "";
        str += String.valueOf(i);
        str += String.valueOf(j);
        return str;
    }
    
}
