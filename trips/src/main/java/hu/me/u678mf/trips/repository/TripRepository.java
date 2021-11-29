package hu.me.u678mf.trips.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TripRepository extends PagingAndSortingRepository<TripEntity, Long>{
	
	Optional<TripEntity> findTopByOrderByDistanceDesc();
	
	Iterable<TripEntity> findTop2ByDifficultyBetweenOrderByDifficultyDesc(Integer low, Integer high);
	
	Integer countByDistanceGreaterThan(Double dist);
	
}
