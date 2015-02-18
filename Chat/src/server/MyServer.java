
package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyServer extends Thread{
    private ServerSocket ss;
    private final Hashtable outputStreams = new Hashtable();
    private final int port;
    
    public MyServer(int port) throws IOException {
        this.port=port;
        start();     
    }
    
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


