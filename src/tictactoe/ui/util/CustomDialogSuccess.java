package tictactoe.ui.util;

import java.util.concurrent.Callable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomDialogSuccess extends AnchorPane {

    protected final Text text;
    protected final Button defaultButton;
    protected final Button cancelButton;
    protected final Stage stage;

    public CustomDialogSuccess(String message, String defaultButtontext, VoidCallable defaultFunc) {

        text = new Text();
        defaultButton = new Button();
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
        text.setFont(new Font("Agency FB", 30.0));

        defaultButton.setLayoutX(228.0);
        defaultButton.setLayoutY(184.0);
        defaultButton.setMnemonicParsing(false);
        defaultButton.setPrefHeight(25.0);
        defaultButton.setPrefWidth(125.0);
        defaultButton.setStyle("-fx-background-color: D38CC4;");
        defaultButton.setText(defaultButtontext);
        defaultButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        defaultButton.setTextFill(javafx.scene.paint.Color.valueOf("#050046"));
        defaultButton.setFont(new Font("Agency FB Bold", 18.0));
        defaultButton.setDefaultButton(true);
        defaultButton.addEventHandler(ActionEvent.ACTION, (e) -> {
            defaultFunc.call();
            stage.close();
        });

       

        getChildren().add(text);
        getChildren().add(defaultButton);
        stage.show();
    }
    
    
}
