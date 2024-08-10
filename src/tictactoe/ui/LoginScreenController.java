/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;


import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.ui.util.CustomDialogBase;


public class LoginScreenController  {

  
    private static Parent loginScreen;
    private static Scene loginScreenScene;
    private static Stage loginStage;
    static LoginScreenBase loginScreenBase;
    
   public static void gotoLoginScreenBase(ActionEvent event) {
        
       loginScreen = new LoginScreenBase();
       loginScreenScene = new Scene (loginScreen);
       loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       loginStage.setScene(loginScreenScene);
       loginStage.show();
    }
    
   
public static void login(String username, String passowrd){
        try {
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setPassword(passowrd);
            pl.setUsername(username);
            pl.setState(SocketRoute.LOG_IN);
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public static void handleLoginResponse(PlayerMessageBody pl){
    loginScreenBase.getLoginResponse(pl);
}
}
