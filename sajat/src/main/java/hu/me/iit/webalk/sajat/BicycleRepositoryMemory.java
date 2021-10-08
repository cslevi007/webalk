package hu.me.iit.webalk.sajat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BicycleRepositoryMemory implements BicycleRepository {

	private final List<BicycleDto> bicycles = new ArrayList<>();
	
	private int findBicycleById(Long id) {
		int found = -1;
		for (int i = 0; i < bicycles.size(); i++) {
			if(bicycles.get(i).getId().equals(id)) {
				found = i;
				break;
			}
			
		}
		return found;
	}
	
	@Override
	public List<BicycleDto> findAll() {
		return bicycles;
	}

	@Override
	public BicycleDto getById(Long id) {
		return null;
	}

	@Override
	public Long save(BicycleDto bicycleDto) {
		int found = findBicycleById(bicycleDto.getId());
		
		if(found != -1) {
			BicycleDto foundBicycle = bicycles.get(found);
			foundBicycle.setBrand(bicycleDto.getBrand());
			foundBicycle.setModel(bicycleDto.getModel());
			foundBicycle.setWheelSize(bicycleDto.getWheelSize());
			foundBicycle.setWeight(bicycleDto.getWeight());
			foundBicycle.setCategory(bicycleDto.getCategory());
		}
		
		return null;
	}

	@Override
	public void deleteById(Long id) {
		int found = findBicycleById(id);
		
		if(found != -1)
			bicycles.remove(found);		
	}

}
