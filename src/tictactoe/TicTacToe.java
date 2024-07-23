/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.BoardTwoPlayersModeBase;
import tictactoe.ui.ConnectionModeScreenBase;
import tictactoe.ui.StartScreenFXMLBase;
import tictactoe.ui.util.StaticNames;

/**
 *
 * @author Shyasuo
 */
public class TicTacToe extends Application {
    
    public static Stage primaryStage;
    public static Stack<Parent> roots;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        
        Parent root = new StartScreenFXMLBase();
        
        primaryStage.getIcons().add(new Image(ResourcesLocation.class.
                        getResource("images/icons/xo_icon.png").toExternalForm()));
        
        Scene scene = new Scene(root, 1500, 1000);
        roots = new Stack();
        
        primaryStage.setResizable(false);
        primaryStage.setTitle(StaticNames.TIC_TAC_TOE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
