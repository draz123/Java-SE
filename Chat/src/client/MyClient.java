/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Albert
 */
public  class MyClient extends javax.swing.JFrame implements Runnable {
    
    private Color color;
    private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    private String nickname;
    private int posX=0,posY=0;
    
    public MyClient(String host, int port) {        
        initComponents();
        color=new Color(153, 222, 145);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        makeDrag();
        connect(host,port);                    
    }
    
        private void makeDrag(){
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
                posX=e.getX();
                posY=e.getY();
            }
        });
            this.addMouseMotionListener(new MouseAdapter()
        {
         public void mouseDragged(MouseEvent evt)
         {			
            setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
         }
        });
    }
    
    private void connect(String host, int port){
        try {
            socket = new Socket( host, port );
            din = new DataInputStream( socket.getInputStream() );
            dout = new DataOutputStream( socket.getOutputStream() );
            nickname="guest"+socket.getLocalPort();
            welcomeEverybody("New guest on chat: "+nickname);
            setTitle(nickname);
            new Thread( this ).start();
        } catch( IOException ie ) { System.out.println( ie ); }
    }
    
    void setOutput(String message){
        outputWindow.append( message+"\n" );
    }
    
    private void processMessage( String message ) {
        try {
            dout.writeUTF( nickname+": "+message );
            inputWindow.setText( "" );
        } catch( IOException ie ) { System.out.println( ie ); }
    }
    
     private void welcomeEverybody( String message ) {
        try {
            dout.writeUTF(nickname);
            dout.writeUTF(message);
            outputWindow.append("Connected to chat\n");
        } catch( IOException ie ) { System.out.println( ie ); }
    }
     

    
    private void someoneChangedNick(String oldNickname) {
        try {
            System.out.println("User "+oldNickname+" changed his nickname to "+nickname);
            dout.writeUTF("1");
            dout.writeUTF(nickname);
            dout.writeUTF( "User "+oldNickname+" changed his nickname to "+nickname);
            setTitle(nickname);
        } catch( IOException ie ) { System.out.println( ie ); }
    } 
     
        @Override
    public void run() {
        try {                     
            while (true) {
                String message = din.readUTF();
                if(!message.equals("New guest on chat: "+nickname)){
                    outputWindow.append( message+"\n" );
                }
                outputWindow.setCaretPosition(outputWindow.getDocument().getLength());
            }
        } catch( IOException ie ) { System.out.println( ie ); 
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputWindow = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputWindow.setBorder(null);
        inputWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputWindowActionPerformed(evt);
            }
        });
        getContentPane().add(inputWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 20));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        outputWindow.setColumns(20);
        outputWindow.setRows(5);
        jScrollPane1.setViewportView(outputWindow);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 120));

        jButton1.setFont(new java.awt.Font("Impact", 0, 11)); // NOI18N
        jButton1.setText("Change nickname");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 38, 120, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeButton1.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/message.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 291, 293));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputWindowActionPerformed
         processMessage(evt.getActionCommand());
    }//GEN-LAST:event_inputWindowActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String oldNickname=nickname;
        nickname=(String)JOptionPane.showInputDialog(this, "Type your nickname","Customized Dialog",JOptionPane.PLAIN_MESSAGE, null,null,"");
        if(nickname.length()>1){
            someoneChangedNick(oldNickname);
        }
        else{
            showMessageDialog(this, "You didn't enter any nick.");
            nickname=oldNickname;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setForeground(color);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        jButton1.setForeground(Color.black); 
    }//GEN-LAST:event_jButton1MouseReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            this.dispose();
            dout.writeUTF( nickname+" disconnected from chat ");
        
                    dout.close();
                    din.close();
                    socket.close();
                    } catch (IOException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeButton2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeButton1.png")));
    }//GEN-LAST:event_jLabel2MouseExited
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputWindow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputWindow;
    // End of variables declaration//GEN-END:variables
     

}
