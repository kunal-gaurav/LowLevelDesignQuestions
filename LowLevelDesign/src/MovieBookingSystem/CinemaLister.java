package MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaLister implements ShowObserver {
	
	private Map<String, List<Cinema>> cache;
	
	public CinemaLister() {
		// TODO Auto-generated constructor stub
		cache = new HashMap<>();
	}

	@Override
	public void update(Show show) {
		// TODO Auto-generated method stub
		String key = ""+show.getMovieId()+"-"+show.getCinema().getCityId();
		List<Cinema> cinemas = cache.getOrDefault(key, new ArrayList<>());
		cinemas.add(show.getCinema());
		cache.put(key, cinemas);
	}
	
	public List<Integer> listCinema(int movieId, int cityId){
		List<Cinema> cinemas = new ArrayList<>();
		String key = ""+movieId+"-"+cityId;
		cinemas = cache.get(key);
		cinemas.sort((a,b)->{return a.getCinemaId()-b.getCinemaId();});
		return cinemas.stream().map(c->c.getCinemaId()).collect(Collectors.toList());
	}

}
