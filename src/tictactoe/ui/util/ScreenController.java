/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui.util;

import java.util.Stack;
import javafx.scene.Parent;
import javafx.scene.Scene;
import tictactoe.TicTacToe;
import tictactoe.ui.StartScreenFXMLBase;



/**
 *
 * @author Shyasuo
 */
public class ScreenController {
    public static void pushScreen(Parent newRoot, Parent currentRoot){
        TicTacToe.primaryStage.getScene().setRoot(newRoot);
        if(currentRoot != null){
            TicTacToe.roots.push(currentRoot);
        }
    }
    
    public static void popScreen(){
        TicTacToe.primaryStage.getScene().setRoot(TicTacToe.roots.pop());
    }
    
    public static void popUntil(Class screenClass) {
        Stack<Parent> tempStack = (Stack<Parent>)TicTacToe.roots.clone();
        Parent tempScreen = null;
        while(!tempStack.isEmpty()){
            if(tempStack.peek().getClass() == screenClass){
                tempScreen = TicTacToe.roots.pop();
                break;
            }
        }
        if(screenClass == StartScreenFXMLBase.class && tempScreen != null){
                TicTacToe.roots = tempStack;
                pushScreen(tempScreen, null);
            }
        if(!tempStack.isEmpty()){
            popScreen();
        }
    }
}
