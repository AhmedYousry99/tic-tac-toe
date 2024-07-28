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
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.ui.util.VoidCallableParameterizedPMB;

/**
 *
 * @author Shyasuo
 */
public class PlayerDataHandler implements Runnable{
    
    protected BufferedReader bufferedReader;
    protected PrintStream printStream;
    //data to be sent
    protected String msg;
    protected SocketRoute expectedRoute;
    private boolean run;
    protected VoidCallableParameterizedPMB vcppmb;

    public VoidCallableParameterizedPMB getVcppmb()
    {
        return vcppmb;
    }

    public void setVcppmb(VoidCallableParameterizedPMB vcppmb)
    {
        this.vcppmb = vcppmb;
    }

    public String getMsg()
    {
        return msg;
    }
    
    private int tick;
    
    public PlayerDataHandler(Socket socket) throws IOException{
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream());
        expectedRoute = SocketRoute.ALL_PLAYERS;
        tick = 0;
    }
    
    
    public boolean sendMessage(PlayerMessageBody msg, SocketRoute response) throws JsonProcessingException{
        String newMessage = JSONParser.convertFromPlayerMessageBodyToJSON(msg);
        expectedRoute = response;
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
        run = true;
        while(run){
            try {
            System.out.println("going to await message");
            String msg = recieveMessage();
            PlayerMessageBody pl = JSONParser.convertFromJSONToPlayerMessageBody(msg);
            if(pl.getState() == expectedRoute){
                vcppmb.call(pl);
                System.out.println("message gotten");
                run = false;
            }
            } catch (IOException ex) {
                Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex);
             PlayerMessageBody pl = new PlayerMessageBody();
             pl.setState(SocketRoute.ERROR_OCCURED);
             pl.setMessage(ex.getMessage());
             run = false;
             vcppmb.call(pl);
            }
        }
        
    }
//    private void getAllPlayers(PlayerMessageBody pl)
//    {
//        String msg;
//        try{
//             try {
//                pl.setPlayers(DBAccess.getAllPlayers());
//            } catch (SQLException ex) {
//                pl.setMessage("Couldn't get all players at the moment , please try again");
//                pl.setState(SocketRoute.ERROR_OCCURED);
//                Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//             msg = JSONParser.convertFromPlayerMessageBodyToJSON(pl);
//             printStream.println(msg);
//        }catch (JsonProcessingException ex) {
//            Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//    }
    
}
