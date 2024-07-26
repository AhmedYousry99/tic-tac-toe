/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import org.json.JSONObject;

/**
 *
 * @author Shyasuo
 */
public interface ConnectionInterface{
    
    public abstract boolean connectToServer(String ip) throws UnknownHostException, IOException;
    public abstract  boolean connectToServer(String ip, int port) throws UnknownHostException, IOException;
    public abstract  boolean disconnectFromServer();
//    public boolean checkConnection();
    
}
