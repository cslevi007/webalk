package hu.me.iit.webalk.bicycle.service;

public interface BicycleService {
	void save(Bicycle bicycle);
	Bicycle getById(Long id);
	Iterable<Bicycle> getAllBicycles();
	Bicycle create(Bicycle bicycle);
	void deleteById(Long id);
}
