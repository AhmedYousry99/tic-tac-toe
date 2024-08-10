package tictactoe.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tictactoe.TicTacToe;
import tictactoe.data.SocketConnectionController;
import tictactoe.domain.JSONParser;
import tictactoe.domain.PlayerDataHandler;
import tictactoe.domain.PlayerMessageBody;
import tictactoe.domain.SocketRoute;
import tictactoe.resources.ResourcesLocation;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.ScreenController;

public class GamePlayBoard extends AnchorPane {

    public final ImageView backgroundImage;
    public final StackPane stack00;
    public final ImageView x00;
    public final ImageView o00;
    public final ImageView action00;
    public final StackPane stack01;
    public final ImageView x01;
    public final ImageView o01;
    public final ImageView action01;
    public final StackPane stack02;
    public final ImageView x02;
    public final ImageView o02;
    public final ImageView action02;
    public final StackPane stack10;
    public final ImageView x10;
    public final ImageView o10;
    public final ImageView action10;
    public final StackPane stack11;
    public final ImageView x11;
    public final ImageView o11;
    public final ImageView action11;
    public final StackPane stack12;
    public final ImageView x12;
    public final ImageView o12;
    public final ImageView action12;
    public final StackPane stack20;
    public final ImageView x20;
    public final ImageView o20;
    public final ImageView action20;
    public final StackPane stack21;
    public final ImageView x21;
    public final ImageView o21;
    public final ImageView action21;
    public final StackPane stack22;
    public final ImageView x22;
    public final ImageView o22;
    public final ImageView action22;
    public final Text playerXXNameText;
    public final Text playerXXWinsText;
    public final Text playerOONameText;
    public final Text playerOOWinsText;
    public final Text roundNumberText;
    public final Text modeText;
    public final Button btnLeave;
    public final Button btnRematch;
    public final Button btnSaveMatch;

    public static BoardController boardController;
    public boolean play, saveTheMatch, isTransitionStarted;
    public String modeName;
    Thread replayThread;

    public GamePlayBoard(BoardController customController)
    {
        if (customController instanceof OnlineModeController) {
            OnlineModeController.gamePlayBoard = this;
        }
        play = true;
        saveTheMatch = false;
        boardController = customController;
        modeName = "Two Players Mode";
        boardController.playerXXName = "Player X";
        boardController.playerOOName = "Player O";
        isTransitionStarted = false;
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
        btnSaveMatch = new Button();

        boardController.resetBoard();

        setId("AnchorPane");

        backgroundImage.setPickOnBounds(true);
        backgroundImage.setImage(new Image(ResourcesLocation.class.getResource("images/backgrounds/board.png").toExternalForm()));
        backgroundImage.fitHeightProperty().bind(this.heightProperty());
        backgroundImage.fitWidthProperty().bind(this.widthProperty());

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
        modeText.setFont(new Font("Agency FB", 96.0));

        btnLeave.setLayoutX(23.0);
        btnLeave.setLayoutY(887.0);
        btnLeave.setMnemonicParsing(false);
        btnLeave.setPrefHeight(57.0);
        btnLeave.setPrefWidth(210.0);
        btnLeave.setStyle("-fx-background-color: #D38CC4;");
        btnLeave.setText("Leave");
        btnLeave.setFont(new Font("Agency FB Bold", 48.0));
        btnLeave.setOnAction((e) -> {
            new CustomDialogBase("Are you sure you want to leave?", "Leave", "Cancel", () -> {
                if (boardController instanceof ReplayMatchController) {
                    replayThread.stop();
                }
                if (boardController instanceof OnlineModeController) {
                    if (boardController.isGameInProgress) {
                        ((OnlineModeController) boardController).surrender();
                    } else {
                        ((OnlineModeController) boardController).leaveMatch();
                    }
                   this.boardController = null;
                }
                PlayerScreenController.getAllPlayers();
                ScreenController.popScreen();
            }, () -> {

            });
        });

        btnRematch.setLayoutX(1265.0);
        btnRematch.setLayoutY(885.0);
        btnRematch.setMnemonicParsing(false);
        btnRematch.setPrefHeight(85.0);
        btnRematch.setPrefWidth(210.0);
        btnRematch.setStyle("-fx-background-color: #D38CC4;");
        btnRematch.setText("Play Again");
        btnRematch.setFont(new Font("Agency FB Bold", 30.0));

        btnSaveMatch.setLayoutX(1265.0);
        btnSaveMatch.setLayoutY(780.0);
        btnSaveMatch.setMnemonicParsing(false);
        btnSaveMatch.setPrefHeight(85.0);
        btnSaveMatch.setPrefWidth(210.0);
        btnSaveMatch.setStyle("-fx-background-color: #D38CC4;");
        btnSaveMatch.setText("Save Match");
        btnSaveMatch.setFont(new Font("Agency FB Bold", 30.0));

        updateUIAfterWin();
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
        getChildren().add(btnSaveMatch);

        if (customController instanceof OnlineModeController) {
            if (((OnlineModeController) boardController).currentPlayerSymbol) {
                ((OnlineModeController) boardController).isThisIsCurrentPlayerTurn = true;
                boardController.playerXXName = "X : " + LoginScreenBase.currentUser.getUsername();
                boardController.playerOOName = "O : " + ((OnlineModeController) customController).opponentName;
            } else {
                boardController.playerOOName = "O : " + LoginScreenBase.currentUser.getUsername();
                boardController.playerXXName = "X : " + ((OnlineModeController) customController).opponentName;
                ((OnlineModeController) customController).isThisIsCurrentPlayerTurn = false;
            }

            modeName = "Online Mode";
            //doOnlineMove();
        } else if (customController instanceof ReplayMatchController) {
            btnSaveMatch.setVisible(false);
            btnRematch.setVisible(false);
            modeName = "Replay Mode";
            modeText.setLayoutX(580);
            playMatchFromHistory();

        } else if (customController instanceof SinglePlayerModeController) {
            modeText.setLayoutX(400.0);
            modeText.setFont(new Font("Agency FB", 76.0));
            boardController.playerOOName = "Computer";
            playerOONameText.setLayoutX(1180);
            switch (((SinglePlayerModeController) customController).getDifficultyLevel()) {
                case EASY:
                    modeName = "Single Palyer Mode (EASY)";
                    break;
                case INTERMEDIATE:
                    modeName = "Single Palyer Mode (INTERMEDIATE)";
                    break;
                case DIFFICULT:
                    modeName = "Single Palyer Mode (DIFFICULT)";
                    break;
            }
        } else if (customController instanceof BoardController) {
            modeName = "Two Players Mode";
        }

        modeText.setText(modeName);
        playerXXNameText.setText(boardController.playerXXName);
        playerOONameText.setText(boardController.playerOOName);

        //logic    
        btnRematch.setDisable(true);
        btnRematch.setOnAction((e) -> {
            if (boardController instanceof OnlineModeController) {
                if (((OnlineModeController) boardController).currentPlayerSymbol) {
                    boardController.isThisIsCurrentPlayerTurn = true;
                } else {
                    boardController.isThisIsCurrentPlayerTurn = false;
                }
                PlayerMessageBody pl = new PlayerMessageBody();
                pl.setState(SocketRoute.PLAY_AGAIN);
                pl.setOpponentName(((OnlineModeController) boardController).opponentName);
                try {
                    PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                boardController.isThisIsCurrentPlayerTurn = true;
            }

            boardController.resetBoard();
            resetBoardBaseOnSimulationBoard();
            resetSaveMatchBtn();
            boardController.resetMatchMoves();
            isTransitionStarted = false;
            btnRematch.setDisable(true);
        });

        btnSaveMatch.setOnAction((e) -> {
            btnSaveMatch.setStyle("-fx-background-color: #96D38C;");
            btnSaveMatch.setText("Recording...");
            saveTheMatch = true;
            btnSaveMatch.setDisable(true);
        });

        stack00.setOnMouseClicked((event) -> {
            ButtonAction(0, 0);
        });

        stack01.setOnMouseClicked((event) -> {
            ButtonAction(0, 1);
        });

        stack02.setOnMouseClicked((event) -> {
            ButtonAction(0, 2);
        });

        stack10.setOnMouseClicked((event) -> {
            ButtonAction(1, 0);
        });

        stack11.setOnMouseClicked((event) -> {
            ButtonAction(1, 1);
        });

        stack12.setOnMouseClicked((event) -> {
            ButtonAction(1, 2);
        });

        stack20.setOnMouseClicked((event) -> {
            ButtonAction(2, 0);
        });

        stack21.setOnMouseClicked((event) -> {
            ButtonAction(2, 1);
        });

        stack22.setOnMouseClicked((event) -> {
            ButtonAction(2, 2);
        });

    }

    void ButtonAction(int i, int j)
    {

        if (boardController.isThisIsCurrentPlayerTurn && boardController.isThisIsAValidMove(i, j)) {
            if (boardController instanceof OnlineModeController) {
                ((OnlineModeController) boardController).setMoveToOnline(i, j, ((OnlineModeController) boardController).currentPlayerSymbol);
                resetBoardBaseOnSimulationBoard();
                PlayerMessageBody pl = new PlayerMessageBody();
                pl.setState(SocketRoute.PLAYER_MOVE);
                pl.setMove(((OnlineModeController) boardController).convertMoveToStirng(i, j));
                pl.setOpponentName(((OnlineModeController) boardController).opponentName);
                System.out.println(((OnlineModeController) boardController).opponentName);
                try {
                    PlayerDataHandler.getInstance().sendMessage(pl, CustomDialogBase::onPrintComplete);
                    boardController.isThisIsCurrentPlayerTurn = false;
                } catch (InstantiationException ex) {
                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                }

                actionWhenGetBoardState();

            } else if (boardController instanceof SinglePlayerModeController) {

                doButtonActionOnSinglePlayerMode(i, j);
                actionWhenGetBoardState();

            } else {
                boardController.setMove(i, j);
                resetBoardBaseOnSimulationBoard();
                actionWhenGetBoardState();
            }
        }

    }

    private void doButtonActionOnSinglePlayerMode(int i, int j)
    {
        if (!isTransitionStarted) {
            isTransitionStarted = true;
            if (boardController.isThisIsCurrentPlayerTurn) {
                boardController.setMove(i, j);
                resetBoardBaseOnSimulationBoard();
                boardController.isThisIsCurrentPlayerTurn = false;
            }
            if (boardController.getBoardState(boardController.getSimulationBoard()) == -1) {
                PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
                pause.setOnFinished(e -> {
                    ((SinglePlayerModeController) boardController).doComputerMove();
                    resetBoardBaseOnSimulationBoard();
                    actionWhenGetBoardState();
                    boardController.isThisIsCurrentPlayerTurn = true;
                    isTransitionStarted = false;
                });
                pause.play();
            }
        }

    }

    public void actionWhenGetBoardState()
    {
        int result = boardController.getBoardState(boardController.getSimulationBoard());

        if (boardController.isGameInProgress) {
            switch (result) {
                case 0:
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

    void doStuffOnGetResult(int winner)
    {
        btnSaveMatch.setDisable(true);
        boardController.isGameInProgress = false;
        String winnerName = "";
        String url = "videos/draw.mp4";
        if (winner == 0) {
            winnerName = boardController.playerOOName;
            boardController.playerOOWins++;
            url = "videos/o_beats_x.mp4";
        } else if (winner == 1) {
            winnerName = boardController.playerXXName;
            boardController.playerXXWins++;
            url = "videos/x_beats_o.mp4";
        }
        winnerName = winnerName.substring(4);
//        System.out.println("------------------------------------------> going to work");
//        System.out.println("winner name: " + winnerName + ", current user: " + PlayerDataHandler.player.getUsername());
        if(winnerName.equals(PlayerDataHandler.player.getUsername())){
            ((OnlineModeController) boardController).countWin(winnerName);
        } 
        boardController.roundsNumber++;

        if (!((OnlineModeController) boardController).opponentLeft) {
            btnRematch.setDisable(false);
        }

        updateUIAfterWin();

        tictactoe.domain.MusicController.pauseMusic();
        ScreenController.pushScreen(new VideoFXMLBase(url, 10), this);
        if (saveTheMatch) {
            boardController.saveMatch(modeName, winner);
        }

    }

    private void updateUIAfterWin()
    {
        playerXXWinsText
            .setText("Wins : " + String.valueOf(boardController.playerXXWins));
        playerOOWinsText
            .setText("Wins : " + String.valueOf(boardController.playerOOWins));

        int rounds = boardController.roundsNumber;

        roundNumberText.setText("Round : " + String.valueOf(rounds));

    }

    public void resetBoardBaseOnSimulationBoard()
    {
        char[][] simulationBoard = boardController.getSimulationBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setOpacityBasedOnIndex(simulationBoard[i][j], i, j, 1);
            }
        }

    }

    private void setOpacityBasedOnIndex(char symbol, int i, int j, double opacity)
    {

        /// set if X
        if (i == 0 && j == 0 && symbol == 'x') {
            x00.setOpacity(opacity);
            o00.setOpacity(0);
        }
        if (i == 0 && j == 1 && symbol == 'x') {
            x01.setOpacity(opacity);
            o01.setOpacity(0);
        }
        if (i == 0 && j == 2 && symbol == 'x') {
            x02.setOpacity(opacity);
            o02.setOpacity(0);
        }
        if (i == 1 && j == 0 && symbol == 'x') {
            x10.setOpacity(opacity);
            o10.setOpacity(0);
        }
        if (i == 1 && j == 1 && symbol == 'x') {
            x11.setOpacity(opacity);
            o11.setOpacity(0);
        }
        if (i == 1 && j == 2 && symbol == 'x') {
            x12.setOpacity(opacity);
            o12.setOpacity(0);
        }
        if (i == 2 && j == 0 && symbol == 'x') {
            x20.setOpacity(opacity);
            o20.setOpacity(0);
        }
        if (i == 2 && j == 1 && symbol == 'x') {
            x21.setOpacity(opacity);
            o21.setOpacity(0);
        }
        if (i == 2 && j == 2 && symbol == 'x') {
            x22.setOpacity(opacity);
            o22.setOpacity(0);
        }

        /// set if O
        if (i == 0 && j == 0 && symbol == 'o') {
            x00.setOpacity(0);
            o00.setOpacity(opacity);
        }
        if (i == 0 && j == 1 && symbol == 'o') {
            x01.setOpacity(0);
            o01.setOpacity(opacity);
        }
        if (i == 0 && j == 2 && symbol == 'o') {
            x02.setOpacity(0);
            o02.setOpacity(opacity);
        }
        if (i == 1 && j == 0 && symbol == 'o') {
            x10.setOpacity(0);
            o10.setOpacity(opacity);
        }
        if (i == 1 && j == 1 && symbol == 'o') {
            x11.setOpacity(0);
            o11.setOpacity(opacity);
        }
        if (i == 1 && j == 2 && symbol == 'o') {
            x12.setOpacity(0);
            o12.setOpacity(opacity);
        }
        if (i == 2 && j == 0 && symbol == 'o') {
            x20.setOpacity(0);
            o20.setOpacity(opacity);
        }
        if (i == 2 && j == 1 && symbol == 'o') {
            x21.setOpacity(0);
            o21.setOpacity(opacity);
        }
        if (i == 2 && j == 2 && symbol == 'o') {
            x22.setOpacity(0);
            o22.setOpacity(opacity);
        }

        /// set if Dot
        if (i == 0 && j == 0 && symbol == '.') {
            x00.setOpacity(0);
            o00.setOpacity(0);
        }
        if (i == 0 && j == 1 && symbol == '.') {
            x01.setOpacity(0);
            o01.setOpacity(0);
        }
        if (i == 0 && j == 2 && symbol == '.') {
            x02.setOpacity(0);
            o02.setOpacity(0);
        }
        if (i == 1 && j == 0 && symbol == '.') {
            x10.setOpacity(0);
            o10.setOpacity(0);
        }
        if (i == 1 && j == 1 && symbol == '.') {
            x11.setOpacity(0);
            o11.setOpacity(0);
        }
        if (i == 1 && j == 2 && symbol == '.') {
            x12.setOpacity(0);
            o12.setOpacity(0);
        }
        if (i == 2 && j == 0 && symbol == '.') {
            x20.setOpacity(0);
            o20.setOpacity(0);
        }
        if (i == 2 && j == 1 && symbol == '.') {
            x21.setOpacity(0);
            o21.setOpacity(0);
        }
        if (i == 2 && j == 2 && symbol == '.') {
            x22.setOpacity(0);
            o22.setOpacity(0);
        }

    }

    public void resetSaveMatchBtn()
    {
        btnSaveMatch.setStyle("-fx-background-color: #D38CC4;");
        btnSaveMatch.setText("Save Match");
        saveTheMatch = false;
        btnSaveMatch.setDisable(false);
    }

    private void playMatchFromHistory()
    {
        String[] movesFromFile = boardController.getMoves().split(",");
        playerXXNameText.setText(movesFromFile[0]);
        playerOONameText.setText(movesFromFile[1]);
        roundNumberText.setText("Round : " + movesFromFile[2]);
        playerXXWinsText.setText("Wins : " + movesFromFile[3]);
        playerOOWinsText.setText("Wins : " + movesFromFile[4]);

        replayThread = new Thread(() -> {

            char player;
            for (int k = 5; k < movesFromFile.length; k++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
                int i = Integer.valueOf(movesFromFile[k].charAt(0)) - '0';
                int j = Integer.valueOf(movesFromFile[k].charAt(1)) - '0';
                if (k % 2 == 1) {
                    player = 'x';
                } else {
                    player = 'o';
                }

                setOpacityBasedOnIndex(player, i, j, 1);
            }
        });
        replayThread.start();
        TicTacToe.primaryStage.setOnCloseRequest((e) -> {
            replayThread.stop();
        });
    }

//    void doOnlineMove()
//    {
//        Thread myTh = new Thread(()->{
//            while (true) {                
//                try {
//                    String str = SocketConnectionController.getInstance().getPlayerDataHandler().recieveMessage();
//                    PlayerMessageBody pl = JSONParser.convertFromJSONToPlayerMessageBody(str);
//                    switch(pl.getState())
//                    { 
//                        case PLAYER_MOVE:
//                        {
//                            System.out.println("move received.");
//                            int i = Integer.valueOf(pl.getMove().charAt(0))-'0';
//                            int j = Integer.valueOf(pl.getMove().charAt(1))-'0';
//                            ((OnlineModeController)boardController).setMoveToOnline(i, j,!((OnlineModeController)boardController).currentPlayerSymbol);
//                            resetBoardBaseOnSimulationBoard();
//                            actionWhenGetBoardState();
//                            boardController.isThisIsCurrentPlayerTurn = true;
//                            break;
//                        }
//                    }
//                } catch (InstantiationException ex) {
//                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(GamePlayBoard.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        
//        Platform.runLater(() -> {
//            myTh.start();
//        });
//    }
}
