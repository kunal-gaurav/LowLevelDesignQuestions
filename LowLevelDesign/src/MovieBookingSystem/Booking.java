package MovieBookingSystem;

import java.util.List;

public class Booking {
	
	private String ticketId;
	private int seatCount;
	private BookingStatus bookingStatus;
	private List<String> seats;
	private int showId;
	
	public Booking(String ticketId, int seatCount, BookingStatus bookingStatus, List<String> seats, int showId) {
		this.ticketId = ticketId;
		this.seatCount = seatCount;
		this.bookingStatus = bookingStatus;
		this.seats = seats;
		this.showId = showId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<String> getSeats() {
		return seats;
	}

	public int getShowId() {
		return showId;
	}
}
