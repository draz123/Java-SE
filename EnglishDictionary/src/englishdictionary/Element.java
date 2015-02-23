package englishdictionary;

/**
 * Includes structure for store foreign words and it's translation
 *
 * @author Albert Podraza
 */
public class Element {
    
    private final String english;
    private final String polish;
    /**
     * Constructor that accepts 2 parameters and sets element's 
     * fields.
     * 
     * @param _polish external delivered polish translation
     * @param _english external delivered english word
     */
    public Element(String _polish,String _english){
        polish=_polish;
        english=_english;
    }
    
    /**
     * 
     * @return string with polish translation
     */
    public String getPolish(){
        return polish;
    }
    
    /**
     * 
     * @return string with english word
     */
    public String getEnglish(){
        return english;
    }
}

