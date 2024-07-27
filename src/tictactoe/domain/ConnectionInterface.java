/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Shyasuo
 */
public interface ConnectionInterface{
    
    public abstract void connectToServer(String ip) throws UnknownHostException, IllegalArgumentException, IOException, ConnectException;
    public abstract  void connectToServer(String ip, int port) throws UnknownHostException, IllegalArgumentException, IOException, ConnectException;
    public abstract  void disconnectFromServer() throws IOException, ConnectException;
//    public abstract void checkConnection();
    
}
