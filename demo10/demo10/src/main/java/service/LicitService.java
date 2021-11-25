package service;

public interface LicitService {

	int getHighest();

	int getHighestByUser(int userId);

	void save(Integer licit, Integer userId);


}
