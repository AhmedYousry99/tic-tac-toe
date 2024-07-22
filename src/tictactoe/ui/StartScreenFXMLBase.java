package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.resources.ResourcesLocation;

public class StartScreenFXMLBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text welcomeText;
    protected final Button playButton;
    protected final Button historyButton;
    protected final Button backButton;

    public StartScreenFXMLBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        welcomeText = new Text();
        playButton = new Button();
        historyButton = new Button();
        backButton = new Button();
        
        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        //extra
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());
        
        imageView.setImage(new Image(
                ResourcesLocation.class.
                        getResource("images/backgrounds/main.jpg").toExternalForm()));

        StackPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(954.0);
        flowPane.setPrefWidth(892.0);
        flowPane.setRowValignment(javafx.geometry.VPos.TOP);
        flowPane.setVgap(40.0);

        welcomeText.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        welcomeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        welcomeText.setStrokeWidth(0.0);
        welcomeText.setText("WELCOME TO TIC TAC TOE!");
        welcomeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        welcomeText.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(welcomeText, new Insets(0.0, 0.0, 100.0, 0.0));

        playButton.setMaxWidth(Double.MAX_VALUE);
        playButton.setMnemonicParsing(false);
        playButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        
        
        playButton.setText("Play");
        playButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        playButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(playButton, new Insets(0.0, 50.0, 0.0, 50.0));

        historyButton.setLayoutX(406.0);
        historyButton.setLayoutY(331.0);
        historyButton.setMaxWidth(Double.MAX_VALUE);
        historyButton.setMnemonicParsing(false);
        historyButton.getStylesheets().add("tictactoe/resources/css/application.css");
        historyButton.setText("History");
        historyButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        historyButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(historyButton, new Insets(0.0, 50.0, 0.0, 50.0));

        backButton.setLayoutX(406.0);
        backButton.setLayoutY(385.0);
        backButton.setMaxWidth(Double.MAX_VALUE);
        backButton.setMnemonicParsing(false);
        backButton.getStylesheets().add("tictactoe/resources/css/application.css");
        backButton.setText("Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        backButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(backButton, new Insets(0.0, 50.0, 0.0, 50.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(welcomeText);
        flowPane.getChildren().add(playButton);
        flowPane.getChildren().add(historyButton);
        flowPane.getChildren().add(backButton);
        getChildren().add(flowPane);

    }
}
