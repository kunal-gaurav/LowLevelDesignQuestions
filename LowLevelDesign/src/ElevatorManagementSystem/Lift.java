package ElevatorManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Lift {

	private static int MAX_CAPACITY = 10;
	private List<LiftRequest> requests;
	private LiftState movingUpState;
	private LiftState movingDownState;
	private LiftState idleState;
	private LiftState currentState;
	private int currentFloor;

	public Lift() {
		this.currentFloor = 0;
		this.requests = new ArrayList<>();
		this.movingDownState = new MovingDownState(this);
		this.movingDownState = new MovingDownState(this);
		this.idleState = new IdleState(this);
		this.currentState = this.idleState;
	}

	public int countPeople(int floor, char direction) {
		int people = 0;
		for (LiftRequest request : this.requests) {
			if (request.getDirection() == direction) {
				if (direction == 'U' && this.currentFloor >= request.getStartFloor()
						&& this.currentFloor < request.getDestinationFloor()) {
					people++;
				} else if (direction == 'D' && this.currentFloor <= request.getStartFloor()
						&& this.currentFloor > request.getDestinationFloor()) {
					people++;
				}
			}
		}
		return people;
	}

	char getMoveDirection() {
		return this.currentState.getDirection();
	}

	int getCurrentFloor() {
		return this.currentFloor;
	}

	public boolean hasSpace(int startFloor, int destinationFloor) {
		char direction = startFloor < destinationFloor ? 'U' : 'D';
		if (direction == 'U') {
			for (int floor = startFloor; floor < destinationFloor; floor++) {
				if (countPeople(floor, direction) >= MAX_CAPACITY) {
					return false;
				}
			}
		} else if (direction == 'D') {
			for (int floor = startFloor; floor > destinationFloor; floor--) {
				if (countPeople(floor, direction) >= MAX_CAPACITY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void setState(char direction) {
		if(direction=='I') {
			this.currentState = this.idleState;
		}
		else if(direction=='U') {
			this.currentState = this.movingUpState;
		}
		else {
			this.currentState = this.movingDownState;
		}
	}
	
	public void updateRequests() {
		char direction = this.currentState.getDirection();
		if(direction=='I') {
			return;
		}
		List<LiftRequest> newRequests = new ArrayList<>();
		for(LiftRequest request : requests) {
			if(direction==request.getDirection()) {
				boolean liftPassedDestinationGoingUp = (direction=='U' && request.getDestinationFloor()<=this.currentFloor) ? true : false;
				boolean liftPassedDestinationGoingDown = (direction=='D' && request.getDestinationFloor()>=this.currentFloor)?true : false;
				if(liftPassedDestinationGoingDown || liftPassedDestinationGoingUp) {
					continue;
				}
			}
			newRequests.add(request);
		}
		this.requests = newRequests;
	}
}
