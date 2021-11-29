package hu.me.u678mf.trips.service;

public interface TripService {
	
	Trip create(Trip trip);
	void deleteTripById(Long id);
	Iterable<Trip> findAll();
	Trip findById(Long id);
	Trip updateTrip(Trip trip);
	Trip patchTrip(Trip trip);
	
	//custom queries
	Trip findLongestDistance();
	Iterable<Trip> findTop2BetweenDifficulty(Integer low, Integer high);
	Integer countOfGreaterDistanceTripsThan(Double dist);
}	
