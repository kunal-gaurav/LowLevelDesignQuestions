package MovieBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class MovieBookingSystemSolution {

	private CinemaManager cinemaManager;
	private ShowManager showManager;
	private ShowLister showLister;
	private CinemaLister cinemaLister;
	private TicketBookingManager bookingManager;
	
	public MovieBookingSystemSolution() {
		this.cinemaManager = new CinemaManager();
		this.showManager = new ShowManager();
		this.bookingManager = new TicketBookingManager();
		this.showLister = new ShowLister();
		this.cinemaLister = new CinemaLister();
		showManager.addObserver(showLister);
		showManager.addObserver(cinemaLister);
	}
	
	public void addCinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenColumn) {
		cinemaManager.addCinema(cinemaId, cityId, screenCount, screenRow, screenColumn);
	}
	
	public void addShow(int showId, int movieId, int cinemaId, int screenIndex, long startTime, long endTime) {
		showManager.addShow(showId, movieId, cinemaManager.getCinema(cinemaId), screenIndex,  startTime, startTime);
	}
	
	public List<String> bookTicket(String ticketId, int showId, int ticketsCount){
		Show show = showManager.getShow(showId);
		if(null==show) {
			return new ArrayList<>();
		}
		List<String> bookedSeats = bookingManager.bookTicket(ticketId, show, ticketsCount);
		return bookedSeats;
	}
	
	public boolean cancelTicket(String ticketId) {
		return bookingManager.cancelTicket(ticketId);
	}
	
	public int getFreeSeatsCount(int showId) {
		Show show = showManager.getShow(showId);
		if(null == show) {
			return 0;
		}
		return bookingManager.getFreeSeatsCount(show);
	}
	
	public List<Integer> listCinemas(int movieId, int cityId){
		return cinemaLister.listCinema(movieId, cityId);
	}
	
	public List<Integer> listShow(int movieId, int cinemId){
		return showLister.listShow(movieId, cinemId);
	}
}
