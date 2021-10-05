package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

public class ArticlerepositoryMemoryImpl  implements ArticleRepository{
	private final List<ArticleDto> articles = new ArrayList<>();

	@Override
	public List<ArticleDto> findAll() {
		return null;
	}

	@Override
	public ArticleDto getByID(Long id) {
		return null;
	}

	@Override
	public Long save(ArticleDto articleDto) {
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
	}

}
