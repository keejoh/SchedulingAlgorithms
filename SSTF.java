
public class SSTF {
	int initialPosistion;
	int[] randomNumbers;
	int totalHeadMovement = 0;

	// constructor to use SSTF
	public SSTF(int initialPosistion, int[] randomNumbers) {
		this.initialPosistion = initialPosistion;
		this.randomNumbers = randomNumbers;
	}

	// method to run the shortestSeekTimeFirst algorithm
	public void shortestSeekTimeFirst()

	{
		if (randomNumbers.length == 0)
			return;
		// create array of AccessedNode type to track distance and if 'node' has been
		// accessed already
		AccessedNode distanceFromhead[] = new AccessedNode[randomNumbers.length];
		for (int i = 0; i < distanceFromhead.length; i++)

			distanceFromhead[i] = new AccessedNode();
		// iterate through each cylinder request and go to the next closest request from
		// the head continue this until all requests have been services
		for (int i = 0; i < randomNumbers.length; i++) {

			calculateDistance(randomNumbers, initialPosistion, distanceFromhead);

			int index = findMin(distanceFromhead);

			distanceFromhead[index].accessed = true;

			// keep track of head movement
			totalHeadMovement += distanceFromhead[index].distance;

			// accessed request becomes new head position
			initialPosistion = randomNumbers[index];
		}
		System.out.println("The total amount of head movement for Shortest Seek Time first is "+totalHeadMovement);
	}

	// calculates distance of every request from current head position to decide
	// which request to service next
	public void calculateDistance(int randomNumbers[], int initialPosistion, AccessedNode distanceFromhead[])

	{
		for (int i = 0; i < distanceFromhead.length; i++)
			distanceFromhead[i].distance = Math.abs(randomNumbers[i] - initialPosistion);
	}

	// find an un-accessed request that is minimum distance from current head
	public static int findMin(AccessedNode distanceFromhead[]) {
		int index = -1, minimum = Integer.MAX_VALUE;

		for (int i = 0; i < distanceFromhead.length; i++) {
			if (!distanceFromhead[i].accessed && minimum > distanceFromhead[i].distance) {

				minimum = distanceFromhead[i].distance;
				index = i;
			}
		}
		return index;
	}
}
