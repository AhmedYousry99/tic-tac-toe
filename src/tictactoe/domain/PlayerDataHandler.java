/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Shyasuo
 */
public class PlayerDataHandler extends Thread{
    
    protected BufferedReader bufferedReader;
    protected OutputStreamWriter outputStreamWriter;
    //data to be sent
    protected String msg;
    
    public PlayerDataHandler(Socket socket) throws IOException{
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());  
    }
    
    
    public boolean sendMessage(String msg) throws IOException{
        boolean success = true;
            outputStreamWriter.write(msg);
        return success;
    }
    public boolean recieveMessage() throws IOException{
        boolean success = true;
        String msg = bufferedReader.readLine();
        System.out.println(msg);
        return success;
    }

    @Override
    public void run()
    {
        super.run();
        try {
            recieveMessage();
        } catch (IOException ex) {
            Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
