package tictactoe.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import tictactoe.data.MainFileController;
import tictactoe.domain.FileController;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.util.ScreenController;

public class HistoryScreenFXMLBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text text;
    protected final VBox vBox;
    protected final Label label;
    protected final Label emptyListLabel;
    protected final ListView<HBox> listView;
    protected final Button backButton;
    private ObservableList<HBox> hboxs;
    private ArrayList<CustomHistoryListTile> listTiles;
    

    public HistoryScreenFXMLBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        text = new Text();
        vBox = new VBox();
        label = new Label();
        listTiles = new ArrayList();
        emptyListLabel = new Label(HistoryScreenFXMLController.getRecordedGames(listTiles, this) ? "You haven't saved any recordings yet." : "Failed to load recorded games");
        
        
        hboxs = FXCollections.observableArrayList(
            listTiles
        );
        
        
        listView= new ListView(hboxs);
        listView.setPlaceholder(emptyListLabel);
        emptyListLabel.setAlignment(javafx.geometry.Pos.CENTER);
        emptyListLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        emptyListLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emptyListLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        emptyListLabel.setFont(new Font("Agency FB", 48.0));
        

        backButton = new Button();

   
 

        imageView.setCache(true);
        imageView.setCacheHint(javafx.scene.CacheHint.SPEED);
        imageView.setPickOnBounds(true);
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
        setMargin(flowPane, new Insets(0, 20, 0, 20));

        text.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("History");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(text, new Insets(0.0, 0.0, 25.0, 0.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setStyle("-fx-background-color: #050046; -fx-border-style: hidden hidden solid hidden; -fx-border-width: 4; -fx-border-color: rgba(211, 140, 196, 1)");
        label.setText("Stored Matches");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        label.setFont(new Font("Agency FB", 48.0));
        label.setPadding(new Insets(16.0, 0.0, 16.0, 0.0));

        
        vBox.prefWidthProperty().bind(flowPane.widthProperty());
        listView.setStyle("-fx-background-color: #050046; -fx-background-insets: 0;");
        listView.setPrefHeight(500.0);
       
        
        StackPane.setAlignment(backButton, javafx.geometry.Pos.BOTTOM_LEFT);
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
            ScreenController.popScreen();
        });
        StackPane.setMargin(backButton, new Insets(0.0, 0.0, 20.0, 50.0));
        
        vBox.setStyle(" -fx-border-style: solid; -fx-border-color: rgba(211, 140, 196, 1); -fx-border-width: 2;");


        getChildren().add(imageView);
        flowPane.getChildren().add(text);
        vBox.getChildren().add(label);
        vBox.getChildren().add(listView);
        
        flowPane.getChildren().add(vBox);
        getChildren().add(flowPane);
        getChildren().add(backButton);

    }
}
