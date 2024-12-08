package MovieBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	
	private final int row;
	private final int column;
	private int freeSeatsCount;
	private boolean[][] reserved;
	
	public Screen(int row, int column) {
		this.row = row;
		this.column = column;
		reserved = new boolean[row][column];
		this.freeSeatsCount = this.row*this.column;
	}
	
	int getFreeSeatsCount() {
		return this.freeSeatsCount;
	}
	
	List<String> bookTicket(int ticketsCount) {
		if(this.freeSeatsCount<ticketsCount) {
			return null;
		}
		List<String> bookedSeats = null;
		bookedSeats = bookContinuousSeats(ticketsCount);
		if(null == bookedSeats) {
			bookedSeats = bookRandomSeats(ticketsCount);
		}
		this.freeSeatsCount = this.freeSeatsCount - ticketsCount;
		return bookedSeats;
	}
	
	private List<String> bookRandomSeats(int ticketsCount){
		List<String> bookedSeats = new ArrayList<String>();
		for(int i=0; i<this.row; i++) {
			for(int j=0; j<this.column; j++) {
				bookedSeats.add(i+"-"+j);
				ticketsCount--;
				if(0==ticketsCount) {
					return bookedSeats;
				}
			}
		}
		return bookedSeats;
	}
	
	private List<String> bookContinuousSeats(int ticketsCount){
		List<String> bookedSeats = null;
		for(int i=0; i<this.row; i++) {
			int countinuousFreeSeats=0;
			for(int j=0; j<this.column; j++) {
				if(this.reserved[i][j]) {
					countinuousFreeSeats = 0;
					continue;
				}
				countinuousFreeSeats ++;
				if(ticketsCount == countinuousFreeSeats) {
					bookedSeats = new ArrayList<>();
					for(int k=0; k<ticketsCount; k++) {
						bookedSeats.add(i+"-"+(j-k));
					}
					return bookedSeats;
				}
			}
		}
		return bookedSeats;
	}
	
	boolean cancelTicket(List<String> bookedSeats) {
		for(String seat : bookedSeats) {
			String[] splitSeat = seat.split("-");
			this.reserved[Integer.valueOf(splitSeat[0])][Integer.valueOf(splitSeat[2])] = false;
		}
		return true;
	}

}
