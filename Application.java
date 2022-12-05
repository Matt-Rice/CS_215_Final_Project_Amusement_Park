 
/**
 * @author Matt Rice
 * @version 12-4-22
 * Will use the methods from the TimerMethods class to simulate an amusment park which will add people for 200 seconds and stop completely when the Amusement park is empty
 * Application.java
 * Fall 2022
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TimerMethods simulation = new TimerMethods();
		simulation.sim(200);//will add new people to the park for 200 seconds (minutes in the simulation) and keep running until the park is empty because it will be closed
	}//end main

}
