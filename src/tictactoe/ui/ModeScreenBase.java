package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import tictactoe.resources.ResourcesLocation;

public class ModeScreenBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text text;
    protected final Button localButton;
    protected final Button onlineButton;
    protected final Button backButton;

    public ModeScreenBase() {
        imageView = new ImageView();
        flowPane = new FlowPane();
        text = new Text();
        localButton = new Button();
        onlineButton = new Button();
        backButton = new Button();

        //setMinWidth(1500);
        //setMinHeight(1000);
        //extra
//       imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
//       imageView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
//       imageView.setPreserveRatio(true);
        
        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        
        imageView.setImage(new Image(
                ResourcesLocation.class.
                        getResource("images/backgrounds/main.jpg").toExternalForm()));

        StackPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);
        flowPane.setRowValignment(javafx.geometry.VPos.TOP);
        flowPane.setVgap(40.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("CHOOSE CONNECTION MODE");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(text, new Insets(0.0, 0.0, 100.0, 0.0));

        localButton.setMaxWidth(Double.MAX_VALUE);
        localButton.setMnemonicParsing(false);
        localButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        localButton.setText("Local");
        localButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        localButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(localButton, new Insets(0.0, 50.0, 0.0, 50.0));

        onlineButton.setLayoutX(406.0);
        onlineButton.setLayoutY(331.0);
        onlineButton.setMaxWidth(Double.MAX_VALUE);
        onlineButton.setMnemonicParsing(false);
        onlineButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        onlineButton.setText("Online");
        onlineButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        onlineButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(onlineButton, new Insets(0.0, 50.0, 0.0, 50.0));

        backButton.setLayoutX(406.0);
        backButton.setLayoutY(385.0);
        backButton.setMaxWidth(Double.MAX_VALUE);
        backButton.setMnemonicParsing(false);
        backButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        backButton.setText("Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        backButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(backButton, new Insets(0.0, 50.0, 0.0, 50.0));
        


        getChildren().add(imageView);
        flowPane.getChildren().add(text);
        flowPane.getChildren().add(localButton);
        flowPane.getChildren().add(onlineButton);
        flowPane.getChildren().add(backButton);
        getChildren().add(flowPane);

    }
}
