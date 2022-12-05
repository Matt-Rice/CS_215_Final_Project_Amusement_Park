import java.util.PriorityQueue;
/**
 * @author Matt Rice
 * @version 11/03/2022
 * Creates a priority queue that will simulate a ride line 
 * RideLine.java
 * Fall 2022
 */
public class RideLine {
	
	private PriorityQueue<Rider> line;//Creates a priority queue to simulate a line
	private int capacity;//max capacity for a queue
	
	/**
	 * Creates a Priority queue for a ride that will prioritize riders with fastPasses
	 */
	 public RideLine(int maxLength) {
		 capacity = maxLength;
		 line = new PriorityQueue<Rider>(capacity,new RiderComparator());
	 }//end ride line
	 
	 /**
	  * Adds a rider to the ride line
	  * @param rider the rider that will be added to the line
	  * @return true if the add was successful and false if the add was not successful
	  */
	 public boolean addToLine(Rider rider) {
		 return line.add(rider);
	 }//end addToLine
	 
	 /**
	  * Removes the rider in the front of the line
	  * @return the rider that was removed from the line
	  */
	 public Rider removeFront() {
		return line.remove();
	 }//end removeFront
	 
	 /**
	  * Returns the Rider at the front of the line
	  * @return the rider at the front of the line
	  */
	 public Rider getFront() {
		 return line.peek();
	 }//end getFront
	 
	 /**
	  * Returns the capacity of a line
	  * @return the capacity of a line
	  */
	 public int getCapacity() {
		 return capacity;
	 }//end getCapacity
	 
	 /**
	  * Method that sees if the line is empty or not
	  * @return true if the line is empty and false if not
	  */
	 public boolean isLineEmpty() {
		 return line.isEmpty();
	 }//end isLineEmpty
	 
	 /**
	  * Sees if the line is full
	  * @return true if the line is full and false if not
	  */
	 public boolean isLineFull() {
		 if (line.size()==capacity) 
			 return true;
		 else
			return false;
	 }//end isLineFull
	 
	 /**
	  * Returns the number of elements in the line
	  * @return the number of elements in the line
	  */
	 public int lineLength() {
		 return line.size();
	 }//end lineLength
	 /**
	  * Prints the names of the riders in the ride line in order from front to back
	  * @return void
	  */
	 public void printRideLine() {
		PriorityQueue<Rider> lineCopy = new PriorityQueue<Rider>(line);
		while(!lineCopy.isEmpty()) {
			System.out.print(lineCopy.poll().getRiderName() + ", ");
		}//end while
		  
	}//end printRideLine 
		
	 
}//end RideLine.java
