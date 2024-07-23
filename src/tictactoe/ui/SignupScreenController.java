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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author emyal
 */
public class SignupScreenController implements Initializable {

    @FXML
    private TextField usernametxtField;
    @FXML
    private TextField passwordTxtField;
    @FXML
    private TextField confirmPassTxtField;
    @FXML
    private Button signupButton;
    @FXML
    private Hyperlink loginRedirect;
      private static Parent signupScreen;
    private static Scene signupScreenScene;
    private static Stage signupStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public static void gotoLoginScreenBase(ActionEvent event) {
        
       signupScreen = new SignupScreenBase();
       signupScreenScene = new Scene (signupScreen);
       signupStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       signupStage.setScene(signupScreenScene);
       signupStage.show();
    }
    
}
