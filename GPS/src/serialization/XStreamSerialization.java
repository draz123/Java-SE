/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mechanics.MyMap;
import mechanics.MyVertex;
import mechanics.MyWay;
import GUI.Window;

/**
 *
 * @author Albert
 */
public class XStreamSerialization {
    static XStream xstream=new XStream(new DomDriver());
    
    public static void serializeXML(MyMap map,String location){
            xstream.alias("way", MyWay.class);
            xstream.alias("node", MyVertex.class);
            try{
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileOutputStream(location));
            out.writeObject(map.getWays());
            out.close();
            System.out.println("Saving done!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Type file name!");
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static LinkedList<MyWay> deserializeXML(MyMap map,String location){
        LinkedList<MyWay> tmp=new LinkedList<MyWay>();
        try {
            xstream.alias("way", MyWay.class);
            xstream.alias("node", MyVertex.class);    
            ObjectInputStream in = xstream.createObjectInputStream(new FileInputStream(location));            
            tmp=((LinkedList<MyWay>)in.readObject());
            System.out.println("Reading done!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File doesn't exist!");
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return tmp;
    }
    
}
