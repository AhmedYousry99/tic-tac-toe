package tictactoe.ui;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.domain.DifficultyLevel;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.util.ScreenController;

public class ChooseLevelFXMLBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text chooseLevel;
    protected final Button easyButton;
    protected final Button intermediateButton;
    protected final Button difficultButton;
    protected final Button backButton;

    public ChooseLevelFXMLBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        chooseLevel = new Text();
        easyButton = new Button();
        intermediateButton = new Button();
        difficultButton = new Button();
        backButton = new Button ();
           
        //extra
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());

        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        imageView.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/main.jpg").toExternalForm()));

        StackPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(954.0);
        flowPane.setPrefWidth(892.0);
        flowPane.setRowValignment(javafx.geometry.VPos.TOP);
        flowPane.setVgap(40.0);

        chooseLevel.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        chooseLevel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        chooseLevel.setStrokeWidth(0.0);
        chooseLevel.setText("CHOOSE LEVEL");
        chooseLevel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        chooseLevel.setWrappingWidth(594.3671875);
        chooseLevel.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(chooseLevel, new Insets(0.0, 0.0, 100.0, 0.0));

        easyButton.setMaxWidth(Double.MAX_VALUE);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(96.0);
        easyButton.setPrefWidth(521.0);
        easyButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        easyButton.setText("Easy");
        easyButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        easyButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(easyButton, new Insets(0.0, 50.0, 0.0, 50.0));

        easyButton.setOnAction((e) -> {
            ScreenController.pushScreen(new GamePlayBoard(new SinglePlayerModeController(DifficultyLevel.EASY)), this);
            });
        
        intermediateButton.setLayoutX(406.0);
        intermediateButton.setLayoutY(331.0);
        intermediateButton.setMaxWidth(Double.MAX_VALUE);
        intermediateButton.setMnemonicParsing(false);
        intermediateButton.setPrefHeight(96.0);
        intermediateButton.setPrefWidth(525.0);
        intermediateButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        intermediateButton.setText("Intermediate");
        intermediateButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        intermediateButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(intermediateButton, new Insets(0.0, 50.0, 0.0, 50.0));

        difficultButton.setLayoutX(406.0);
        difficultButton.setLayoutY(385.0);
        difficultButton.setMaxWidth(Double.MAX_VALUE);
        difficultButton.setMnemonicParsing(false);
        difficultButton.setPrefHeight(88.0);
        difficultButton.setPrefWidth(529.0);
        difficultButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        difficultButton.setText("Difficult");
        difficultButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        difficultButton.setFont(new Font("Agency FB Bold", 36.0));
        FlowPane.setMargin(difficultButton, new Insets(0.0, 50.0, 0.0, 50.0));

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
        flowPane.getChildren().add(chooseLevel);
        flowPane.getChildren().add(easyButton);
        flowPane.getChildren().add(intermediateButton);
        flowPane.getChildren().add(difficultButton);
        flowPane.getChildren().add(backButton);
        getChildren().add(flowPane);

    }
}
