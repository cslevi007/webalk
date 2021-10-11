package hu.me.iit.webalk.first;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ArticleRepositoryTest {

	@Test
	void testFindAll_Empty() {
		//GIVEN
		ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
		
		//WHEN
		List<ArticleDto> result = articleRepositoryMemory.findAll();
		
		//THEN
		assertEquals(8, result.size());
	}

	@Test
	void testFindAll_NotEmpty() {
		//GIVEN
		ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("Author");
		articleDto.setPages(23);
		articleDto.setId(2L);
		articleDto.setTitle("title");
		
		articleRepositoryMemory.save(articleDto);
		
		
				
		//WHEN
		List<ArticleDto> result = articleRepositoryMemory.findAll();
				
		//THEN
		assertEquals(1, result.size());
		assertEquals()
	}
	
	@Test
	void testFindArticleById(Long id){
		//GIVEN
		ArticleRepositoryMemory articleRepositoryMemory = new ArticleRepositoryMemory();
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("Author");
		articleDto.setPages(23);
		articleDto.setId(2L);
		articleDto.setTitle("title");
				
		articleRepositoryMemory.save(articleDto);
				
				
						
		//WHEN
		int result = articleRepositoryMemory.getByID(id);
					
		//THEN
		assertEquals(0, result);
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
