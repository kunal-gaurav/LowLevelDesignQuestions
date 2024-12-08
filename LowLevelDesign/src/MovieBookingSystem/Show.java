package MovieBookingSystem;

public class Show {
	
	final int showId;
	final int movieId;
	final int screenIndex;
	final long startTime;
	final long endTime;
	final Cinema cinema;
	
	public Show(int showId, int movieId, int screenIndex, Cinema cinema, long startTime, long endTime) {
		super();
		this.showId = showId;
		this.movieId = movieId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cinema = cinema;
		this.screenIndex = screenIndex;
	}

	public int getShowId() {
		return showId;
	}

	public int getMovieId() {
		return movieId;
	}
	
	public int getScreenIndex() {
		return screenIndex;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}
	
	public Cinema getCinema() {
		return cinema;
	}

}
