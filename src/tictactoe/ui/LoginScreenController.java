/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emyal
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField usernameTxtField;
    @FXML
    private Button loginButton;
    @FXML
    private TextField passwordTxtField;
    private static Parent loginScreen;
    private static Scene loginScreenScene;
    private static Stage loginStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   public static void gotoLoginScreenBase(ActionEvent event) {
        
       loginScreen = new LoginScreenBase();
       loginScreenScene = new Scene (loginScreen);
       loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       loginStage.setScene(loginScreenScene);
       loginStage.show();
    }
    
}
