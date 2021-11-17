package hu.me.iit.webalk.bicycle.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.webalk.bicycle.repository.BicycleEntity;
import hu.me.iit.webalk.bicycle.repository.BicycleRepository;

@Service
public class BicycleServiceImpl implements BicycleService{

	private final BicycleRepository bicycleRepository;
	
	
	public BicycleServiceImpl(BicycleRepository bicycleRepository) {
		this.bicycleRepository = bicycleRepository;
	}

	@Override
	public void save(Bicycle bicycle) {
		Optional<BicycleEntity> optionalBicycleEntity = bicycleRepository.findById(bicycle.getId());
		if(optionalBicycleEntity.isEmpty()) {
			throw new NoSuchEntityException(bicycle.getId());
		}
		bicycleRepository.save(bicycle.toEntity());
		
	}

	@Override
	public Bicycle getById(Long id) {
		Optional<BicycleEntity> optionalBicycleEntity = bicycleRepository.findById(id);
		if(optionalBicycleEntity.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new Bicycle(optionalBicycleEntity.get());
	}

	@Override
	public Iterable<Bicycle> getAllBicycles() {
		return StreamSupport.stream(bicycleRepository.findAll().spliterator(), false).map(Bicycle::new).collect(Collectors.toList());
	}

	@Override
	public Bicycle create(Bicycle bicycle) {
		return new Bicycle(bicycleRepository.save(bicycle.toEntity()));
	}

	@Override
	public void deleteById(Long id) {
//		Optional<BicycleEntity> optionalBicycleEntity = bicycleRepository.findById(id);
//		if(optionalBicycleEntity.isEmpty()) {
//			throw new NoSuchEntityException(id);
//		}
//		bicycleRepository.delete(optionalBicycleEntity.get());
		
		try {
			bicycleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityException(id);
		}
	}

	
}
