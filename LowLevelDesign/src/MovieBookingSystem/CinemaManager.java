package MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaManager {

	Map<Integer, Cinema> cinemaCache;
	
	public CinemaManager() {
		this.cinemaCache = new HashMap<>();
	}
	
	void addCinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenColumn) {
		Cinema newCinema = new Cinema(cinemaId, cityId, screenCount, screenRow, screenColumn);
		cinemaCache.put(cinemaId, newCinema);
	}
	
	public Cinema getCinema(int cinemId) {
		return this.cinemaCache.get(cinemId);
	}
}
