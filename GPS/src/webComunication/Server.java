package webComunication;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mechanics.MyMap;
import mechanics.MyWay;
 
public class Server implements Runnable {


    @Override
    public void run() {
        System.out.println("SERVER WORKING...");
         ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
 
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        
        try {
            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream()); 
            LinkedList<MyWay> m=(LinkedList<MyWay>)inFromClient.readObject(); 
            MyMap.setNewGraph(m);
            clientSocket.close();
            serverSocket.close();
            inFromClient.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}