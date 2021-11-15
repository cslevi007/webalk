package hu.me.itt.webapps.db.service;

public interface PeopleService {
	Iterable<People> getAllPeople();
	
	People create(People toPeople);
	
	void deleteById(Long id);
	
	People getById(Long id);
	
	void save(People people);
}
