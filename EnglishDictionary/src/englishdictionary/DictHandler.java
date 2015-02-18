/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishdictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Albert
 */
public class DictHandler {
    
    private LinkedList<Element> dict;
    private File actualData;       
    private final Random rand;
    private String answer;
    
    public DictHandler(){
        dict=new LinkedList();
        rand=new Random();     
    }
    
    
    void readFile(File fileDir) throws FileNotFoundException, IOException{
        if(fileDir==null){
            fileDir=actualData;
        }
        try {		
		BufferedReader in = new BufferedReader(
		    new InputStreamReader(
                       new FileInputStream(fileDir), "UTF-8"));
		String polish,english;
		while ((polish = in.readLine()) != null) {           
                    english = in.readLine();                   
                    System.out.println(polish+" : "+english);
                    if(polish!=null){
                        dict.add(new Element(polish,english));
                    }
		}
                in.close();
	    } 
	    catch (UnsupportedEncodingException e) 
	    {
			System.out.println(e.getMessage());
	    } 
	    catch (IOException e) 
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
    }

    public void addDatabase(Window w){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","TXT");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(w);
        actualData = new File(chooser.getSelectedFile().getAbsolutePath()); 
        try {
            //  System.out.println(chooser.getSelectedFile().getAbsolutePath());
            readFile(actualData);
       //     startQuiz();
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList<Element> getDict(){
        return dict;
    }
}
