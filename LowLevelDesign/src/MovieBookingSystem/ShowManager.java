package MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowManager implements ShowSubject{

	Map<Integer, Show> showCache;
	List<ShowObserver> showObservers;
	
	public ShowManager() {
		showCache = new HashMap<>();
		showObservers = new ArrayList<>();
	}
	
	void addShow(int showId, int movieId, Cinema cinema, int screenIndex, long startTime, long endTime) {
		Show newShow = new Show(showId, movieId, screenIndex, cinema, startTime, endTime); 
		showCache.put(showId, newShow);
		notifyAll(newShow);
	}
	
	public Show getShow(int showId) {
		return showCache.get(showId);
	}

	@Override
	public void addObserver(ShowObserver showObserver) {
		showObservers.add(showObserver);
	}

	@Override
	public void notifyAll(Show show) {
		for(ShowObserver observer : showObservers) {
			observer.update(show);
		}
		
	}
	
}
