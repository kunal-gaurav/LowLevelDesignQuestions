package VehicleParkingSystem;

public class ParkingLotSolution {
	
	private ParkingFloor[] floors;
	private SearchManager searchManager = new SearchManager();
	private ParkingManager parkingManager = new ParkingManager();
	private int[] vehicleTypes = {2,4};
	
	public void init(Integer[][][] parking) {
		floors = new ParkingFloor[parking.length];
		for(int i=0; i<floors.length; i++) {
			floors[i] = new ParkingFloor(i, parking[i]);
		}
	}
	
	public String parkVehicle(int vehicleType, int strategy, String vehicleNo, String ticketNo) {
		String spotId = parkingManager.park(floors, vehicleType, strategy);
		if(!spotId.isEmpty()) {
			searchManager.index(spotId, vehicleNo, ticketNo);
		}
		return spotId;
	}
	
	public boolean removeVehicle(String spotId) {
		String[] spotArr = spotId.split("-");
		int floor = Integer.parseInt(spotArr[0]);
		return floors[floor].remove(Integer.parseInt(spotArr[1]), Integer.parseInt(spotArr[2]));
	}
	
	public String searchVehicle(String query) {
		return searchManager.search(query);
	}
	
	public int getFreeSpotsCount(int floor, int vehicleType) {
		return floors[floor].getFreeSpotsCount(vehicleType);
	}

}
