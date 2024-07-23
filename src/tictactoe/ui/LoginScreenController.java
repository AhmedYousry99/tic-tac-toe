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
    
}
