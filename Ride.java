 

/**
 * @author Matt Rice
 * @version 11-20-22
 * A class that will perform methods on the rides in the amusement park
 * Ride.java
 * Fall 2022
 */
public class Ride {
	private String rideName;//Name of the ride
	private RideLine line;//Line of people that are in the line of the ride
	private RideLine onRide;//Line of people that are currently on the ride
	private int rideCapacity;//number of people that can fit on the ride
	 
	/**
	  * Creates a Ride class which contains two priority queues and a name for the ride. 
	  * The first priority queue symbolizes the line before a rider enters a ride and is FIFO unless the rider has a fastpass, which will give them priority.
	  * The second priority queue symbolizes the actual people that are on the ride.
	  * @param rideName The name that will be chosen for the ride
	  * @param maxLineLength
	  * @param maxRideLength
	  */
	public Ride(String rideNamer,int maxLineLength, int maxRideLength) {
		rideName=rideNamer;
		line=new RideLine(maxLineLength);
		onRide = new RideLine(maxRideLength);
		rideCapacity=maxRideLength;
	}//end Ride
	
	/**
	 * Adds a rider to the line priority queue
	 * @param rider the rider that will be added to the line
	 * @return true if the adding is successful and false if not
	 */
	public boolean enterLine(Rider rider) {
		return line.addToLine(rider);
	}//end enterLine
	
	/**
	 * Adds a rider to the onRide queue
	 * @param rider the rider that will be added to the line
	 * @return true if the adding is successful and false if not
	 */
	public boolean enterRide(Rider rider) {
		return onRide.addToLine(rider);
	}//end enterRide
	
	/**
	 * Removes rider from the front of the line
	 * @return the rider that was removed from the front of the line
	 */
	public Rider exitLine() {
		return line.removeFront();
	}//end exitLine
	
	/**
	 * Removes the rider in the front of the ride and adds to their rideCounter
	 * @return the rider that was removed
	 */
	public Rider exitRide() {
		onRide.getFront().addToRideCounter();
		return onRide.removeFront();
	}//end exitRide
	
	/**
	 * Returns the number of riders in the onRide queue
	 * @return the number of elements in the onRide queue
	 */
	public int rideSize() {
		return onRide.lineLength();
	}//end rideSize
	/**
	 * Returns the number of riders in the line queue
	 * @return the number of elements in the line queue
	 */
	public int lineSize() {
		return line.lineLength();
	}//end lineSize
	/**
	 * Returns the capacity of the ride
	 * @return the capacity of the ride
	 */
	public int getRideCapacity() {
		return rideCapacity;
	}//end getRideCapacity
	/**
	 * Pushes people from the ride line until either the ride is full or the ride line is empty
	 */
	public void getOnRide() {
		while(!onRide.isLineFull()&&!line.isLineEmpty()) {
			onRide.addToLine(line.removeFront());
		}//end while
	}//end getOnRide
	/**
	 * Checks to see if the Ride line is empty
	 * @return true if the line is empty and false if it is not
	 */
	public boolean isRideEmpty() {
		return onRide.isLineEmpty();
	}//end isRideLineEmpty
	/**
	 * Is the in line full
	 * @return true if the line is full and false if it is not
	 */
	public boolean isRideLineFull() {
		return line.isLineFull();
	}//end isRideLineFull
	
	/**
	 * Checks to see if the ride and the ride line are empty
	 * @return true if both are empty and false if not
	 */
	public boolean isLineAndRideEmpty() {
		if(line.isLineEmpty() && onRide.isLineEmpty())
			return true;
		else 
			return false;
	}//end isLineAndRideEmpty

	/**
	 * Removes every rider from the rideLine and the ride
	 */
	public void clearRide() {
		while (!onRide.isLineEmpty()) {
			onRide.removeFront();
		}//removes everyone from the ride
		while(!line.isLineEmpty()) {
			line.removeFront();
		}//removes everyone from the ride 
	}//end clearRide
	
	/**
	 * prints out the ride name, the people that are in the ride from front to back, and the people who are currently riding the ride
	 */
	public void printRide() {
		System.out.println(rideName);
		System.out.println("Ride Line: " + line.lineLength()); 
		line.printRideLine();
		System.out.println("\nCurrently On Ride: " +onRide.lineLength());
		onRide.printRideLine();
	}//end printRide
}//end Ride.java