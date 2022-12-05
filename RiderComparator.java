import java.util.Comparator;
 
/**
 * Creates a comparator that compares two riders' fastPass values
 * @author Matt Rice
 * @version 11-20-22
 * RiderComparator.java
 * Fall 2022
 */
public class RiderComparator implements Comparator<Rider>{

/**
 * Compares the riders to see if they have a fastPass
 * @return 1 if the fastPass of r1 is less than r2, -1 if is greater than, 0 if they are equal
 */
	public int compare(Rider r1, Rider r2) {
		if (r1.getFastPass()<r2.getFastPass()) 
			return 1;
	
		else if(r1.getFastPass()>r2.getFastPass())
			return -1;
		else
			return 0;
	}//end compare

}//end RiderComparator.java