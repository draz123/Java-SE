/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishdictionary;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 *
 * @author Albert
 */
public class Window extends javax.swing.JFrame {      
   
    private final Random rand;
    private String answer;
    private DictHandler dictHandler;
    /**
     * Creates new form Window
     */
    public Window()  {
        dictHandler=new DictHandler();
        rand=new Random();
        initComponents();       
        initKey();    
    }
    public void checkAction(){
    String tmp=input.getText();
        input.setText("");
        int toDelete=-1;
        boolean Check=false;
        if(dictHandler.getDict().size()==0){
            output.setText("No more words");
            return;
        }
        else{
              output.setText("");      
        }
        for(int i=0;i<dictHandler.getDict().size();i++){
            if(tmp.equalsIgnoreCase(dictHandler.getDict().get(i).getEnglish())){
                Check=true;
                toDelete=i;
            }
        }
        if(Check){
            output.setText("Good job");
            dictHandler.getDict().remove(toDelete);           
        }
        else{
            output.setText(answer);
        }        
        check.setText("");
        if(dictHandler.getDict().size()!=0){
            startQuiz();
        }
    }                                        

    
    private void initKey(){
        System.out.println("Heeeeeeeeeeeeeeeere");
        InputMap im = checkBut.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
        setTitle("Quiz");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getRootPane().setDefaultButton(checkBut);
        input.requestFocus();
    }
    
    public void startQuiz(){       
        int randomNum = rand.nextInt(dictHandler.getDict().size() );   
        check.setText(dictHandler.getDict().get(randomNum).getPolish());
        answer=dictHandler.getDict().get(randomNum).getPolish()+" - " +dictHandler.getDict().get(randomNum).getEnglish();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBut = new javax.swing.JButton();
        input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        reloadBut = new javax.swing.JButton();
        addBaseBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        check = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        checkBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        checkBut.setText("Check!");
        checkBut.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        checkBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButActionPerformed(evt);
            }
        });
        checkBut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                checkButKeyPressed(evt);
            }
        });

        input.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        input.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        jLabel1.setText("Word competition!");

        reloadBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        reloadBut.setText("Reload");
        reloadBut.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        reloadBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButActionPerformed(evt);
            }
        });

        addBaseBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        addBaseBut.setText("Add database");
        addBaseBut.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        addBaseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBaseButActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        output.setEditable(false);
        output.setColumns(20);
        output.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        output.setLineWrap(true);
        output.setRows(5);
        output.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane1.setViewportView(output);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        check.setEditable(false);
        check.setColumns(20);
        check.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        check.setLineWrap(true);
        check.setRows(5);
        check.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane2.setViewportView(check);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkBut, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)
                                .addComponent(reloadBut, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(addBaseBut)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBut)
                    .addComponent(reloadBut)
                    .addComponent(addBaseBut))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButActionPerformed
        checkAction();
    }//GEN-LAST:event_checkButActionPerformed

    private void reloadButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButActionPerformed
        try {
            dictHandler.readFile(null);
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reloadButActionPerformed
  
    private void addBaseButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBaseButActionPerformed
            dictHandler.addDatabase(this);
            startQuiz();

    }//GEN-LAST:event_addBaseButActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed

    }//GEN-LAST:event_inputActionPerformed

    private void checkButKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkButKeyPressed
        checkAction();
    }//GEN-LAST:event_checkButKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBaseBut;
    private javax.swing.JTextArea check;
    private javax.swing.JButton checkBut;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    private javax.swing.JButton reloadBut;
    // End of variables declaration//GEN-END:variables
}
