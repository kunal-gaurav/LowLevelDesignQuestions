package VehicleParkingSystem;

public class ParkingManager {
	
	private final ParkingStrategy[] algorithms;
	
	ParkingManager(){
		algorithms = new ParkingStrategy[]{
					new NearestParkingStrategy(),
					new MostFreeSpotParkingStrategy()
		};
	}
	
	public String park(ParkingFloor[] floors, int vehicleType, int parkingStrategy) {
		if(parkingStrategy>=0 && parkingStrategy<algorithms.length) {
			return algorithms[parkingStrategy].park(floors, vehicleType);
		}
		return "";
	}

}
