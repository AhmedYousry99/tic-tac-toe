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
import tictactoe.ui.util.ScreenController;

public class PlayersModeFXMLBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text gameModeText;
    protected final Button singlePlayerButton;
    protected final Button twoPlayerButton;
    protected final Button backButton;

    public PlayersModeFXMLBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        gameModeText = new Text();
        singlePlayerButton = new Button();
        twoPlayerButton = new Button();
        backButton = new Button();


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

        singlePlayerButton.setMaxWidth(Double.MAX_VALUE);
        singlePlayerButton.setMnemonicParsing(false);
        singlePlayerButton.setPrefHeight(78.0);
        singlePlayerButton.setPrefWidth(432.0);
        singlePlayerButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        singlePlayerButton.setText("Single Player");
        singlePlayerButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        singlePlayerButton.setFont(new Font("Agency FB Bold", 36.0));
        
        FlowPane.setMargin(singlePlayerButton, new Insets(0.0, 50.0, 0.0, 50.0));

        twoPlayerButton.setLayoutX(406.0);
        twoPlayerButton.setLayoutY(331.0);
        twoPlayerButton.setMaxWidth(Double.MAX_VALUE);
        twoPlayerButton.setMnemonicParsing(false);
        twoPlayerButton.setPrefHeight(80.0);
        twoPlayerButton.setPrefWidth(442.0);
        twoPlayerButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        twoPlayerButton.setText("Two Players");
        twoPlayerButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        twoPlayerButton.setFont(new Font("Agency FB Bold", 36.0));
        twoPlayerButton.setOnAction((e) -> {
            ScreenController.pushScreen(new GamePlayBoard(new BoardController()), this);
        });
        FlowPane.setMargin(twoPlayerButton, new Insets(0.0, 50.0, 0.0, 50.0));
        
        backButton.setLayoutX(406.0);
        backButton.setLayoutY(385.0);
        backButton.setMaxWidth(Double.MAX_VALUE);
        backButton.setMnemonicParsing(false);
        backButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        backButton.setText("Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        backButton.setFont(new Font("Agency FB Bold", 36.0));
        backButton.setOnAction((e) -> {
            ScreenController.popScreen();
        });
        FlowPane.setMargin(backButton, new Insets(0.0, 50.0, 0.0, 50.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(gameModeText);
        flowPane.getChildren().add(singlePlayerButton);
        flowPane.getChildren().add(twoPlayerButton);
        flowPane.getChildren().add(backButton);
        getChildren().add(flowPane);

    }
}
