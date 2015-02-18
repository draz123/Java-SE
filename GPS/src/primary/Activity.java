package primary;

/**
 *
 * @author Albert Podraza
 */


        /** 
         * Class contains main() and initialize program         
	 */  
public class Activity  {

	public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Window().setVisible(true);
                }
            });
}
}
