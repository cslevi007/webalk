package hu.me.itt.webapps.db.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import hu.me.itt.webapps.db.service.People;
import hu.me.itt.webapps.db.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	
	private final PeopleService peopleService;
	
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@GetMapping
	public Iterable<PeopleDto> getAllPeople() {
		List<PeopleDto> peopleDtos = new ArrayList<>();
		
		for(People people: peopleService.getAllPeople()) {
			peopleDtos.add(new PeopleDto(people));
		}
		
		return peopleDtos;
	}
	
	@GetMapping("/{id}")
	public PeopleDto getById(@PathVariable Long id) {
		return new PeopleDto(peopleService.getById(id));
	}
	
	@PostMapping(consumes = "application/json")
    public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto){
       return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }
	
	 @DeleteMapping("/{id}")
	 public void deleteById(@PathVariable Long id) {
	        peopleService.deleteById(id);
	 }
	 
	 @PutMapping
	 public void save(@RequestBody @Valid PeopleDto peopleDto) {
		 peopleService.save(peopleDto.toPeople());
	 }
}
