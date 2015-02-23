package englishdictionary;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 * This class draw window on screen
 *
 * @author Albert Podraza
 */
public class Window extends javax.swing.JFrame {      
   
    private final Random rand;
    private String answer;
    private final DictHandler dictHandler;
    
    /**
     * Default constructor, there is initialization of winow and all it's 
     * elements.
     */
    public Window()  {
        dictHandler=new DictHandler();
        rand=new Random();
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        initKey();    
    }
    
    /**
     * Method checks, when dictionary's list is empty and inform user, when it
     * occurs.
     */
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
    
    /**
     * Sets the enter key, as the check button
     */
    private void initKey(){
        InputMap im = input.getInputMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
        getRootPane().setDefaultButton(checkBut);
        input.requestFocus();
    }
    
    /**
     * Drawing words, which translation we have to write
     */
    public void startQuiz(){       
        int randomNum = rand.nextInt(dictHandler.getDict().size() );   
        check.setText(dictHandler.getDict().get(randomNum).getPolish());
        answer=dictHandler.getDict().get(randomNum).getPolish()+" - " +dictHandler.getDict().get(randomNum).getEnglish();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBut = new javax.swing.JButton();
        input = new javax.swing.JTextField();
        reloadBut = new javax.swing.JButton();
        addBaseBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        check = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("English words");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkBut.setBackground(new java.awt.Color(212, 207, 207));
        checkBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        checkBut.setText("Check");
        checkBut.setBorder(null);
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
        getContentPane().add(checkBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 30));

        input.setBackground(new java.awt.Color(212, 207, 207));
        input.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 30)); // NOI18N
        input.setBorder(null);
        input.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        getContentPane().add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 394, 50));

        reloadBut.setBackground(new java.awt.Color(212, 207, 207));
        reloadBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        reloadBut.setText("Reload");
        reloadBut.setBorder(null);
        reloadBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButActionPerformed(evt);
            }
        });
        getContentPane().add(reloadBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 110, 30));

        addBaseBut.setBackground(new java.awt.Color(212, 207, 207));
        addBaseBut.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        addBaseBut.setText("Add database");
        addBaseBut.setBorder(null);
        addBaseBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBaseButActionPerformed(evt);
            }
        });
        getContentPane().add(addBaseBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 150, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        output.setEditable(false);
        output.setBackground(new java.awt.Color(212, 207, 207));
        output.setColumns(20);
        output.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        output.setLineWrap(true);
        output.setRows(5);
        output.setBorder(null);
        output.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane1.setViewportView(output);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 480, 189));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        check.setEditable(false);
        check.setBackground(new java.awt.Color(212, 207, 207));
        check.setColumns(20);
        check.setFont(new java.awt.Font("Adobe Garamond Pro", 0, 24)); // NOI18N
        check.setLineWrap(true);
        check.setRows(5);
        check.setBorder(null);
        check.setMargin(new java.awt.Insets(6, 6, 6, 6));
        jScrollPane2.setViewportView(check);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 394, 128));

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Albert\\Documents\\NetBeansProjects\\EnglishDictionary\\Bez nazwy-1.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 290));

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea output;
    private javax.swing.JButton reloadBut;
    // End of variables declaration//GEN-END:variables
}
