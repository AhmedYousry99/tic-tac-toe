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
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;

/**
 * FXML Controller class
 *
 * @author emyal
 */
public class SignupScreenController {

  
    private static Parent signupScreen;
    private static Scene signupScreenScene;
    private static Stage signupStage;
   

    public static void gotoLoginScreenBase(ActionEvent event) {
        
       signupScreen = new SignupScreenBase();
       signupScreenScene = new Scene (signupScreen);
       signupStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       signupStage.setScene(signupScreenScene);
       signupStage.show();
    }
    
    public static void signup(String username, String password, SignupScreenBase signupScreenBase){
        try {
            SocketConnectionController.getInstance().setPlayerDataHandlerFunction(signupScreenBase::getSignupResponse);
            PlayerMessageBody pl = new PlayerMessageBody();
            pl.setUsername(username);
            pl.setPassword(password);
            pl.setState(SocketRoute.SIGN_UP);
 
            Thread th = new Thread(SocketConnectionController.getInstance().getPlayerDataHandler());
            Platform.runLater(th);
            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl, SocketRoute.SIGN_UP_RESPONSE);
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
