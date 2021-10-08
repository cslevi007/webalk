package hu.me.iit.webalk.sajat;

import java.util.List;

public interface BicycleService {
	List<BicycleDto> findAll();
	BicycleDto getById(Long id);
	Long save(BicycleDto bicycleDto);
	void deleteById(Long id);
}
