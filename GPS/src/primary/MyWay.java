package primary;

import java.io.Serializable;
import java.util.LinkedList;
        /** 
         * MyWay processed ways from XML to potential edges of graph.     
	 */
public class MyWay implements Serializable {

	private final String streetName;
	private double weight;
	private final MyVertex start,stop;

        /** 
         * Default edge constructor 
         * @param _streetName street name
         * @param _ref list of way's verticles from XML file
         * @param refHelper variable, which helps with determing verticles of edge
         * @param map reference to main class with verticles and other data
	 */ 
        public MyWay(String _streetName, LinkedList<String> _ref,int refHelper,MyMap map){
            start=map.getVerticles().get( _ref.get(refHelper-1));
            stop=map.getVerticles().get(_ref.get(refHelper));
            streetName=_streetName;
            if(stop!=null && start!=null){
		weight=Math.sqrt(Math.pow(stop.getLon()- start.getLon(),2)+Math.pow(stop.getLat()- start.getLat(),2));
            }
        }
                
        /** 
         * Returning private data with edge's first verticle
         * @return first vertex      
	 */  
	public MyVertex getStartVertex(){
            return start; 
        }
                
        /** 
         * Returning private data with edge's second verticle
         * @return end vertex       
	 */  
        public MyVertex getStopVertex(){
            return stop; 
        }
                
        /** 
         * Returning private data with distance between 2 
         * verticles in edge
         * @return distance       
	 */  
        public double getWeight(){
            return weight; 
        }
                
        /** 
         * Returning private data with street name.
         * @return street name.
	 */  
        public String getStreet(){
            return streetName; 
        }
}
