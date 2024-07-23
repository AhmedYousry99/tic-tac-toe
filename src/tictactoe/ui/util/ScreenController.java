/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import tictactoe.TicTacToe;



/**
 *
 * @author Shyasuo
 */
public class ScreenController {
    public static void pushScreen(Parent newRoot, Parent currentRoot){
        TicTacToe.primaryStage.getScene().setRoot(newRoot);
        TicTacToe.roots.push(currentRoot);
    }
    
    public static void popScreen(){
        TicTacToe.primaryStage.getScene().setRoot(TicTacToe.roots.pop());
    }
}
