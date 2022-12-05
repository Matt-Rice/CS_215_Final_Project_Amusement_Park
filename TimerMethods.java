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
	
	/**
	 * Constructor that will be used to simulate a day at the park
	 */
	public TimerMethods() {
	
	}
	AmusementPark riceLand= new AmusementPark();
	Timer t1 = new Timer();
	
	TimerTask task1 = new TimerTask() {
		public void run() {
			try {
				riceLand.generatePerson();
			} catch (IOException e) {
				e.printStackTrace();
			}
			riceLand.removeRiderFromPark();
		}
		
	};
	TimerTask addingToLines = new TimerTask() {
		public void run() {
			riceLand.addToRideLines();
			 
		}
	};
	TimerTask ferrisWheel = new TimerTask() {
		public void run() {
			riceLand.getOffFerrisWheel();
			riceLand.getOnFerrisWheel();
		}
	};
	TimerTask rollerCoaster = new TimerTask() {
		public void run() {
			riceLand.getOffRollerCoaster();
			riceLand.getOnRollerCoaster();
		}
	};
	TimerTask dropTower = new TimerTask() {
		public void run() {
			riceLand.getOffDropTower();
			riceLand.getOnDropTower();
			
		}
	};
	TimerTask swings = new TimerTask() {
		public void run() {
			riceLand.getOffSwings();
			riceLand.getOnSwings();
			 
		}
	};
	TimerTask printing = new TimerTask() {
		public void run() {
			if (time == 1)
				System.out.println("\nTime Passed: " + time++ + " minute");
			else
				System.out.println("\nTime Passed: " + time++ + " minutes");
			
			riceLand.printPark();
		}
	};
	/**
	 * A method that will call all of the timer methods which will be used to simulate the park and will 
	 * @param period
	 */
	public void sim(int period) {
		if (time==period) {
			printing.cancel();
			t1.cancel();
			t1.purge();
			System.out.println("Closing Time!!! " + "Time Elapsed: " + time + "minutes" + "\nTotal Attendees today: " + riceLand.getTotalAttendees() + "\nEstimated Income: $" + riceLand.getTotalAttendees()*20);
			riceLand.clearPark();
		}
		else {
			t1.scheduleAtFixedRate(task1, 0, 500);
			t1.scheduleAtFixedRate(ferrisWheel, 10000, 10000);
			t1.scheduleAtFixedRate(swings, 10000, 5000);
			t1.scheduleAtFixedRate(rollerCoaster, 10000, 4000);
			t1.scheduleAtFixedRate(dropTower, 10000, 6000);
			t1.scheduleAtFixedRate(addingToLines, 500,500);
			t1.scheduleAtFixedRate(printing, 100,1000);
		}
		
		
	}
	public static void main(String[]args) {
		TimerMethods simulation = new TimerMethods();
		simulation.sim(100);
	}
}
