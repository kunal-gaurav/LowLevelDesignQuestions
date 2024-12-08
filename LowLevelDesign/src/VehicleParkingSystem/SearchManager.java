package VehicleParkingSystem;

import java.util.HashMap;
import java.util.Map;

public class SearchManager {
	
	private Map<String, String> cache = new HashMap<>();
	
	public void index(String spotId, String vehicleNo, String ticketNo) {
		cache.put(ticketNo, spotId);
		cache.put(vehicleNo, spotId);
	}
	
	public String search(String query) {
		return cache.getOrDefault(query, "");
	}

}
