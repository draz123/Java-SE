/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primary;

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

/**
 *
 * @author Albert
 */
public class Serialize {
    static XStream xstream=new XStream(new DomDriver());
    static ObjectOutputStream out;
    static ObjectInputStream in;
    
    public static void serializeXML(MyMap map,String location){
            xstream.alias("way", MyWay.class);
            xstream.alias("node", MyVertex.class);
            try{
                out = xstream.createObjectOutputStream(new FileOutputStream(location));
                out.writeObject(map.getWays());
                out.close();
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
            in = xstream.createObjectInputStream(new FileInputStream(location));            
            tmp=((LinkedList<MyWay>)in.readObject());
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File doesn't exist!");
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }            
        return tmp;
    }
    
    public static void serializeFile(String location,MyMap map){             
        try {
            out = new ObjectOutputStream(new FileOutputStream(location));
            out.writeObject(map);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Type file name!");
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null,"Type file name!");
        }
    }
    
    public static MyMap deserializeFile(String location){
        MyMap map=new MyMap();
        try {
            in = new ObjectInputStream(new FileInputStream(location));
            map=(MyMap)in.readObject();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File doesn't exist!");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
}
