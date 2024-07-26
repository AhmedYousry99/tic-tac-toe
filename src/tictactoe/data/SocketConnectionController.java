/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.data;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
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
    private PlayerDataHandler playerDataHandler;
    private int port;
    private String addr;
  
    //Singleton instance of server
    private static SocketConnectionController instance;

    private static void setInstance(SocketConnectionController instance)
    {
        SocketConnectionController.instance = instance;
    }
    
    /**
     * Creates a server withe the specified local IP address, and port.
     * @param serverAddr the server address (should be your device's local IP address)
     * @param port the port number
     * @return a created instance of running server
     * @throws IllegalArgumentException if server address or port number were invalid
     * @throws IOException if an exception occurs while trying to communicate or receive data from client (Player)
     */
    private static SocketConnectionController initialize(String serverAddr, int port) throws IllegalArgumentException, IOException{
        
        if(instance != null){//basically restarts the server with different parameters
            instance.close();
        }
        instance = new SocketConnectionController(serverAddr, port);
        return instance;
    }
    
    /**
     * Creates a server withe the specified local IP address, and an ephemeral port.
     * the ephemeral port value can be retrieved by calling the getter getPort on the newly created server instance.
     * @param serverAddr the server address (should be your device's local IP address)
     * @return a created instance of running server
     * @throws IllegalArgumentException if server address or port number were invalid
     * @throws IOException if an exception occurs while trying to communicate or receive data from client (Player)
     */
    private static SocketConnectionController initialize(String serverAddr) throws IllegalArgumentException, IOException{
        
        if(instance != null){//basically restarts the server with different parameters
            instance.close();
        }
        instance = new SocketConnectionController(serverAddr, 0);
        return instance;
    }
    
    private static SocketConnectionController getInstance() throws InstantiationException{
        if(instance == null) throw new InstantiationError("An instance was not yet created, Create an instance by calling initialize first.");
        return instance;
    }

    public int getPort()
    {
        return port;
    }

    public String getAddr()
    {
        return addr;
    }
    
    
    private SocketConnectionController(String addr, int port) throws UnknownHostException, IllegalArgumentException{
        try {
            if(addr.split(addr).length != 4) throw new IllegalArgumentException("invalid IP address");
            this.addr = addr;
            if (port < 0 || port > 0xFFFF) throw new IllegalArgumentException("Invalid port value");
            createdSocket = new Socket(InetAddress.getByName(this.addr), port);
            this.port = createdSocket.getLocalPort();
        } catch (IOException ex) {
            Logger.getLogger(SocketConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void close() throws IOException
    {
        //NOTE: this should throw an exception because the thread will be waiiting for a player to connect
        createdSocket.close();
        // TODO: resources cleaning functionality of player handler
        SocketConnectionController.setInstance(null);
    }

    @Override
    public boolean connectToServer(String ip) throws UnknownHostException, IllegalArgumentException
    {
        boolean successful = true;
        try {
            initialize(ip);
        }catch (IOException ex) {
            Logger.getLogger(SocketConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            successful = false;
        }
        return successful;
    }

    @Override
    public boolean connectToServer(String playerIp, int playerPort) throws UnknownHostException, IllegalArgumentException
    {
       boolean successful = false;
            try {
            initialize(playerIp, playerPort);
        }catch (IOException ex) {
            Logger.getLogger(SocketConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            successful = false;
        }
       return successful;
    }
    
    @Override
    public boolean disconnectFromServer()
    {
        boolean successful = false;
        
        return successful;
    }


    
}
