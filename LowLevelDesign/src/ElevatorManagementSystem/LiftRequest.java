package ElevatorManagementSystem;

public class LiftRequest {

	private int startFloor;
	private int destinationFloor;

	public LiftRequest(int startFloor, int destinationFloor) {
		this.startFloor = startFloor;
		this.destinationFloor = destinationFloor;
	}

	public int getStartFloor() {
		return startFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public char getDirection() {
		if (startFloor != destinationFloor) {
			return startFloor < destinationFloor ? 'U' : 'D';
		}
		return 'I';
	}

}
