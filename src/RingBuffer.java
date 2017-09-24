import java.util.ArrayList;
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
public class RingBuffer {
	private ArrayList<Double> ringB;
    private int Capacity;
	
    // create an empty ring buffer, with given max capacity
	public RingBuffer(int capacity)  {
    	ringB = new ArrayList<Double>();
    	Capacity = capacity;
    }
    
	// return number of items currently in the buffer
    public int size(){
    	return ringB.size();
    }
    
    // is the buffer empty (size equals zero)?
    public boolean isEmpty(){
    	return ringB.isEmpty();
    }
    
    // is the buffer full  (size equals capacity)?
    public boolean isFull(){
    	return (ringB.size()==Capacity);
	}
    
    // add item x to the end (as long as the buffer is not full)
    public void enqueue(double x){
    	if(isFull())
    		throw new IllegalStateException();
    	ringB.add(x);
	}
   
    // delete and return item from the front (as long as the buffer is not empty)
    public double dequeue(){
    	if(isEmpty())
    		throw new NoSuchElementException();
    	double temp = ringB.get(0);
    	ringB.remove(0);
    	return temp;
	}

    // return (but do not delete) item from the front of the buffer
    public double peek(){
    	if(isEmpty())
    		throw new NoSuchElementException();
    	return ringB.get(0);
	}
   
    // override toString. Return a String of the form [front, next, next, last] 
    public String toString(){
    	return ringB.toString();
	}
}
