 import java.io.*;

/**
 * @author Matt Rice
 * @version 11-20-22
 * Class that creates an Amusement park object and defines methods to alter an amusement park
 * AmusementPark.java
 * Fall 2022
 */
public class AmusementPark {
	ResizableArrayBag<Rider> park;
	 Ride ferrisWheel = new Ride("Ferris Wheel", 60, 20);
	 Ride rollerCoaster = new Ride("Death Loop", 80, 18);
	 Ride dropTower = new Ride("Geronimo", 55, 20);
	 Ride swings = new Ride("Sky Fliers", 100, 30);
	 private int attendees;//the amount of people currently in the amusement park
	 private int totalAttendees;//the total number of people that have visited the park
	 private int personGenerator;//the number that will be used 
	
	/**
	 * Creates an object that will consist of a bag that will contain riders when they are not on rides, and four amusement park rides and a count of how many people are in the park which will be updated according to what methods are called
	 */
	 public AmusementPark(){
		 park = new ResizableArrayBag<Rider>(40);
		 ferrisWheel = new Ride("Ferris Wheel", 5, 2);
		 rollerCoaster = new Ride("Death Loop", 12, 6);
		 dropTower = new Ride("Geronimo", 10, 5);
		 swings = new Ride("Sky Fliers", 20, 15);
		 attendees = 0;
	 }//end AmusementPark
	 
	 /**
	  * Randomizes a number and uses that number to generate a person with or without a fastPass and add them to the park, or not generate a person
	 * @throws IOException 
	  */
	 public void generatePerson() throws IOException{
		 personGenerator = (int)(Math.random()*(10-1))+1;
		 if (personGenerator%2 == 0) {
			 Rider rider =new Rider();
			 park.add(rider);
			 attendees++;
			 totalAttendees++;
		 }//end if
		 else if(personGenerator == 9) {
			 Rider fastPassRider = new Rider("Jeff Fastman");
			 fastPassRider.giveFastPass();
			 park.add(fastPassRider);
			 attendees++;
			 totalAttendees++;
		 }//end else if
	 }//end generatePerson
	
	 /**
	 * Randomizes the value of the ride choice of the riders in the park and either adds them to one of the rides or leaves them in the park
	 */
	 public void addToRideLines() {
		 Object [] parkArray = park.toArray();//creates an array representation for park
			for (int index=0;index<parkArray.length;index++) {
				Rider i=(Rider) parkArray[index];
				i.chooseRide();//randomizes the ride choice of the rider
				if (i.getRideChoice()==1) {
					if (!ferrisWheel.isRideLineFull()) {
						ferrisWheel.enterLine(i);
						park.remove(i);
					}
				}//adds rider to ferris wheel and removes them from the park bag
				else if (i.getRideChoice()==2) {
					if (!rollerCoaster.isRideLineFull()) {
						rollerCoaster.enterLine(i);
						park.remove(i);
					}
				}//adds rider to the roller coaster and removes them from the park bag
				else if (i.getRideChoice()==3) {
					if (!dropTower.isRideLineFull()) {
						dropTower.enterLine(i);
						park.remove(i);
					}
				}//adds rider to the drop tower and removes them from the park bag
				else if (i.getRideChoice()==4) {
					if (!swings.isRideLineFull()) {
						swings.enterLine(i);
						park.remove(i);
					}
				}//adds rider to the swings and removes them from the park bag
				else
					continue;
			}//end for
	 }//end addRiderToRides
	 
	 /**
	  * Removes riders from the ride they are on and adds them to the park
	  */
	 public void getOffRides(){
		 while (!ferrisWheel.isRideEmpty()) {
			 park.add(ferrisWheel.exitRide());
		 }//removes the riders on the ferrisWheel
		 while (!rollerCoaster.isRideEmpty()) {
			 park.add(rollerCoaster.exitRide());
		 }//removes the riders on the rollerCoaster
		 while (!dropTower.isRideEmpty()) {
			 park.add(dropTower.exitRide());
		 }//removes the riders on the dropTower
		 while (!swings.isRideEmpty()) {
			 park.add(swings.exitRide());
		 }//removes the riders on the swings
	 }//end getOffRides
	 
	 /**
	  * Removes every rider that has ridden at least four rides
	  */
	 public void removeRiderFromPark() {
		 Object [] parkArray = park.toArray();
			for (int index=0;index<parkArray.length;index++) {
				Rider i=(Rider) parkArray[index];
				if (i.getRideCounter()>2) {
					park.remove(i);
					attendees--;
				}//end if
			}//end for
	 }//end removePerson
	 
	 /**
	  * Adds people to the ferrisWheel ride
	  */
	 public void getOnFerrisWheel() {
		 ferrisWheel.getOnRide();
	 }//end getOnFerrisWheel
	 
	 /**
	  * adds people to the rollerCoaster ride
	  */
	 public void getOnRollerCoaster() {
		 rollerCoaster.getOnRide();
	 }//end getOnRollerCoaster
	 
	 /**
	  * adds people to the dropTower ride
	  */
	 public void getOnDropTower() {
		 dropTower.getOnRide();
	 }//end getOnDropTower
	 
	 /**
	  * adds people to the swings ride
	  */
	 public void getOnSwings() {
		 swings.getOnRide();
	 }//end getOnSwings
	 
	 /**
	  * Calls the getOnRide method for each of the rides in the 
	  */
	 public void getOnRides() {
		 ferrisWheel.getOnRide();
		 rollerCoaster.getOnRide();
		 dropTower.getOnRide();
		 swings.getOnRide();
	 }//end getOnRides
	/**
	 * Removes the riders from the ferrisWheel and adds them to the park
	 */
	 public void getOffFerrisWheel() {
		 while (!ferrisWheel.isRideEmpty()) {
			 park.add(ferrisWheel.exitRide());
		 }//removes the riders on the ferrisWheel
	 }//end getOffFerrisWheel
	 
	 /**
	  * Removes the riders from the rollerCoaster and adds them to the park
	  */
	 public void getOffRollerCoaster() {
		 while (!rollerCoaster.isRideEmpty()) {
			 park.add(rollerCoaster.exitRide());
		 }//removes riders on the rollercoaster
	 }//end getOffRollerCoaster
	 
	 /**
	  * Removes the riders from the dropTower and adds them to the park
	  */
	 public void getOffDropTower() {
		 while (!dropTower.isRideEmpty()) {
			 park.add(dropTower.exitRide());
		 }//removes the riders on the dropTower
	 }//end getOffDropTower
	 
	 /**
	  * Removes the riders from the swings and adds them to the park
	  */
	 public void getOffSwings() {
		 while (!swings.isRideEmpty()) {
			 park.add(swings.exitRide());
		 }//removes the riders on the swings
	 }//end getOffSwings
	 
	 /**
		 * prints the riders within the park with their names and if they have a fastpass and also prints the current number of people in the park(not on rides)
		 */
		public void printPark() {
			Object [] parkArray = park.toArray();
			System.out.println("People not on Rides:");
			for (int index=0;index<parkArray.length;index++) {
				Rider i=(Rider) parkArray[index];
				System.out.println("Name: "+i.getRiderName()+" FastPass: "+i.getFastPass() + " Ride counter: " + i.getRideCounter());
			}
			System.out.println("Current number of attendees: "+ attendees + "\nTotal number of attendees: " + totalAttendees);//prints current number of attendees in the park
			
			ferrisWheel.printRide();
			System.out.println();
			rollerCoaster.printRide();
			System.out.println();
			dropTower.printRide();
			System.out.println();
			swings.printRide();
		}//end printPark
		
		/**
		 * Removes everyone from the park and rides when its time to close
		 */
		public void clearPark() {
			while (!park.isEmpty()) {
				park.remove();
			}//removes all people from the park
			ferrisWheel.clearRide();
			rollerCoaster.clearRide();
			dropTower.clearRide();
			swings.clearRide();
		}//end clearPark
		
		/**
		 * Returns if everything in the park is empty or not
		 * @return true if all of the rides, ride lines, and the park are empty and false if they are not
		 */
		public boolean isAmusementParkEmpty() {
			if(ferrisWheel.isLineAndRideEmpty() && rollerCoaster.isLineAndRideEmpty() && dropTower.isLineAndRideEmpty() && swings.isLineAndRideEmpty() && park.isEmpty())
				return true;
			else
				return false;
		}// end isAmusementParkEmpty
		/**
		 * Gets the total number of attendees for the day
		 * @return the totalAttendees
		 */
		public int getTotalAttendees() {
			return totalAttendees;
		}//end getTotalAttendees
		
		/**
		 * Clears the output stream on the command line
		 */
		public static void clearOutputStream() {
		    {
		        try
		        {
		            if (System.getProperty("os.name").contains("Windows"))
		                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		            else
		                Runtime.getRuntime().exec("clear");
		        } catch (IOException | InterruptedException ex) {}
		    }
		}//end clearOutputStream
}//end AmusementPark.java
