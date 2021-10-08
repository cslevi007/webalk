package hu.me.iit.webalk.first;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ArticleServiceImpl implements ArticleService{

	private final int MAXIMUM_ARTICLE_COUNT = 10;
    private final ArticleRepository articleRepository;
	
    
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public ArticleDto getByID(Long id) {
		return articleRepository.getByID(id);
	}

	@Override
	public Long save(ArticleDto articleDto) {
		if(articleRepository.findAll().size() > MAXIMUM_ARTICLE_COUNT) {
			throw new TooMuchArticleException();
		}
		return articleRepository.save(articleDto);
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);	
	}

}
