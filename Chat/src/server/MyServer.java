package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class, that creates throads, which are servers
 *
 * @author Albert Podraza
 */
public class MyServer extends Thread{
    
    private ServerSocket ss;
    private final Hashtable outputStreams = new Hashtable();
    private final int port;
    
    /**
     * Default constructor, starts start method
     * 
     * @param port specified external port
     */
    public MyServer(int port) {
        this.port=port;
        start();     
    }
    
    /**
     * 
     * @param port specified external port
     * @throws IOException when something witg input or output goes wrong
     */
    private void listen(int port) throws IOException {        
        ss=new ServerSocket( port );        
        while(true) {                   
            Socket s=ss.accept();
            System.out.println( "Connection from "+s );
            DataOutputStream dout = new DataOutputStream( s.getOutputStream() );
            outputStreams.put( s, dout );
            new ServerThread( this, s );
        }
    }
    
    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }
    
    /**
     * Sends messages to all server users
     * 
     * @param message specified message 
     */
    void sendToAll( String message ) {
        synchronized(outputStreams) {
        for (Enumeration e = getOutputStreams(); e.hasMoreElements(); ) {
            DataOutputStream dout = (DataOutputStream)e.nextElement();
            try {
                dout.writeUTF( message );
            } catch( IOException ie ) { System.out.println( ie ); }
            }
        }
    }
    
    /**
     * Disconnects user and informs others about it 
     * 
     * @param s user, who disconnected
     */
    void removeConnection( Socket s ) {
        synchronized(outputStreams) {
            System.out.println( "Removing connection to "+s );
            outputStreams.remove(s);
            try {
                s.close();
            } catch( IOException ie ) {
                System.out.println( "Error closing "+s );
                ie.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            listen(port);
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Server on port "+port+" is running"); 
    }
}


