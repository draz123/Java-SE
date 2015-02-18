package server;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    private final MyServer server;
    private final Socket socket;
    private  String nickname=null;
    
    public ServerThread( MyServer server, Socket socket ) {
        this.server=server;
        this.socket=socket;
        start();
    }
    
    public void run() {
        try {
            DataInputStream din = new DataInputStream(socket.getInputStream());
            nickname=din.readUTF();
            server.sendToAll( din.readUTF() );
            while (true) {
                String message = din.readUTF();        
                if(message.equals("1")){
                    nickname=din.readUTF();
                    server.sendToAll( din.readUTF());
                }
                else{
                        server.sendToAll( message );                     
                }
            }
        } catch( EOFException ie ) {
        } catch( IOException ie ) {
            System.out.println("Connection removed");            
        } finally {           
            server.removeConnection(socket);
        }
    }
}
