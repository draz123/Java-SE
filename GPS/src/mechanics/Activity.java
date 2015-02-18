package mechanics;

import webComunication.Server;

/**
 *
 * @author Albert Podraza
 */


        /** 
         * Class contains main() and initialize program         
	 */  
public class Activity  {

	public static void main(String[] args) {
            Runnable[] throad = new Runnable[2];
            Thread[] threads = new Thread[2];
      
            throad[0] = new CreateGUI();
        //    throad[1] = new Server();
         
            threads[0] = new Thread(throad[0]);
        //    threads[1] = new Thread(throad[1]);       
            for(int i=0; i<1; i++) {    
         //   for(int i=0; i<2; i++) {
                threads[i].start();
        }
}
}
