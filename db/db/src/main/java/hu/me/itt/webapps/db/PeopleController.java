package hu.me.itt.webapps.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	private final PeopleService peopleService;
	
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@GetMapping()
	public Iterable<PeopleDto> getAllPeople() {
		List<PeopleDto> peopleDtos = new ArrayList();
		
		for(People people: peopleService.getAllPeople()) {
			peopleDtos.add(new PeopleDto(people));
		}
		
		return peopleDtos;
	}
}
