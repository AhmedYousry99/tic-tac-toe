/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import tictactoe.ui.BoardTwoPlayersModeBase;
import tictactoe.ui.ModeScreenBase;

/**
 *
 * @author Shyasuo
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new BoardTwoPlayersModeBase();
        

        Scene scene = new Scene(root, 1500, 1000);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
