package hu.me.u678mf.trips.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.me.u678mf.trips.repository.TripEntity;
import hu.me.u678mf.trips.repository.TripRepository;
import hu.me.u678mf.trips.service.exceptions.CannotUpdateNonExistingElementException;
import hu.me.u678mf.trips.service.exceptions.NoSuchTripException;

@Service
public class TripServiceImpl implements TripService{

	private final TripRepository tripRepository;
	
	public TripServiceImpl(TripRepository tripRepository) {
		super();
		this.tripRepository = tripRepository;
	}

	@Override
	public Trip create(Trip trip) {
		return new Trip(tripRepository.save(trip.toEntity()));
	}

	@Override
	public void deleteTripById(Long id) {
		if(tripRepository.existsById(id)) {
			tripRepository.deleteById(id);
		} else {
			throw new NoSuchTripException(id);
		}
	}

	@Override
	public Iterable<Trip> findAll() {
//		return StreamSupport.stream(tripRepository.findAll().spliterator(), false)
//				.map(Trip::new)
//				.collect(Collectors.toList());
		
		return StreamSupport.stream(tripRepository.findAll().spliterator(), false).map(Trip::new).collect(Collectors.toList());
	}

	@Override
	public Trip findById(Long id) {
		Optional<TripEntity> optional = tripRepository.findById(id);
		if(optional.isEmpty()) {
			throw new NoSuchTripException(id);
		}
		
		return new Trip(optional.get());
	}

	@Override
	public Trip updateTrip(Trip trip) {
		if(tripRepository.existsById(trip.getId())) {
			Trip trip2 = new Trip();
			
			trip2.setId(trip.getId());
			trip2.setDestination(trip.getDestination());
			trip2.setDistance(trip.getDistance());
			trip2.setDifficulty(trip.getDifficulty());
			
			return new Trip(tripRepository.save(trip2.toEntity()));
			
		} else {
			throw new CannotUpdateNonExistingElementException(trip);
		}
	}

	@Override
	public Trip patchTrip(Trip trip) {
		Optional<TripEntity> optional = tripRepository.findById(trip.getId());
		
		if(!optional.isEmpty()) {
			
			Trip updatedTrip = new Trip(optional.get());
			
			if(!trip.getDestination().isEmpty()) {
				updatedTrip.setDestination(trip.getDestination());
			}
			
			if(trip.getDistance() != null) {
				updatedTrip.setDistance(trip.getDistance());
			}
			
			if(trip.getDifficulty() != null) {
				updatedTrip.setDifficulty(trip.getDifficulty());
			}
			
			return new Trip(tripRepository.save(updatedTrip.toEntity()));
			
		} else {
			throw new CannotUpdateNonExistingElementException(trip);
		}
	}

}
