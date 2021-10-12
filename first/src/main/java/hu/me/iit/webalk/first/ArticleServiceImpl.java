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

	public List<ArticleDto> findAll() {
		return articleRepository.findAll();
	}

	public ArticleDto getById(Long id) {
		return articleRepository.getById(id);
	}

	public Long save(ArticleDto articleDto) {
		if(articleRepository.findAll().size() > MAXIMUM_ARTICLE_COUNT) {
			throw new TooMuchArticleException();
		}
		return articleRepository.save(articleDto);
	}

	public void deleteById(Long id) {
		articleRepository.deleteById(id);	
	}

}
