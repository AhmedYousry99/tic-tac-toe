/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import tictactoe.data.SocketConnectionController;
import tictactoe.ui.ConnectionModeScreenBase;
import tictactoe.ui.GamePlayBoard;
import tictactoe.ui.LoginScreenController;
import tictactoe.ui.OnlineModeController;
import tictactoe.ui.PlayerScreenController;
import tictactoe.ui.PlayersScreenBase;
import static tictactoe.ui.PlayersScreenBase.gamePlayBoard;
import static tictactoe.ui.PlayersScreenBase.onlineModeController;
import tictactoe.ui.ScoreboardController;
import tictactoe.ui.SignupScreenController;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.PrintCallback;
import tictactoe.ui.util.ScreenController;

/**
 *
 * @author Shyasuo
 */
public class PlayerDataHandler implements Runnable {

    protected BufferedReader bufferedReader;
    protected PrintStream printStream;
    //data to be sent
    protected String msg;
    private static PlayerDataHandler instance;
    public static Player player;
    public static Player opponent;

    public static PlayerDataHandler getInstance() throws InstantiationException
    {
        if (instance == null) {
            throw new InstantiationError("You didn't initiate a connection with the server yet, initiate a connection by calling SocketConnectionController's \"initialize\" function first.");
        }
        return instance;
    }

    public static void setInstance(PlayerDataHandler instance)
    {
        PlayerDataHandler.instance = instance;
    }

    public String getMsg()
    {
        return msg;
    }

    private int tick;

    public PlayerDataHandler(Socket socket) throws IOException
    {
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream());
        player = null;
        opponent = null;
        tick = 0;
    }

    public void sendMessage(PlayerMessageBody msg, PrintCallback callback) throws JsonProcessingException
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Boolean> task = () -> {
         String newMessage = JSONParser.convertFromPlayerMessageBodyToJSON(msg);
         printStream.println(newMessage);
            System.out.println("sent data");
         return !printStream.checkError();
        };
        Future<Boolean> future = executor.submit(task);
        executor.execute(() -> {
            try {
                System.out.println("Sending message and waiting 3 seconds");
                callback.onComplete(future.get(3, TimeUnit.SECONDS));
                System.out.println("Message sent successfully");
            } catch (TimeoutException e) {
                callback.onComplete(false); // Timeout occurred
            } catch (Exception e) {
                e.printStackTrace();
                callback.onComplete(false);
            } finally {
                executor.shutdown();
            }
        });
        
    }

    public String recieveMessage() throws IOException
    {
        String msg;
        msg = bufferedReader.readLine();
        if (msg == null) {
            throw new IOException("Server is down at the moment, Please try to login again.");
        }
        System.out.println(msg);
        return msg;
    }

    @Override
    public void run()
    {
        try {
            while (true) {
                System.out.println("going to await message");
                String msg = recieveMessage();
                PlayerMessageBody pl = JSONParser.convertFromJSONToPlayerMessageBody(msg);
                switch (pl.getState()) {
                    case LOG_IN:
                        break;
                    case LOG_IN_RESPONSE:
                        Platform.runLater(() -> {
                            LoginScreenController.handleLoginResponse(pl);
                        });
                        break;
                    case SIGN_UP:
                        break;
                    case SIGN_UP_RESPONSE:
                        Platform.runLater(() -> {
                            SignupScreenController.handleSignupResponse(pl);
                        });
                        break;
                    case PLAYER_MOVE:
                        playMove(pl);
                        break;

                    case LOG_OUT:
                        Platform.runLater(() -> {
                            PlayerScreenController.logOutResponse();
                        });
                        break;
                    case AVAILABLE_PLAYERS:
                    case ALL_PLAYERS:
                        Platform.runLater(() -> {
                            PlayerScreenController.playersScreenBase.
                                addPlayersToList(pl);
                        });
                        break;
                    case SURRENDER:
                        Platform.runLater(() -> {
                            OnlineModeController.handleSurrenderResponse();
                        });
                        break;
                    case REQUEST_TO_PLAY:
                        Platform.runLater(() -> {
                            handleRequestToPlay(pl);
                        });
                        break;
                    case RESPONSE_TO_REQUEST_TO_PLAY:
                        Platform.runLater(() -> {
                            handleResponseToRequestToPlay(pl);
                        });
                        break;
                    case DIALOG_REQUEST_TO_PLAY:
                        break;
                    case WAITING_REQUEST_TO_PLAY:
                        break;
                    case SCORE_BOARD:
                        if(ScoreboardController.scoreboardBase != null){
                            Platform.runLater(() -> {
                                ScoreboardController.scoreboardBase.addPlayersToList(pl);
                            });
                        }
                        break;
                    case CHECK_SERVER:
                        break;
                    case GAME_BOARD_STATE:
                        break;
                    case INITIALIZE_PLAYERS:
                        break;
                    case ERROR_OCCURED:
                        break;
                    case PLAY_AGAIN:
                        Platform.runLater(() -> {
                            playAgain(pl);
                        });
                        break;
                    case LEAVE_MATCH:
                        if(GamePlayBoard.boardController != null){
                            Platform.runLater(() -> {
                                OnlineModeController.handleLeaveResponse();
                            });
                        }
                        break;
                    default:
                        throw new AssertionError(pl.getState().name());

                }
            }
        } catch (IOException ex) {
            System.out.println("Server disconnected");
            Platform.runLater(() -> {
                new CustomDialogBase(ex.getMessage(), null, "Ok", null, () -> {
                    try {
                        SocketConnectionController.getInstance().disconnectFromServer();
                    } catch (InstantiationException | IOException ex1) {
                        Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    ScreenController.popUntil(ConnectionModeScreenBase.class);
                });
            }
            );
        }
    }

    void playMove(PlayerMessageBody pl)
    {
        System.out.println("move received.");
        int i = Integer.valueOf(pl.getMove().charAt(0)) - '0';
        int j = Integer.valueOf(pl.getMove().charAt(1)) - '0';
        onlineModeController.setMoveToOnline(i, j, !onlineModeController.currentPlayerSymbol);
        gamePlayBoard.resetBoardBaseOnSimulationBoard();
        gamePlayBoard.actionWhenGetBoardState();
        onlineModeController.isThisIsCurrentPlayerTurn = true;
    }

    private void handleRequestToPlay(PlayerMessageBody pl)
    {
        new CustomDialogBase(pl.getOpponentName() + " wants to play a match with you.",
            "Accept", "Refuse",
            () -> {
                try {
                    pl.setState(SocketRoute.RESPONSE_TO_REQUEST_TO_PLAY);
                    pl.setOpponentName(pl.getOpponentName());
                    pl.setResponse(true);
                    pl.setPlayerSymbol(false);
                    sendMessage(pl, this::handleRequestTimeout);
                    opponent = new Player(pl.getOpponentName(), null, -1, true, true);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            },
            () -> {
                try {
                    pl.setState(SocketRoute.RESPONSE_TO_REQUEST_TO_PLAY);
                    pl.setOpponentName(pl.getOpponentName());
                    pl.setResponse(false);
                    sendMessage(pl, CustomDialogBase::onPrintComplete);
  
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(PlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
    }

    private void playAgain(PlayerMessageBody pl)
    {
        if (onlineModeController.currentPlayerSymbol) {
            onlineModeController.isThisIsCurrentPlayerTurn = true;
        } else {
            onlineModeController.isThisIsCurrentPlayerTurn = false;
        }
        onlineModeController.resetBoard();
        gamePlayBoard.resetBoardBaseOnSimulationBoard();
        gamePlayBoard.resetSaveMatchBtn();
        onlineModeController.resetMatchMoves();
        gamePlayBoard.btnRematch.setDisable(true);
    }

    private void handleResponseToRequestToPlay(PlayerMessageBody pl)
    {
        System.out.println("request received.");
        if (pl.getResponse()) {
            opponent = new Player(pl.getOpponentName(), null, pl.getScore(), true, true);
            onlineModeController = new OnlineModeController(true, opponent.getUsername());
            gamePlayBoard = new GamePlayBoard(onlineModeController);
            ScreenController.pushScreen(gamePlayBoard, PlayerScreenController.playersScreenBase);
        } else {
            Platform.runLater(() -> {
                new CustomDialogBase("Request refused.", null, "Ok", null, null);
            });
        }
    }
    
    private void handleRequestTimeout(boolean success){
        if(success){
            onlineModeController = new OnlineModeController(false, opponent.getUsername());
                        gamePlayBoard = new GamePlayBoard(onlineModeController);
                        ScreenController.pushScreen(gamePlayBoard, PlayerScreenController.playersScreenBase);
        }else{
            new CustomDialogBase("Server took too long to respond, try again later", null, "Ok", null, null);
        }
    }
}