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
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.ui.util.ScreenController;

/**
 *
 * @author Shyasuo
 */
public class PlayerDataHandler extends Thread{
    
    protected BufferedReader bufferedReader;
    protected PrintStream printStream;
    //data to be sent
    protected String msg;

    public String getMsg()
    {
        return msg;
    }
    
    private int tick;
    
    public PlayerDataHandler(Socket socket) throws IOException{
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream());
        tick = 0;
    }
    
    
    public boolean sendMessage(PlayerMessageBody msg) throws JsonProcessingException{
        String newMessage = JSONParser.convertFromPlayerMessageBodyToJSON(msg);
        printStream.println(newMessage);
        return printStream.checkError();
    }
    
    protected String recieveMessage() throws IOException{
        String msg = null;
        msg = bufferedReader.readLine();
        System.out.println(msg);
        return msg;
    }

    @Override
    public void run()
    {
        super.run();
        while(true){
            try {
                String msg = recieveMessage();
                PlayerMessageBody pl = JSONParser.convertFromJSONToPlayerMessageBody(msg);
                switch(pl.getState())
                {
                    case LOG_IN:
                        break;
                    case SIGN_UP:
                        break;
                    case SIGN_UP_RESPONSE:
                        break;
                    case PLAYER_MOVE:
                        break;
                    case REQUEST_TO_PLAY:
                        break;
                    case RESPONSE_TO_REQUEST_TO_PLAY:
                        break;
                    case DIALOG_REQUEST_TO_PLAY:
                        break;
                    case WAITING_REQUEST_TO_PLAY:
                        break;
                    case SCORE_BOARD:
                        break;
                    case CHECK_SERVER:
                        break;
                    default:
                        throw new AssertionError(pl.getState().name());
                }
            } catch (IOException ex) {
                Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
