package tictactoe.ui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.annotation.Resource;
import tictactoe.data.MainFileController;
import tictactoe.domain.PlayingMode;
import tictactoe.resources.ResourcesLocation;

public class BoardTwoPlayersModeBase extends AnchorPane {

    protected final ImageView backgroundImage;
    protected final StackPane stack00;
    protected final ImageView x00;
    protected final ImageView o00;
    protected final ImageView action00;
    protected final StackPane stack01;
    protected final ImageView x01;
    protected final ImageView o01;
    protected final ImageView action01;
    protected final StackPane stack02;
    protected final ImageView x02;
    protected final ImageView o02;
    protected final ImageView action02;
    protected final StackPane stack10;
    protected final ImageView x10;
    protected final ImageView o10;
    protected final ImageView action10;
    protected final StackPane stack11;
    protected final ImageView x11;
    protected final ImageView o11;
    protected final ImageView action11;
    protected final StackPane stack12;
    protected final ImageView x12;
    protected final ImageView o12;
    protected final ImageView action12;
    protected final StackPane stack20;
    protected final ImageView x20;
    protected final ImageView o20;
    protected final ImageView action20;
    protected final StackPane stack21;
    protected final ImageView x21;
    protected final ImageView o21;
    protected final ImageView action21;
    protected final StackPane stack22;
    protected final ImageView x22;
    protected final ImageView o22;
    protected final ImageView action22;
    protected final Text playerXXNameText;
    protected final Text playerXXWinsText;
    protected final Text playerOONameText;
    protected final Text playerOOWinsText;
    protected final Text roundNumberText;
    protected final Text modeText;
    protected final Button btnLeave;
    protected final Button btnRematch;

    public BoardTwoPlayersModeBase() {

        backgroundImage = new ImageView();
        stack00 = new StackPane();
        x00 = new ImageView();
        o00 = new ImageView();
        action00 = new ImageView();
        stack01 = new StackPane();
        x01 = new ImageView();
        o01 = new ImageView();
        action01 = new ImageView();
        stack02 = new StackPane();
        x02 = new ImageView();
        o02 = new ImageView();
        action02 = new ImageView();
        stack10 = new StackPane();
        x10 = new ImageView();
        o10 = new ImageView();
        action10 = new ImageView();
        stack11 = new StackPane();
        x11 = new ImageView();
        o11 = new ImageView();
        action11 = new ImageView();
        stack12 = new StackPane();
        x12 = new ImageView();
        o12 = new ImageView();
        action12 = new ImageView();
        stack20 = new StackPane();
        x20 = new ImageView();
        o20 = new ImageView();
        action20 = new ImageView();
        stack21 = new StackPane();
        x21 = new ImageView();
        o21 = new ImageView();
        action21 = new ImageView();
        stack22 = new StackPane();
        x22 = new ImageView();
        o22 = new ImageView();
        action22 = new ImageView();
        playerXXNameText = new Text();
        playerXXWinsText = new Text();
        playerOONameText = new Text();
        playerOOWinsText = new Text();
        roundNumberText = new Text();
        modeText = new Text();
        btnLeave = new Button();
        btnRematch = new Button();

        BoardTwoPlayersController.resetTwoPlayersModeGame();
        
        setId("AnchorPane");
        setPrefHeight(1000.0);
        setPrefWidth(693.0);

        backgroundImage.setFitHeight(1000.0);
        backgroundImage.setFitWidth(1500.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/board.png").toExternalForm()));

        stack00.setLayoutX(464.0);
        stack00.setLayoutY(258.0);
        stack00.setPrefHeight(150.0);
        stack00.setPrefWidth(200.0);

        x00.setFitHeight(150.0);
        x00.setFitWidth(100.0);
        x00.setOpacity(0.0);
        x00.setPickOnBounds(true);
        x00.setPreserveRatio(true);
        x00.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o00.setFitHeight(150.0);
        o00.setFitWidth(100.0);
        o00.setOpacity(0.0);
        o00.setPickOnBounds(true);
        o00.setPreserveRatio(true);
        o00.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action00.setFitHeight(150.0);
        action00.setFitWidth(200.0);
        action00.setPickOnBounds(true);
        action00.setPreserveRatio(true);

        stack01.setLayoutX(666.0);
        stack01.setLayoutY(257.0);
        stack01.setPrefHeight(150.0);
        stack01.setPrefWidth(200.0);

        x01.setFitHeight(150.0);
        x01.setFitWidth(100.0);
        x01.setOpacity(0.0);
        x01.setPickOnBounds(true);
        x01.setPreserveRatio(true);
        x01.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o01.setFitHeight(150.0);
        o01.setFitWidth(100.0);
        o01.setOpacity(0.0);
        o01.setPickOnBounds(true);
        o01.setPreserveRatio(true);
        o01.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action01.setFitHeight(150.0);
        action01.setFitWidth(200.0);
        action01.setPickOnBounds(true);
        action01.setPreserveRatio(true);

        stack02.setLayoutX(854.0);
        stack02.setLayoutY(259.0);
        stack02.setPrefHeight(150.0);
        stack02.setPrefWidth(200.0);

        x02.setFitHeight(150.0);
        x02.setFitWidth(100.0);
        x02.setOpacity(0.0);
        x02.setPickOnBounds(true);
        x02.setPreserveRatio(true);
        x02.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o02.setFitHeight(150.0);
        o02.setFitWidth(100.0);
        o02.setOpacity(0.0);
        o02.setPickOnBounds(true);
        o02.setPreserveRatio(true);
        o02.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action02.setFitHeight(150.0);
        action02.setFitWidth(200.0);
        action02.setPickOnBounds(true);
        action02.setPreserveRatio(true);

        stack10.setLayoutX(463.0);
        stack10.setLayoutY(425.0);
        stack10.setPrefHeight(150.0);
        stack10.setPrefWidth(200.0);

        x10.setFitHeight(150.0);
        x10.setFitWidth(100.0);
        x10.setOpacity(0.0);
        x10.setPickOnBounds(true);
        x10.setPreserveRatio(true);
        x10.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o10.setFitHeight(150.0);
        o10.setFitWidth(100.0);
        o10.setOpacity(0.0);
        o10.setPickOnBounds(true);
        o10.setPreserveRatio(true);
        o10.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action10.setFitHeight(150.0);
        action10.setFitWidth(200.0);
        action10.setPickOnBounds(true);
        action10.setPreserveRatio(true);

        stack11.setLayoutX(660.0);
        stack11.setLayoutY(426.0);
        stack11.setPrefHeight(150.0);
        stack11.setPrefWidth(200.0);

        x11.setFitHeight(150.0);
        x11.setFitWidth(100.0);
        x11.setOpacity(0.0);
        x11.setPickOnBounds(true);
        x11.setPreserveRatio(true);
        x11.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o11.setFitHeight(150.0);
        o11.setFitWidth(100.0);
        o11.setOpacity(0.0);
        o11.setPickOnBounds(true);
        o11.setPreserveRatio(true);
        o11.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action11.setFitHeight(150.0);
        action11.setFitWidth(200.0);
        action11.setPickOnBounds(true);
        action11.setPreserveRatio(true);

        stack12.setLayoutX(854.0);
        stack12.setLayoutY(420.0);
        stack12.setPrefHeight(150.0);
        stack12.setPrefWidth(200.0);

        x12.setFitHeight(150.0);
        x12.setFitWidth(100.0);
        x12.setOpacity(0.0);
        x12.setPickOnBounds(true);
        x12.setPreserveRatio(true);
        x12.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o12.setFitHeight(150.0);
        o12.setFitWidth(100.0);
        o12.setOpacity(0.0);
        o12.setPickOnBounds(true);
        o12.setPreserveRatio(true);
        o12.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action12.setFitHeight(150.0);
        action12.setFitWidth(200.0);
        action12.setPickOnBounds(true);
        action12.setPreserveRatio(true);

        stack20.setLayoutX(465.0);
        stack20.setLayoutY(581.0);
        stack20.setPrefHeight(150.0);
        stack20.setPrefWidth(200.0);

        x20.setFitHeight(150.0);
        x20.setFitWidth(100.0);
        x20.setOpacity(0.0);
        x20.setPickOnBounds(true);
        x20.setPreserveRatio(true);
        x20.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o20.setFitHeight(150.0);
        o20.setFitWidth(100.0);
        o20.setOpacity(0.0);
        o20.setPickOnBounds(true);
        o20.setPreserveRatio(true);
        o20.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action20.setFitHeight(150.0);
        action20.setFitWidth(200.0);
        action20.setPickOnBounds(true);
        action20.setPreserveRatio(true);

        stack21.setLayoutX(660.0);
        stack21.setLayoutY(585.0);
        stack21.setPrefHeight(150.0);
        stack21.setPrefWidth(200.0);

        x21.setFitHeight(150.0);
        x21.setFitWidth(100.0);
        x21.setOpacity(0.0);
        x21.setPickOnBounds(true);
        x21.setPreserveRatio(true);
        x21.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o21.setFitHeight(150.0);
        o21.setFitWidth(100.0);
        o21.setOpacity(0.0);
        o21.setPickOnBounds(true);
        o21.setPreserveRatio(true);
        o21.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action21.setFitHeight(150.0);
        action21.setFitWidth(200.0);
        action21.setPickOnBounds(true);
        action21.setPreserveRatio(true);

        stack22.setLayoutX(856.0);
        stack22.setLayoutY(586.0);
        stack22.setPrefHeight(150.0);
        stack22.setPrefWidth(200.0);

        x22.setFitHeight(150.0);
        x22.setFitWidth(100.0);
        x22.setOpacity(0.0);
        x22.setPickOnBounds(true);
        x22.setPreserveRatio(true);
        x22.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/x.png").toExternalForm()));

        o22.setFitHeight(150.0);
        o22.setFitWidth(100.0);
        o22.setOpacity(0.0);
        o22.setPickOnBounds(true);
        o22.setPreserveRatio(true);
        o22.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/o.png").toExternalForm()));

        action22.setFitHeight(150.0);
        action22.setFitWidth(200.0);
        action22.setPickOnBounds(true);
        action22.setPreserveRatio(true);

        playerXXNameText.setFill(javafx.scene.paint.Color.WHITE);
        playerXXNameText.setLayoutX(24.0);
        playerXXNameText.setLayoutY(125.0);
        playerXXNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerXXNameText.setStrokeWidth(0.0);
        playerXXNameText.setText("PlayerX");
        playerXXNameText.setFont(new Font("Agency FB", 100.0));

        playerXXWinsText.setFill(javafx.scene.paint.Color.WHITE);
        playerXXWinsText.setLayoutX(48.0);
        playerXXWinsText.setLayoutY(243.0);
        playerXXWinsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerXXWinsText.setStrokeWidth(0.0);
        playerXXWinsText.setText("Wins : 0");
        playerXXWinsText.setFont(new Font("Agency FB", 70.0));

        playerOONameText.setFill(javafx.scene.paint.Color.WHITE);
        playerOONameText.setLayoutX(1235.0);
        playerOONameText.setLayoutY(122.0);
        playerOONameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOONameText.setStrokeWidth(0.0);
        playerOONameText.setText("PlayerO");
        playerOONameText.setFont(new Font("Agency FB", 100.0));

        playerOOWinsText.setFill(javafx.scene.paint.Color.WHITE);
        playerOOWinsText.setLayoutX(1282.0);
        playerOOWinsText.setLayoutY(227.0);
        playerOOWinsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOOWinsText.setStrokeWidth(0.0);
        playerOOWinsText.setText("Wins : 0");
        playerOOWinsText.setFont(new Font("Agency FB", 70.0));

        roundNumberText.setFill(javafx.scene.paint.Color.WHITE);
        roundNumberText.setLayoutX(625.0);
        roundNumberText.setLayoutY(126.0);
        roundNumberText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        roundNumberText.setStrokeWidth(0.0);
        roundNumberText.setText("Round : 1");
        roundNumberText.setFont(new Font("Agency FB", 80.0));

        modeText.setFill(javafx.scene.paint.Color.WHITE);
        modeText.setLayoutX(480.0);
        modeText.setLayoutY(963.0);
        modeText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        modeText.setStrokeWidth(0.0);
        modeText.setText("Two Players Mode");
        modeText.setFont(new Font("Agency FB", 96.0));

        btnLeave.setLayoutX(23.0);
        btnLeave.setLayoutY(887.0);
        btnLeave.setMnemonicParsing(false);
        btnLeave.setPrefHeight(57.0);
        btnLeave.setPrefWidth(210.0);
        btnLeave.setStyle("-fx-background-color: #D38CC4;");
        btnLeave.setText("Leave");
        btnLeave.setFont(new Font("Agency FB Bold", 48.0));

        btnRematch.setLayoutX(1265.0);
        btnRematch.setLayoutY(885.0);
        btnRematch.setMnemonicParsing(false);
        btnRematch.setPrefHeight(57.0);
        btnRematch.setPrefWidth(210.0);
        btnRematch.setStyle("-fx-background-color: #D38CC4;");
        btnRematch.setText("Rematch");
        btnRematch.setFont(new Font("Agency FB Bold", 48.0));

        
        resetBoardUI();
        getChildren().add(backgroundImage);
        stack00.getChildren().add(x00);
        stack00.getChildren().add(o00);
        stack00.getChildren().add(action00);
        getChildren().add(stack00);
        stack01.getChildren().add(x01);
        stack01.getChildren().add(o01);
        stack01.getChildren().add(action01);
        getChildren().add(stack01);
        stack02.getChildren().add(x02);
        stack02.getChildren().add(o02);
        stack02.getChildren().add(action02);
        getChildren().add(stack02);
        stack10.getChildren().add(x10);
        stack10.getChildren().add(o10);
        stack10.getChildren().add(action10);
        getChildren().add(stack10);
        stack11.getChildren().add(x11);
        stack11.getChildren().add(o11);
        stack11.getChildren().add(action11);
        getChildren().add(stack11);
        stack12.getChildren().add(x12);
        stack12.getChildren().add(o12);
        stack12.getChildren().add(action12);
        getChildren().add(stack12);
        stack20.getChildren().add(x20);
        stack20.getChildren().add(o20);
        stack20.getChildren().add(action20);
        getChildren().add(stack20);
        stack21.getChildren().add(x21);
        stack21.getChildren().add(o21);
        stack21.getChildren().add(action21);
        getChildren().add(stack21);
        stack22.getChildren().add(x22);
        stack22.getChildren().add(o22);
        stack22.getChildren().add(action22);
        getChildren().add(stack22);
        getChildren().add(playerXXNameText);
        getChildren().add(playerXXWinsText);
        getChildren().add(playerOONameText);
        getChildren().add(playerOOWinsText);
        getChildren().add(roundNumberText);
        getChildren().add(modeText);
        getChildren().add(btnLeave);
        getChildren().add(btnRematch);
        
         

        btnRematch.setDisable(true);
        btnRematch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               resetBoardUI();
               
                MainFileController mf = new MainFileController();
                try {
                    mf.writeFileInHardDisk(PlayingMode.TwoPlayersMode,"this is moves");
                } catch (IOException ex) {
                    Logger.getLogger(BoardTwoPlayersModeBase.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               btnRematch.setDisable(true);
            }
        });
        //logic
        
        
        
        stack00.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                //System.out.println(getClass());
                
                
   
                int result = BoardTwoPlayersController.setMove(0, 0);
                if(result == 0)
                {
                    o00.setOpacity(1);
                }else if(result == 1)
                {
                    x00.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack01.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(0, 1);
                if(result == 0)
                {
                    o01.setOpacity(1);
                }else if(result == 1)
                {
                    x01.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack02.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(0, 2);
                if(result == 0)
                {
                    o02.setOpacity(1);
                }else if(result == 1)
                {
                    x02.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack10.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(1, 0);
                if(result == 0)
                {
                    o10.setOpacity(1);
                }else if(result == 1)
                {
                    x10.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(1, 1);
                if(result == 0)
                {
                    o11.setOpacity(1);
                }else if(result == 1)
                {
                    x11.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(1, 2);
                if(result == 0)
                {
                    o12.setOpacity(1);
                }else if(result == 1)
                {
                    x12.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });

        
        stack20.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(2, 0);
                if(result == 0)
                {
                    o20.setOpacity(1);
                }else if(result == 1)
                {
                    x20.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack21.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(2, 1);
                if(result == 0)
                {
                    o21.setOpacity(1);
                }else if(result == 1)
                {
                    x21.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
        
        stack22.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //System.out.println("hiiiiiiii");
                
                int result = BoardTwoPlayersController.setMove(2, 2);
                if(result == 0)
                {
                    o22.setOpacity(1);
                }else if(result == 1)
                {
                    x22.setOpacity(1);
                }
                actionWhenGetBoardState();
            }
        });
    

    }
    
    
    private void actionWhenGetBoardState()
    {
        int result = BoardTwoPlayersController.getTwoPlayersModeBoardState();
        
        if(BoardTwoPlayersController.gameInProgressTwoPlayersMode)
        {
           switch(result)
           {
            case 0 :
                doStuffOnGetResult(0);
                break;
            case 1:
                doStuffOnGetResult(1);
                break;
            case 2:
                doStuffOnGetResult(2);
                break;
            } 
        }
        
    }
    
    private void doStuffOnGetResult(int winner)
    {
        BoardTwoPlayersController.gameInProgressTwoPlayersMode = false;
        if(winner == 0)
        {
            BoardTwoPlayersController.playerOOWinsTwoPlayersMode++;
        }else if(winner == 1)
        {
            BoardTwoPlayersController.playerXXWinsTwoPlayersMode++;
        }
        BoardTwoPlayersController.roundsTwoPlayersMode++;
        
        btnRematch.setDisable(false); 
    }
    
    
    
            
    
    private void resetBoardUI()
    {
        x00.setOpacity(0.0);
        x01.setOpacity(0.0);
        x02.setOpacity(0.0);
        x10.setOpacity(0.0);
        x11.setOpacity(0.0);
        x12.setOpacity(0.0);
        x20.setOpacity(0.0);
        x21.setOpacity(0.0);
        x22.setOpacity(0.0);
        
        o00.setOpacity(0.0);
        o01.setOpacity(0.0);
        o02.setOpacity(0.0);
        o10.setOpacity(0.0);
        o11.setOpacity(0.0);
        o12.setOpacity(0.0);
        o20.setOpacity(0.0);
        o21.setOpacity(0.0);
        o22.setOpacity(0.0);
        
        
        /*System.out.println(BoardTwoPlayersController.playerXXWinsTwoPlayersMode);
        System.out.println(BoardTwoPlayersController.playerOOWinsTwoPlayersMode);
        System.out.println(BoardTwoPlayersController.roundsTwoPlayersMode);*/

        playerXXWinsText
                .setText("Wins : " + String.valueOf(BoardTwoPlayersController.playerXXWinsTwoPlayersMode));
        playerOOWinsText
                .setText("Wins : " + String.valueOf(BoardTwoPlayersController.playerOOWinsTwoPlayersMode));
        
        
        int rounds = BoardTwoPlayersController.roundsTwoPlayersMode;
        
        
        roundNumberText
                .setText("Round : " + String.valueOf(rounds));
        
        BoardTwoPlayersController.resetTwoPlayersModeGame();
    }
    
}
