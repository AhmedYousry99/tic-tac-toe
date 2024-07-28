/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;


import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.CustomDialogSuccess;
import tictactoe.ui.util.ScreenController;
import tictactoe.TicTacToe;


public class LoginScreenController  {

  
    private static Parent loginScreen;
    private static Scene loginScreenScene;
    private static Stage loginStage;
    
   public static void gotoLoginScreenBase(ActionEvent event) {
        
       loginScreen = new LoginScreenBase();
       loginScreenScene = new Scene (loginScreen);
       loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       loginStage.setScene(loginScreenScene);
       loginStage.show();
    }
    
   
public static void login(String username, String passowrd, LoginScreenBase loginScreenBase){
        try {
            SocketConnectionController.getInstance().setPlayerDataHandlerFunction(loginScreenBase::getLoginResponse);
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setPassword(passowrd);
            pl.setUsername(username);
            pl.setState(SocketRoute.LOG_IN);
 
            Thread th = new Thread(SocketConnectionController.getInstance().getPlayerDataHandler());
            Platform.runLater(th);
            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl, SocketRoute.LOG_IN_RESPONSE);
            TicTacToe.primaryStage.setOnCloseRequest((e)->{
                th.stop();
            });
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
