/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.data;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.domain.ConnectionInterface;
import tictactoe.domain.PlayerDataHandler;

/**
 *
 * @author Shyasuo
 */
public class SocketConnectionController implements ConnectionInterface{
    
    private Socket createdSocket;
    private int port;
    private String addr;
  
    //Singleton instance of SocketConnectionController
    private static SocketConnectionController instance;  
    
    public static boolean isInitialized(){
        return !(instance == null);
    }
    private static void setInstance(SocketConnectionController instance)
    {
        SocketConnectionController.instance = instance;
    }
    public static SocketConnectionController getInstance() throws InstantiationException{
        if(instance == null) throw new InstantiationError("An instance was not yet created, Create an instance by calling initialize first.");
        return instance;
    }
    //The PlayerDataHandler thread
    private Thread playerDataHandlerTh;
     
    /**
     * Creates a server withe the specified local IP address, and port.
     * @param serverAddr the server address (should be your device's local IP address)
     * @param port the port number
     * @return a created instance of running server
     * @throws IllegalArgumentException if server address or port number were invalid
     * @throws java.net.SocketTimeoutException if server takes too long to respond
     * @throws IOException if an exception occurs while trying to communicate or receive data from client (Player)
     * @throws java.net.ConnectException
     */
    public static SocketConnectionController initialize(String serverAddr, int port) throws IllegalArgumentException, SocketTimeoutException, IOException, ConnectException{
        
        if(instance == null){try {
            //basically restarts the server with different parameters
            instance = new SocketConnectionController(serverAddr, port);
            } catch (InstantiationException ex) {
                Logger.getLogger(SocketConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return instance;
    }
    
    /**
     * Creates a server withe the specified local IP address, and an ephemeral port.
     * the ephemeral port value can be retrieved by calling the getter getPort on the newly created server instance.
     * @param serverAddr the server address (should be your device's local IP address)
     * @return a created instance of running server
     * @throws IllegalArgumentException if server address or port number were invalid
     * @throws IOException if an exception occurs while trying to communicate or receive data from client (Player)
     * @throws java.net.SocketTimeoutException if server takes too long to respond
     * @throws java.net.ConnectException
     */
    public static SocketConnectionController initialize(String serverAddr) throws IllegalArgumentException, IOException, SocketTimeoutException, ConnectException{
        
        if(instance == null){try {
            //basically restarts the server with different parameters
            instance = new SocketConnectionController(serverAddr, 5005);
            } catch (InstantiationException ex) {
                Logger.getLogger(SocketConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
    
    private SocketConnectionController(String addr, int port) throws UnknownHostException, IllegalArgumentException, SocketTimeoutException, InstantiationException, IOException, ConnectException{
            if(addr.equals("localhost"))
                addr = "127.0.0.1";
            else if(addr.split("[.]").length != 4) throw new IllegalArgumentException("invalid IP address");
            this.addr = addr;
            if (port < 0 || port > 0xFFFF) throw new IllegalArgumentException("Invalid port value");
            createdSocket = new Socket();
            createdSocket.connect(new InetSocketAddress(addr, port), 2000);
//            createdSocket.setSoTimeout(5000);
            this.port = createdSocket.getLocalPort();
            PlayerDataHandler.setInstance(new PlayerDataHandler(createdSocket));
            playerDataHandlerTh = new Thread(PlayerDataHandler.getInstance());
            playerDataHandlerTh.start();
    }
    
    //instance getters and setters
    public int getPort()
    {
        return port;
    }
    public String getAddr()
    {
        return addr;
    }
    
    
    private void close() throws IOException
    {
        //NOTE: this should throw an exception because the thread will be waiting for a player to connect
        createdSocket.close();
        playerDataHandlerTh.stop();
        PlayerDataHandler.setInstance(null);
        playerDataHandlerTh = null;
        SocketConnectionController.setInstance(null);
    }

    @Override
    public void connectToServer(String ip) throws UnknownHostException, IllegalArgumentException, IOException, SocketTimeoutException, ConnectException
    {
         initialize(ip);
    }

    @Override
    public void connectToServer(String playerIp, int playerPort) throws UnknownHostException, IllegalArgumentException, IOException, ConnectException, SocketTimeoutException
    {
        initialize(playerIp, playerPort);
    }
    
    @Override
    public void disconnectFromServer() throws IOException, ConnectException
    {
        close();
    }

}
