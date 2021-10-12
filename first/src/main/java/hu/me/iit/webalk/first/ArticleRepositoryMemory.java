package hu.me.iit.webalk.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ArticleRepositoryMemory implements ArticleRepository{

	private final List<ArticleDto> articles = new ArrayList<>();
	
	public int findArticleById(Long id) {
		int found = -1;
		for (int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getId().equals(id)) {
				found = i;
				break;
			}
			
		}
		return found;
	}
	
	public List<ArticleDto> findAll() {
		return articles;
	}

	public ArticleDto getById(Long id) {
		int articleByIdIndex = findArticleById(id);

        return articleByIdIndex == -1 ? null : articles.get(articleByIdIndex);
	}

	public Long save(ArticleDto articleDto) {
		int found = findArticleById(articleDto.getId());
		
		if(found != -1) {
			ArticleDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articleDto.getAuthor());
			foundArticle.setTitle(articleDto.getTitle());
			foundArticle.setPages(articleDto.getPages());
		} else {
			articles.add(articleDto);
		}
		
		return null;
	}

	public void deleteById(Long id) {
		int found = findArticleById(id);
		
		if(found != -1)
			articles.remove(found);
	}
}
