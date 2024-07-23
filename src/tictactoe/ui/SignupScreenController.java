/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    
}
