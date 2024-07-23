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

public class PlayersModeFXMLBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text gameModeText;
    protected final Button localButton;
    protected final Button onlineButton;

    public PlayersModeFXMLBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        gameModeText = new Text();
        localButton = new Button();
        onlineButton = new Button();


        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        imageView.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/main.jpg").toExternalForm()));
        //extra
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());

        StackPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(954.0);
        flowPane.setPrefWidth(892.0);
        flowPane.setRowValignment(javafx.geometry.VPos.TOP);
        flowPane.setVgap(40.0);

        gameModeText.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        gameModeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gameModeText.setStrokeWidth(0.0);
        gameModeText.setText("CHOOSE GAME MODE");
        gameModeText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameModeText.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(gameModeText, new Insets(0.0, 0.0, 100.0, 0.0));

        localButton.setMaxWidth(Double.MAX_VALUE);
        localButton.setMnemonicParsing(false);
        localButton.setPrefHeight(78.0);
        localButton.setPrefWidth(432.0);
        localButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        localButton.setText("Single Player");
        localButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        localButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(localButton, new Insets(0.0, 50.0, 0.0, 50.0));

        onlineButton.setLayoutX(406.0);
        onlineButton.setLayoutY(331.0);
        onlineButton.setMaxWidth(Double.MAX_VALUE);
        onlineButton.setMnemonicParsing(false);
        onlineButton.setPrefHeight(80.0);
        onlineButton.setPrefWidth(442.0);
        onlineButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        onlineButton.setText("Two Players");
        onlineButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        onlineButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(onlineButton, new Insets(0.0, 50.0, 0.0, 50.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(gameModeText);
        flowPane.getChildren().add(localButton);
        flowPane.getChildren().add(onlineButton);
        getChildren().add(flowPane);

    }
}
