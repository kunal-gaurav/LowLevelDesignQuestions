package MovieBookingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketBookingManager {
	
	private Map<String, Booking> bookingsCache;
	private Map<Integer, Screen> screenCache;
	
	public TicketBookingManager() {
		this.bookingsCache = new HashMap<>();
		this.screenCache = new HashMap<>();
	}
	
	public List<String> bookTicket(String ticketId, Show show, int seatCount) {
		if(!screenCache.containsKey(show.getShowId())) {
			screenCache.put(show.getShowId(), new Screen(show.getCinema().getScreenRow(), show.getCinema().getScreenRow()));
		}
		Screen screen = screenCache.get(show.getShowId());
		List<String> seats = screen.bookTicket(seatCount);
		Booking newBooking = new Booking(ticketId, seatCount, BookingStatus.BOOKED, seats, show.getShowId());
		bookingsCache.put(ticketId, newBooking);
		return seats;
	}
	
	public Booking getBooking(String ticketId) {
		if(bookingsCache.containsKey(ticketId)) {
			return bookingsCache.get(ticketId);
		}
		return null;
	}
	
	public boolean cancelTicket(String ticketId) {
		Booking booking = bookingsCache.get(ticketId);
		if(null==booking || BookingStatus.CANCELED == booking.getBookingStatus()) {
			return false;
		}
		Screen screen = screenCache.get(booking.getShowId());
		screen.cancelTicket(booking.getSeats());
		booking.setBookingStatus(BookingStatus.CANCELED);
		return true;
	}
	
	public int getFreeSeatsCount(Show show) {
		Screen screen = screenCache.get(show.getShowId());
		if(null==screen) {
			screen = new Screen(show.getCinema().getScreenRow(), show.getCinema().getScreenColumn());
			screenCache.put(show.getShowId(), screen);
		}
		return screen.getFreeSeatsCount();
	}

}
