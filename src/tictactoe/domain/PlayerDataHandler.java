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
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    public boolean sendMessage(String msg){
        printStream.println(msg);
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
            } catch (IOException ex) {
                Logger.getLogger(PlayerDataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
