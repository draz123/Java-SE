package webComunication;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import mechanics.MyWay;
 
public class Client {
   public static  void newClient(LinkedList<MyWay> ways) throws IOException  {
 
        Socket echoSocket = null;
                
        try {
            echoSocket = new Socket("192.168.0.21", 6666);          
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Server is not working!");
            System.exit(1);
        }
        
      ObjectOutputStream outToServer = new ObjectOutputStream(echoSocket.getOutputStream());

   
        outToServer.writeObject(ways);
        outToServer.close();
        echoSocket.close();
    }
}