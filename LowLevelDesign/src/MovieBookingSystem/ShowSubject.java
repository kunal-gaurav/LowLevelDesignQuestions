package MovieBookingSystem;

public interface ShowSubject {
	
	void addObserver(ShowObserver showObserver);
	
	void notifyAll(Show show);
	

}
