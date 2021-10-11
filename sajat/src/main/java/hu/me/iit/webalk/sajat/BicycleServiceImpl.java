package hu.me.iit.webalk.sajat;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BicycleServiceImpl implements BicycleService{

	private final int MAXIMUM_BICYCLE_COUNT = 10;
	private final BicycleRepository bicycleRepository;
	
	public BicycleServiceImpl(BicycleRepository bicycleRepository) {
		super();
		this.bicycleRepository = bicycleRepository;
	}

	@Override
	public List<BicycleDto> findAll() {
		return bicycleRepository.findAll();
	}

	@Override
	public BicycleDto getById(Long id) {
		return bicycleRepository.getById(id);
	}

	@Override
	public Long save(BicycleDto bicycleDto) {
		if(bicycleRepository.findAll().size() > MAXIMUM_BICYCLE_COUNT)
			throw new TooMuchBicycleException();
		
		return bicycleRepository.save(bicycleDto);
	}

	@Override
	public void deleteById(Long id) {
		bicycleRepository.deleteById(id);		
	}

}
