
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishdictionary;

/**
 *
 * @author Albert
 */
public class Element {
    private final String english;
    private final String polish;
    public Element(String _polish,String _english){
        polish=_polish;
        english=_english;
    }
    public String getPolish(){
        return polish;
    }
    
    public String getEnglish(){
        return english;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

