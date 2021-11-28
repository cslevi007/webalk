package hu.me.u678mf.trips.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripRepository extends PagingAndSortingRepository<TripEntity, Long>{
	
}
