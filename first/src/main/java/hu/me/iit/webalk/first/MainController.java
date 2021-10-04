package hu.me.iit.webalk.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "article")
public class MainController {
	private final List<ArticleDto> articles = new ArrayList<>();

	@GetMapping(path = "")
	public List<ArticleDto> allArticles() {
		return articles;
	}

	@PostMapping(path = "")
	public void newArticle(@RequestBody @Valid ArticleDto articleDto) {
		articles.add(articleDto);
	}

	private int findArticaleById(String id){
		int found = -1;
		for (int i = 0; i < articles.size(); i++){
			if(articles.get(i).getTitle().equals(id)){
				found = i;
				break;
			}
		}
		return found;
	}

	@PutMapping(path = "/{id}")
	public void replaceArticle(@PathVariable("id") String id, @RequestBody @Valid ArticleDto articleDto){
		int found = findArticaleById(id);

		if(found != -1) {
			ArticleDto foundArticle = articles.get(found);
			foundArticle.setAuthor(articleDto.getAuthor());
			foundArticle.setPages(articleDto.getPages());
		}
	}

	@DeleteMapping(path = "/{id}")
	public void deleteArticle(@PathVariable("id") String id){
		int found = findArticaleById(id);

		if(found != -1) articles.remove(found);
	}

}
