package tictactoe.ui.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tictactoe.TicTacToe;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.ConnectionInterface;
import tictactoe.ui.GamePlayBoard;

public class CustomDialogWithTextFieldBase extends AnchorPane {

    protected final Text text;
    protected final TextField textField1;
    protected final Button okButton;
    protected final Button cancelButton;
    protected final Stage stage;
    

    public CustomDialogWithTextFieldBase(String message, String defaultButtontext, String cancelButtonText, Parent currentRoot, Parent newRoot) {

        text = new Text();
        textField1 = new TextField();
        okButton = new Button();
        cancelButton = new Button();
        this.stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(this, USE_PREF_SIZE, USE_PREF_SIZE));

        setId("AnchorPane");
        setPrefHeight(250.0);
        setPrefWidth(375.0);
        setStyle("-fx-background-color: #050046;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(22.0);
        text.setLayoutY(85.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText(message);
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(331.4700164794922);
        text.setFont(new Font("Agency FB", 24.0));

        textField1.setLayoutX(43.0);
        textField1.setLayoutY(113.0);
        textField1.setPrefWidth(250.0);
        textField1.setPromptText("ex: 192.168.1.10");
        textField1.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5); -fx-text-fill: rgba(217, 217, 217, 1);");
        textField1.setFont(new Font("Agency FB Bold", 18.0));

        okButton.setLayoutX(228.0);
        okButton.setLayoutY(184.0);
        okButton.setMnemonicParsing(false);
        okButton.setPrefWidth(125.0);
        okButton.setStyle("-fx-background-color: D38CC4;");
        okButton.setText(defaultButtontext);
        okButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        okButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        okButton.setFont(new Font("Agency FB Bold", 18.0));
        okButton.setDefaultButton(true);
        okButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            String ip = textField1.getText();
            if(validateInput(ip)){
                try {
                    
                    okButton.setDisable(true);
                    cancelButton.setDisable(true);
                    SocketConnectionController.initialize(ip);
                    stage.close();
                    ScreenController.pushScreen(newRoot, currentRoot);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(CustomDialogWithTextFieldBase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CustomDialogWithTextFieldBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        cancelButton.setLayoutX(22.0);
        cancelButton.setLayoutY(184.0);
        cancelButton.setMnemonicParsing(false);
        cancelButton.setPrefWidth(125.0);
        cancelButton.setStyle("-fx-background-color: D38CC4;");
        cancelButton.setText(cancelButtonText);
        cancelButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cancelButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        cancelButton.setFont(new Font("Agency FB Bold", 18.0));
        cancelButton.setCancelButton(true);
        cancelButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            stage.close();
        });

        getChildren().add(text);
        getChildren().add(textField1);
        getChildren().add(okButton);
        getChildren().add(cancelButton);
        stage.show();
        
    }
    
        private boolean validateInput(String ip){
        boolean result = false;
        if(!ip.isEmpty()){
            String[] octets = ip.split("[.]");  
            if(octets.length == 4){
                
                result = true;
            }
        }
        
        return result;
    }
}
