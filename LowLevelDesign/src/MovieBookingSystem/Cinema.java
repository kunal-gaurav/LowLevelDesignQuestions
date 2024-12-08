package MovieBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class Cinema {
	
	final int cinemaId;
	final int cityId;
	final int screenCount;
	final int screenRow;
	final int screenColumn;
	
	public Cinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenColumn) {
		this.cinemaId = cinemaId;
		this.cityId = cityId;
		this.screenCount = screenCount;
		this.screenRow = screenRow;
		this.screenColumn = screenColumn;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public int getCityId() {
		return cityId;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public int getScreenRow() {
		return screenRow;
	}

	public int getScreenColumn() {
		return screenColumn;
	}

}
