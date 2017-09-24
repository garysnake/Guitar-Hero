
/**
 * CS312 Assignment 12.
 *
 * On MY honor, <Shijing Zhong>, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Shijing Zhong
 * UTEID: sz6539
 * email address: zsjgary@utexas.edu
 * Number of slip days used on this assignment: 0
 * 
 */
public class GuitarHero {
	 private final static int keyLength = 37;
	 private final static String keyBoardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
	public static void main(String[] args) {

	        // Create keyboard for char identify
			// Create frequencies relative to the key
			// Create Guitar Strings
	        char keyBoard[] = fillKeyBoard();
		 	double frqKey[] = fillFrequency();
	        GuitarString Gstring[] = fillGstring(frqKey);

	        final double TEXT_POS_X = .5;
	        final double TEXT_POS_Y = .5;
	        
	        
	        
	        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Full keyboard version made by Shijing");

	        
	        play(Gstring,keyBoard);
	    }
	   
	    private static void play(GuitarString[] Gstring,char[] keyBoard) {        // the main input loop
	        while (true) {
	            
	            // check if the user has typed a key, and, if so, process it
	           if (StdDraw.hasNextKeyTyped()) {
	 
	                // the user types this character
	                char key = StdDraw.nextKeyTyped();

	                // pluck the corresponding string
	                for(int i=0; i<keyLength; i++){
	                	if(key == keyBoard[i])
	                		Gstring[i].pluck();
	                }	        	
	            // compute the superposition of the samples
	           }
	                double sample = 0;
	                for(int i=0; i<keyLength; i++){
	                	sample+=Gstring[i].sample();
	                }
	            // send the result to standard audio
	            StdAudio.play(sample);

	            // advance the simulation of each guitar string by one step
	            for(int i=0; i<keyLength; i++){
                	Gstring[i].tic();
                }
	        }
	        
	    }
	    
	    //fill the keyboard
	    private static char[] fillKeyBoard(){
	    	char[] kb = new char[keyLength];
	    	for(int i =0; i<keyLength; i++){
	    		kb[i]=keyBoardString.charAt(i);
	    	}
	    	return kb;
	    }
	    //fill the frequency relative to the key
	    private static double[] fillFrequency(){
	    	double frqKey[] = new double[keyLength];
	    	for(int i =0; i<keyLength; i++){
	    		frqKey[i]=440.0*Math.pow(1.05946, (i-24));
	    	}
	    	return frqKey;
	    }
	    //fill the Guitar String
	    private static GuitarString[] fillGstring(double[] frqKey){
	    	GuitarString Gstring[] = new GuitarString[keyLength];
	    	for(int i =0; i<keyLength; i++){
	    		Gstring[i] = new GuitarString(frqKey[i]);
	    	}
	    	return Gstring;
	    }

	}

	
