package ElevatorManagementSystem;

public class IdleState extends LiftState{

	public IdleState(Lift lift) {
		super(lift);
	}

	@Override
	public char getDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeToReachFloor() {
		// TODO Auto-generated method stub
		return 0;
	}

}
