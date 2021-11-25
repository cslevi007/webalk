package service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import repository.LicitEntity;
import repository.LicitRepository;

@Service
public class LicitServiceImpl implements LicitService{

	private LicitRepository licitRepository;
	
	public LicitServiceImpl(LicitRepository licitRepository) {
		super();
		this.licitRepository = licitRepository;
	}

	@Override
	public int getHighest() {
		Optional<LicitEntity> optional = licitRepository.findTopByOrderByLicitDesc();
		if(optional.isEmpty()) {
			return 0;
		}
		return optional.get().getLicit();
	}

	public int getHighestByUser(int userId) {
		Optional<LicitEntity> optional = licitRepository.findTopByUserIdAndOrderByLicitDesc(userId);
		if(optional.isEmpty()) {
			return 0;
		}
		return optional.get().getLicit(); 
	}

	@Override
	public void save(Integer licit, Integer userId) {
		licitRepository.save(new LicitEntity(licit, userId));
	}

	

}
