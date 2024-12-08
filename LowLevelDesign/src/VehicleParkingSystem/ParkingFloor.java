package VehicleParkingSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
	
	private int floorId;
	private final int row;
	private final int column;
	private Integer[][] parking;
	private boolean[][] reserved;
	private Map<Integer, Integer> freeSpotsCount = new HashMap<>();
	
	ParkingFloor(int floor, Integer[][] parking){
		this.floorId = floor;
		this.row = parking.length;
		this.column = parking[0].length;
		this.parking = parking;
		this.reserved = new boolean[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				int vehicleType = this.parking[i][j];
				if(0 != vehicleType) {
					freeSpotsCount.put(vehicleType, freeSpotsCount.getOrDefault(vehicleType, 0)+1);
				}
			}
		}
	}
	
	public String park(int vehicleType) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(vehicleType == parking[i][j] && !reserved[i][j]) {
					freeSpotsCount.put(vehicleType, freeSpotsCount.get(vehicleType)-1);
					reserved[i][j] = true;
					return this.floorId+"-"+i+"-"+j;
				}
			}
		}
		return "";
	}
	
	public boolean remove(int row, int column) {
		int vehicleType = parking[row][column];
		if(0==vehicleType || !reserved[row][column]) {
			return false;
		}
		reserved[row][column] = false;
		freeSpotsCount.put(vehicleType, freeSpotsCount.get(vehicleType)+1);
		return true;
	}
	
	public int getFreeSpotsCount(int vehicleType) {
		return freeSpotsCount.getOrDefault(vehicleType, 0);
	}

}
