package englishdictionary;

/**
 * Main class with main method
 *
 * @author Albert Podraza
 */
public class EnglishDictionary {

    /**
     * @param args table with external parameters
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Window().setVisible(true);
                }
            });
    }
    
}
