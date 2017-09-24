import java.util.NoSuchElementException;

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
public class GuitarString {
	private RingBuffer ring;
	private int ticTimes;
	
	 public GuitarString(double frequency){
		 // create a guitar string of the given frequency, using a sampling rate of 44,100
		 int N = (int)(44100/frequency);
		 ring = new RingBuffer(N);
		 for(int i=0;i<N;i++)
			 ring.enqueue(0.0);
		 ticTimes = 0;
	 }
	 
     public GuitarString(double[] init){
    	 // create a guitar string whose size and initial values are given by the array
    	 ring = new RingBuffer(init.length);
    	 for(int i=0; i<init.length; i++){
    		 ring.enqueue(init[i]);
    	 }
     }
     
	public void pluck(){
		while(!ring.isEmpty()){
			ring.dequeue();
		}
		// set the buffer to white noise
		while(!ring.isFull()){
			ring.enqueue((Math.random( )-0.5));
		}
		
	}
	
	public void tic(){
		// advance the simulation one time step
		try{
			ticTimes++;
			double first = ring.dequeue();
			double second = ring.peek();
			double update = (first+second)/2*0.994;
			ring.enqueue(update);
		}catch(NoSuchElementException RingBuffer){
			return;
		}	
	}
	public double sample(){
		// return the current sample
		try{
			return ring.peek();
		}catch(NoSuchElementException RingBuffer){
			return 0;
		}
	}
	public int time(){
		 // return number of tics
		return ticTimes;
		
	 }
}
