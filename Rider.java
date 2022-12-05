import java.io.IOException;

/**
 * @author Matt Rice
 * @Version 11/03/2022
 * Creates an object for a person queuing up for a ride
 */
public class Rider {
	//Instance variables
	
	private String name;//The name of the rider
	private int firstNameNumber ;//Will generate a random number that will be used to give the rider a first name
	private int lastNameNumber;//Will generate a random number that will be used to give the rider a last name
	private int fastPass;//Whether or not the rider has a fastPass
	private int rideCounter;//how many rides each rider has ridden
	private int rideChoice;//Which ride the rider will choose
	private HashDictionary firstNames = new HashDictionary();
	private HashDictionary lastNames = new HashDictionary();
	/**
	  * Creates an object of type Rider and assigns them a random name and assumes they do not have a fastPass 
	 * @throws IOException 
	  */
	public Rider() throws IOException {
		//filling the dictionaries
		firstNames.fillDictionary("CommonFirstNames.txt");
		lastNames.fillDictionary("CommonLastNames.txt");
		
		firstNameNumber=(int)(Math.random()*(30-1))+1;//generates a number that will create a number that will be used to decide the rider's name
		String firstName = String.valueOf(firstNameNumber);
		lastNameNumber=(int)(Math.random()*(30-1))+1;
		String lastName = String.valueOf(lastNameNumber);
		
		name = firstNames.getDefinition(firstName) + " " + lastNames.getDefinition(lastName);
		
		fastPass = 0;
		rideCounter = 0;
		rideChoice = 0;
	}//end rider
	public Rider(String names) {
		name = names;
		fastPass = 0;
		rideCounter = 0;
		rideChoice = 0;
	}
	/**
	 * Returns the name of the Rider
	 * @return the name of the Rider
	 */
	public String getRiderName() {
		return name;
	}//end getRiderName
	/**
	 * Gets the fastPass value of the rider
	 * @return the fast pass value of the specified rider
	 */
	public int getFastPass() {
		return fastPass;
	}
	/**
	 * Gets the rideCounter value of the rider
	 * @return the rideCounter value of the rider
	 */
	public int getRideCounter() {
		return rideCounter;
	}//end get RideCounter
	/**
	 * Method that will make the rider have a fastPass
	 */
	public void giveFastPass() {
		fastPass=1;
	}//end giveFastPass
	/**
	 * Adds one to the ride counter of a given rider
	 */
	public void addToRideCounter() {
		rideCounter++;
	}//addToRideCounter
	/**
	 * Randomizes the value of the ride choice variable of the rider, will be used to send a rider to a ride
	 */
	public void chooseRide() {
		rideChoice = (int)(Math.random()*(6-1))+1;
	}//end chooseRide
	/**
	 * Gets the value of the rideChoice of a Rider
	 * @return the value of the rider's ride choice
	 */
	public int getRideChoice() {
		return rideChoice;
	}//end getRideChoice
	
}//end Rider.java
