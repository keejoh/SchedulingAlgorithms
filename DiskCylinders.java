/* KeeJoh O'hearon
 * Project 3 
 * Operating Systems
 * 12/13/2019
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiskCylinders {

	public static void main(String[] args) {
		//create a scanner for user to input start of head
		Scanner myScanner = new Scanner(System.in);
		//initialize array to store random numbers
		int[] randomNumbers = new int[20];
		//create a random object to later make random numbers
		Random randomInt = new Random();
		//create and store random numbers
		for(int i=0; i<randomNumbers.length;i++) {
			randomNumbers[i]= randomInt.nextInt(999);
		}
		//ask the user to enter the start of the head as an integer between 0 and 999
		System.out.println("Please enter a starting point for the initial posistion of the cylinder head as an integer between 0 and 999.");
		int initialPosition = myScanner.nextInt();  
		//print the array of random numbers and their corresponding head movements for FCFS and SSTF algorithms
		System.out.println("The cylinder requests are as follows " +Arrays.toString(randomNumbers));
		//create a FCFS object based off initial head position and the array of random numbers
		FCFS fcfsMovement = new FCFS(initialPosition,randomNumbers);
		//create a SSTF object based off the initial head position and the array of random numbers
		SSTF sstfMovement = new SSTF(initialPosition,randomNumbers);
		//calculate and print the head movement for FCFS and SSTF algorithms
		fcfsMovement.calculateHeadMovement();
		sstfMovement.shortestSeekTimeFirst();
	}

}
