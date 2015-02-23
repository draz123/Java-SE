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
 * This class consists methods that are responsible for processing dictionary
 * words base and one wrapper, which return list of words.
 * 
 * @author Albert Podraza
 * @see List
 */
public class DictHandler {
    
    private LinkedList<Element> dict;
    private File actualData;       
    private final Random rand;
    private String answer;
    
    /**
     * Default constructor that initialize two variables, dict, which is list
     * with dictionary's words and rand that is base for drawing words.
     */
    public DictHandler(){
        dict=new LinkedList();
        rand=new Random();     
    }
    
    /**
     * 
     * @param fileDir file with word's database
     * @throws FileNotFoundException if the filedir is empty
     * @throws IOException if something during processing goes wrong
     */
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
    
    /**
     * 
     * @param w includes main class 
     */
    public void addDatabase(Window w){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","TXT");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(w);
        actualData = new File(chooser.getSelectedFile().getAbsolutePath()); 
        try {
            readFile(actualData);
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return list with words and translation 
     */
    public LinkedList<Element> getDict(){
        return dict;
    }
}
