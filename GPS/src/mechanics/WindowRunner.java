/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import GUI.Window;

/**
 *
 * @author Albert
 */
public class WindowRunner {
    public static void startProgram(){
                    java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Window().setVisible(true);
                }
            });
    }
}
