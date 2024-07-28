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
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.CustomDialogSuccess;
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
        String newMessage =JSONParser.convertFromPlayerMessageBodyToJSON(msg);
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
                PlayerMessageBody pl =JSONParser.convertFromJSONToPlayerMessageBody(msg);
               switch(pl.getState())
               {
                   case LOG_IN_RESPONSE:
                   {
                     
                   }    
               }
            } catch (IOException ex) {
                Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   public void getLoginResponse(boolean response)
   {
       if(response)
       { 
          CustomDialogSuccess cds = new CustomDialogSuccess("Login successful","Okay",  () -> {
                
            });
       }
       else {
           CustomDialogBase cdb = new CustomDialogBase("Invalid username or password","Okay","Cancel",() -> {
                
            },() -> {
                ScreenController.popScreen();
            });
       }
      
    }
  
    
}
