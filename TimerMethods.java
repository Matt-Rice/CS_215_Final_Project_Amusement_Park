import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
 
/**
 * @author Matt Rice
 * @version 12-2-22
 * Uses a timer with the methods from the Amusement park class to simulate a day at an amusement park
 * TimerMethods.java
 * Fall 2022
 */
public class TimerMethods {
	private int time=0;//will track how long the simulation has been running
	private int length;
	/**
	 * Constructor that will be used to simulate a day at the park
	 * @param period 
	 */
	public TimerMethods() {
	
	}
	AmusementPark riceLand= new AmusementPark();
	Timer t1 = new Timer();
	
	/**
	 * TimerTask that will generate people to the park and will cancel after a specified time
	 */
	TimerTask adding = new TimerTask() {
		public void run() {
			if (time==length)
				adding.cancel();
			else {
				try {
					riceLand.generatePerson();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
		}
	};
	
	/**
	 * Task that will remove people from the park
	 */
	TimerTask removing = new TimerTask() {
		public void run() {
			riceLand.removeRiderFromPark();
		}
	};
	
	/**
	 * Task that will add people to the ride lines
	 */
	TimerTask addingToLines = new TimerTask() {
		public void run() {
			riceLand.addToRideLines();
			 
		}
	};
	
	/**
	 * task that will have people get on and off of the ferris wheel
	 */
	TimerTask ferrisWheel = new TimerTask() {
		public void run() {
			riceLand.getOffFerrisWheel();
			riceLand.getOnFerrisWheel();
		}
	};
	
	/**
	 * task that will have people get on and off of the roller coaster
	 */
	TimerTask rollerCoaster = new TimerTask() {
		public void run() {
			riceLand.getOffRollerCoaster();
			riceLand.getOnRollerCoaster();
		}
	};
	
	/**
	 * task that will have people get on and off of the drop tower
	 */
	TimerTask dropTower = new TimerTask() {
		public void run() {
			riceLand.getOffDropTower();
			riceLand.getOnDropTower();
			
		}
	};
	
	/**
	 * task that will have people get on and off of the swings
	 */
	TimerTask swings = new TimerTask() {
		public void run() {
			
			riceLand.getOffSwings();
			riceLand.getOnSwings();
			 
		}
	};
	
	/**
	 * task that will clear the output stream, print the current state of the park, end the timer after everyone leaves and print how many attendees there were, the time it simulated for, and the money made
	 */
	TimerTask printing = new TimerTask() {
		public void run() {
			riceLand.clearOutputStream();
			 
			if (riceLand.isAmusementParkEmpty()) {
				t1.cancel();
				t1.purge();
				System.out.println("Closing Time!!! \nTime Simulated: " + time + " minutes" + "\nTotal Attendees: " + riceLand.getTotalAttendees() + "\nEstimated Money received from ticket sales: $" + riceLand.getTotalAttendees()*100);
			}
			else {
			if (time == 1)
				System.out.println("\nTime Passed: " + time++ + " minute");
			else
				System.out.println("\nTime Passed: " + time++ + " minutes");
			
			riceLand.printPark();
			}
		}
	};
	/**
	 * A method that will call all of the timer methods which will be used to simulate the park and will 
	 * @param period the amount of seconds that the sim will go until nobody new will be added
	 */
	public void sim(int period) {
			length=period;
			t1.scheduleAtFixedRate(adding, 0, 500);
			t1.scheduleAtFixedRate(removing, 0, 1);
			t1.scheduleAtFixedRate(ferrisWheel, 5000, 10000);
			t1.scheduleAtFixedRate(swings, 5000, 5000);
			t1.scheduleAtFixedRate(rollerCoaster, 5000, 4000);
			t1.scheduleAtFixedRate(dropTower, 5000, 6000);
			t1.scheduleAtFixedRate(addingToLines, 500,500);
			t1.scheduleAtFixedRate(printing, 3000,1000);
	}//end sim
	 
}//end TimerMethods.java
