package repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LicitRepository extends PagingAndSortingRepository<LicitEntity, Long>{

	Optional<LicitEntity> findTopByUserIdAndOrderByLicitDesc(int userId);

	Optional<LicitEntity> findTopByOrderByLicitDesc();

}
