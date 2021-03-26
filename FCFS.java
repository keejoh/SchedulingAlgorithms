
public class FCFS {
int initialPosistion;
int[] randomNumbers;
int totalHeadMovement=0;
public FCFS(int initialPosistion, int[] randomNumbers) {
	this.initialPosistion=initialPosistion;
	this.randomNumbers=randomNumbers;
}
public void calculateHeadMovement() {
	for(int i = 0; i<randomNumbers.length;i++) {
		totalHeadMovement=totalHeadMovement +Math.abs(randomNumbers[i]-initialPosistion);
		initialPosistion = randomNumbers[i];
	}
	System.out.println("The total amount of head movement for First Come First Serve algorithm(servicing requests in the order listed) is "+totalHeadMovement);
}

}
