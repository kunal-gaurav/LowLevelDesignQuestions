package MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowLister implements ShowObserver {
	
	private Map<String, List<Show>> cache; 
	
	ShowLister(){
		this.cache = new HashMap<>();
	}

	@Override
	public void update(Show show) {
		String key = ""+show.getMovieId()+"-"+show.getCinema().getCinemaId();
		List<Show> shows = cache.getOrDefault(key, new ArrayList<>());
		cache.put(key, shows);
	}
	
	
	public List<Integer> listShow(int movieId, int cinemaId){
		List<Integer> showList = new ArrayList<>();
		String key = ""+movieId+"-"+cinemaId;
		List<Show> shows = cache.get(key);
		if(null != shows) {
			shows.sort((a,b)-> {
				return a.getStartTime()!=b.getStartTime() ?
						Long.valueOf(b.getStartTime()).compareTo(Long.valueOf(a.getStartTime())) :
						b.getShowId()-a.getShowId();
			});
		}
		return shows.stream().map(s->s.getShowId()).collect(Collectors.toList());
	}

}
