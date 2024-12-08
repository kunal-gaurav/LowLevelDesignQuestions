package VehicleParkingSystem;

public class NearestParkingStrategy implements ParkingStrategy {

	@Override
	public String park(ParkingFloor[] floors, int vehicleType) {
		for(ParkingFloor floor : floors) {
			if(floor.getFreeSpotsCount(vehicleType) > 0) {
				return floor.park(vehicleType);
			}
		}
		return "";
	}

}
