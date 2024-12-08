package VehicleParkingSystem;

public class MostFreeSpotParkingStrategy implements ParkingStrategy {

	@Override
	public String park(ParkingFloor[] floors, int vehicleType) {
		int freeSpotsCount  = 0;
		int floorIndex = -1;
		for(int i=0; i<floors.length; i++) {
			int temp = floors[i].getFreeSpotsCount(vehicleType);
			if(temp<=freeSpotsCount) {
				continue;
			}
			freeSpotsCount = temp;
			floorIndex = i;
		}
		if(floorIndex>=0) {
			return floors[floorIndex].park(vehicleType);
		}
		return "";
	}

}
