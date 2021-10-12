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
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(2L);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        List<ArticleDto> result = articleMemoryRepository.findAll();

        // THEN
        assertEquals(1, result.size());
        assertEquals(articleDto, result.get(0));
	}
	
	@Test
	void testFindArticleById(){
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        int result = articleMemoryRepository.findArticleById(id);

        // THEN
        assertEquals(0, result);
	}
	
	@Test
	void testFindArticleById_NotFound(){
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        int result = articleMemoryRepository.findArticleById(notExistsId);

        // THEN
        assertEquals(-1, result);
	}
	
	@Test
	void testDeleteById_Exists() {
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        articleMemoryRepository.deleteById(id);

        // THEN
        assertEquals(0, articleMemoryRepository.findAll().size());
	}
	
	@Test
	void testDeleteById_NotExists() {
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        articleMemoryRepository.deleteById(notExistsId);

        // THEN
        assertEquals(1, articleMemoryRepository.findAll().size());
	}
	
	@Test
	void testGetById_Exists() {
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto dto = articleMemoryRepository.getById(id);

        // THEN
        assertEquals(articleDto, dto);
	}
	
	@Test
	void testGetById_NotExists() {
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        Long notExistsId = 4L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto dto = articleMemoryRepository.getById(notExistsId);

        // THEN
        assertNull(dto);
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSave_Update() {
		// GIVEN
		ArticleRepositoryMemory articleMemoryRepository = new ArticleRepositoryMemory();
        Long id = 2L;
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthor("Author");
        articleDto.setPages(23);
        articleDto.setId(id);
        articleDto.setTitle("title");

        articleMemoryRepository.save(articleDto);

        // WHEN
        ArticleDto articleDto2 = new ArticleDto();
        articleDto2.setAuthor("Author 2");
        articleDto2.setPages(14);
        articleDto2.setId(id);
        articleDto2.setTitle("title 2");

        articleMemoryRepository.save(articleDto2);

        // THEN
        List<ArticleDto> articleDtoList = articleMemoryRepository.findAll();
        assertEquals(1, articleDtoList.size());

        assertEquals(articleDto2, articleDtoList.get(0));
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
