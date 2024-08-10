package tictactoe.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.ScoreBoardItem;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.util.ScreenController;

public class ScoreboardBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text text;
    protected final VBox vBox;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final Text text0;
    protected final Text text1;
    protected final ListView listView;
    protected final Label listPlaceholdertLabel;
    protected ArrayList<scoreboardListTile> listTiles;
    protected final Button backButton;

    public ScoreboardBase()
    {
        ScoreboardController.scoreboardBase = this;
        ScoreboardController.getScoreboardPlayers();
        listTiles = new ArrayList<>();
        imageView = new ImageView();
        flowPane = new FlowPane();
        text = new Text();
        vBox = new VBox();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        text0 = new Text();
        text1 = new Text();
        listView = new ListView();
        backButton = new Button();
        listPlaceholdertLabel = new Label("Looking for players...");
        listPlaceholdertLabel.setAlignment(javafx.geometry.Pos.CENTER);
        listPlaceholdertLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        listPlaceholdertLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        listPlaceholdertLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        listPlaceholdertLabel.setFont(new Font("Agency FB", 48.0));
        listView.setPlaceholder(listPlaceholdertLabel);

        //extra
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());

        setPrefHeight(1000.0);
        setPrefWidth(1500.0);

        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setSmooth(false);
        imageView.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/main.jpg").toExternalForm()));

        StackPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        flowPane.setMaxHeight(Double.MAX_VALUE);
        flowPane.setMaxWidth(Double.MAX_VALUE);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(1000.0);
        flowPane.setPrefWidth(1500.0);
        flowPane.setRowValignment(javafx.geometry.VPos.TOP);
        flowPane.setVgap(40.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("SCOREBOARD");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(text, new Insets(0.0, 0.0, 25.0, 0.0));

        gridPane.setStyle("-fx-background-color: #050046; -fx-border-color: rgba(211, 140, 196, 1); -fx-border-width: 5;");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(60.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(text0, javafx.geometry.HPos.CENTER);
        text0.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Name");
        text0.setFont(new Font(36.0));

        GridPane.setColumnIndex(text1, 1);
        GridPane.setHalignment(text1, javafx.geometry.HPos.CENTER);
        text1.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Score");
        text1.setFont(new Font(36.0));

        listView.setPrefWidth(1450.0);
        listView.setStyle("-fx-background-color: #050046; -fx-border-color: rgba(211, 140, 196, 1); -fx-border-width: 5;");

        FlowPane.setMargin(vBox, new Insets(0.0, 20.0, 0.0, 20.0));
        StackPane.setMargin(flowPane, new Insets(0.0));

        StackPane.setAlignment(backButton, javafx.geometry.Pos.BOTTOM_CENTER);
        backButton.setAlignment(javafx.geometry.Pos.CENTER);
        backButton.setCancelButton(true);
        backButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(200.0);
        backButton.getStylesheets().add("tictactoe/resources/css/application.css");
        backButton.setText("Back");
        backButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        backButton.setFont(new Font("Agency FB Bold", 48.0));
        backButton.setOnAction((e) -> {
            ScoreboardController.scoreboardBase = null;
            ScreenController.popScreen();
        });
        StackPane.setMargin(backButton, new Insets(0.0, 0.0, 20.0, 50.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(text);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(text0);
        gridPane.getChildren().add(text1);
        vBox.getChildren().add(gridPane);
        vBox.getChildren().add(listView);

        flowPane.getChildren().add(vBox);
        getChildren().add(flowPane);
        getChildren().add(backButton);

    }

    public void addPlayersToList(PlayerMessageBody pl)
    {
        ArrayList<ScoreBoardItem> temp = pl.getScoreBoardItem();
        if (temp == null) {
            listPlaceholdertLabel.setText("Couldn't fetch players from server");
        } else if (temp.isEmpty()) {
            listPlaceholdertLabel.setText("There are no Top players yet, Become the First!");
        } else {
            listTiles.clear();
            for (ScoreBoardItem item : temp) {
                listTiles.add(new scoreboardListTile(item.getPlayer(), String.valueOf(item.getScore())));
            }
            listView.setItems(FXCollections.observableArrayList(
                listTiles
            ));
        }

    }
}
