package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.JSONParser;
import tictactoe.domain.Player;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.CustomPlayerListTile;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.ScreenController;

public class PlayersScreenBase extends StackPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Text text;
    protected final VBox vBox;
    protected final ListView listView;
    protected final Button backButton;
    protected final Button scoreboardButton;
    protected final Button replayMatchButton;
    protected final Label listPlaceholdertLabel;
    protected ArrayList<CustomPlayerListTile> listTiles;

    public PlayersScreenBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        text = new Text();
        vBox = new VBox();
        listTiles = new ArrayList();
        listPlaceholdertLabel = new Label("Looking for players...");
        listPlaceholdertLabel.setAlignment(javafx.geometry.Pos.CENTER);
        listPlaceholdertLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        listPlaceholdertLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        listPlaceholdertLabel.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        listPlaceholdertLabel.setFont(new Font("Agency FB", 48.0));
        PlayerScreenController.getAllPlayers(listTiles, this);
        listView= new ListView();
        listView.setPlaceholder(listPlaceholdertLabel);
        backButton = new Button();
        scoreboardButton = new Button();
        replayMatchButton = new Button();
        
        //extra
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());

        setPrefHeight(1000.0);
        setPrefWidth(1500.0);

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

        text.setFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("PLAYERS");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(181.21875);
        text.setFont(new Font("Agency FB Bold", 48.0));
        FlowPane.setMargin(text, new Insets(0.0, 0.0, 25.0, 0.0));

        listView.setPrefWidth(1450.0);
        listView.setStyle("-fx-background-color: #050046; -fx-border-color: rgba(211, 140, 196, 1); -fx-border-width: 5;");


        StackPane.setAlignment(backButton, javafx.geometry.Pos.BOTTOM_LEFT);
        backButton.setAlignment(javafx.geometry.Pos.CENTER);
        backButton.setCancelButton(true);
        backButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        backButton.setMnemonicParsing(false);
        backButton.setPrefWidth(200.0);
        backButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        backButton.setText("Back");
        backButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        backButton.setFont(new Font("Agency FB Bold", 48.0));
        StackPane.setMargin(backButton, new Insets(0.0, 0.0, 20.0, 50.0));
        backButton.setOnAction((e) -> {
            new CustomDialogBase("Are you sure you want to leave? you will be signed out.", "Leave", "Cancel", () -> {
           PlayerScreenController.signOut(this); 
            
            }, null);
        });

        StackPane.setAlignment(scoreboardButton, javafx.geometry.Pos.BOTTOM_CENTER);
        scoreboardButton.setAlignment(javafx.geometry.Pos.CENTER);
        scoreboardButton.setCancelButton(true);
        scoreboardButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        scoreboardButton.setMnemonicParsing(false);
        scoreboardButton.setPrefHeight(91.0);
        scoreboardButton.setPrefWidth(316.0);
        scoreboardButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        scoreboardButton.setText("ScoreBoard");
        scoreboardButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        scoreboardButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        scoreboardButton.setFont(new Font("Agency FB Bold", 48.0));
        StackPane.setMargin(scoreboardButton, new Insets(0.0, 0.0, 20.0, 0.0));

        StackPane.setAlignment(replayMatchButton, javafx.geometry.Pos.BOTTOM_RIGHT);
        replayMatchButton.setAlignment(javafx.geometry.Pos.CENTER);
        replayMatchButton.setCancelButton(true);
        replayMatchButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        replayMatchButton.setMnemonicParsing(false);
        replayMatchButton.setPrefHeight(91.0);
        replayMatchButton.setPrefWidth(280.0);
        replayMatchButton.getStylesheets().add("/tictactoe/resources/css/application.css");
        replayMatchButton.setText("Replay Match");
        replayMatchButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        replayMatchButton.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        replayMatchButton.setFont(new Font("Agency FB Bold", 48.0));
        StackPane.setMargin(replayMatchButton, new Insets(0.0, 50.0, 20.0, 0.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(text);
        vBox.getChildren().add(listView);
        FlowPane.setMargin(vBox, new Insets(0.0, 20.0, 0.0, 20.0));
        StackPane.setMargin(flowPane, new Insets(0.0));
        flowPane.getChildren().add(vBox);
        getChildren().add(flowPane);
        getChildren().add(backButton);
        getChildren().add(scoreboardButton);
        getChildren().add(replayMatchButton);
        
    }
    
    public void addPlayersToList(PlayerMessageBody pl){
        ArrayList<Player> temp = pl.getPlayers();
        if(pl.getPlayers() == null){

        }
        else if(temp.isEmpty()){
            listPlaceholdertLabel.setText("There are no registered players.");
        }else{
            for(Player player : temp){
            listTiles.add(new CustomPlayerListTile(player));
        }
            listView.setItems(FXCollections.observableArrayList(
                listTiles
            ));
        }

    }


    void  observeFromServer()
    {
        Thread myTh = new Thread(()->{
           while(true)
           {
               try {
                   
                   String msg =SocketConnectionController.getInstance().getPlayerDataHandler().recieveMessage();
                   PlayerMessageBody pl = JSONParser.convertFromJSONToPlayerMessageBody(msg);
                   switch(pl.getState())
                   {
                       case REQUEST_TO_PLAY:
                       {
                           new CustomDialogBase(pl.getUsername() + " wants to play a match with you.",
                                   "Accept", "Refuse"
                                   , () -> {
                                        try {
                                            pl.setState(SocketRoute.RESPONSE_TO_REQUEST_TO_PLAY);
                                            pl.setOpponentName(pl.getOpponentName());
                                            pl.setResponse(true);
                                            int symbol = new Random().nextInt(2);
                                            if(symbol == 0)pl.setPlayerSymbol(false);
                                            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl);
                                            ScreenController.pushScreen(new GamePlayBoard(new OnlineModeController(!pl.isPlayerSymbol(),pl.getOpponentName())), this);
                                        } catch (InstantiationException ex) {
                                            Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JsonProcessingException ex) {
                                            Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                   }
                                   , ()->{
                                       try {
                                            pl.setState(SocketRoute.RESPONSE_TO_REQUEST_TO_PLAY);
                                            pl.setOpponentName(pl.getOpponentName());
                                            pl.setResponse(false);
                                            SocketConnectionController.getInstance().getPlayerDataHandler().sendMessage(pl);                                        } catch (InstantiationException ex) {
                                            Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (JsonProcessingException ex) {
                                            Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                   });
                           break;
                       }
                       case RESPONSE_TO_REQUEST_TO_PLAY:
                       {
                           if(pl.getResponse())
                           {
                               ScreenController.pushScreen(new GamePlayBoard(new OnlineModeController(pl.isPlayerSymbol(),pl.getOpponentName())), this);
                           }else
                           {
                               new CustomDialogBase("Request refused.", null, "Ok", null, null);
                           }
                           break;
                       }
                   }
               } catch (InstantiationException ex) {
                   Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        });
        
        Platform.runLater(myTh);
    }
    
    
    public void doActionOnAccept()
    {
        
    }
    
    public void doActionOnRefuse()
    {
        
    }

public void signout(PlayerMessageBody pl){
    ScreenController.popUntil(ConnectionModeScreenBase.class);
}
}
