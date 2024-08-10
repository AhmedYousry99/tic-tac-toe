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
import tictactoe.TicTacToe;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.ui.util.CustomDialogBase;

/**
 * FXML Controller class
 *
 * @author emyal
 */
public class SignupScreenController {

  
    private static Parent signupScreen;
    private static Scene signupScreenScene;
    private static Stage signupStage;
    static SignupScreenBase signupScreenBase;

    public static void gotoLoginScreenBase(ActionEvent event) {
        
       signupScreen = new SignupScreenBase();
       signupScreenScene = new Scene (signupScreen);
       signupStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       signupStage.setScene(signupScreenScene);
       signupStage.show();
    }
    
    public static void signup(String username, String password, SignupScreenBase signupScreenBase){
        try {
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setUsername(username);
            pl.setPassword(password);
            pl.setState(SocketRoute.SIGN_UP);
            PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
        } catch (InstantiationException | JsonProcessingException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public static void handleSignupResponse(PlayerMessageBody pl){
        signupScreenBase.getSignupResponse(pl);
    }
    
}
