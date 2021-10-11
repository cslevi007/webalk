package hu.me.iit.webalk.first;

import java.util.List;

public interface ArticleRepository {
	List<ArticleDto> findAll();
	ArticleDto getByID(Long id);
	Long save(ArticleDto articleDto);
	void deleteById(Long id);
}
