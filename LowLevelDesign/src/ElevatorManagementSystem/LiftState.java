package ElevatorManagementSystem;

abstract class LiftState {
	
	private Lift lift;

	public LiftState(Lift lift) {
		this.lift = lift;
	}
	
	public void updateFloor() {};
	public void updateDirection() {};
	public abstract char getDirection();
	public abstract int getTimeToReachFloor();

}
