package hu.me.iit.webalk.sajat;

import java.util.List;

public interface BicycleRepository {
	List<BicycleDto> findAll();
	BicycleDto getById(Long id);
	Long save(BicycleDto bicycleDto);
	void deleteById(Long id);
}
