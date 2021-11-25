package controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.LicitService;

@RestController
@RequestMapping("/licit")
public class LicitController {
	
	private final LicitService licitService;

	public LicitController(LicitService licitService) {
		super();
		this.licitService = licitService;
	}

	@GetMapping("/highest")
	public int getHighestLicit() {
		return licitService.getHighest();
	}
	
	@GetMapping("/highest/{userId}")
	public int getHighestLicitByUser(@PathVariable int userId) {
		return licitService.getHighestByUser(userId);
	}
	
	@PostMapping
	public void saveNewLicit(@Valid @RequestBody SaveLicitDto saveLicitDto) {
		licitService.save(saveLicitDto.getLicit(), saveLicitDto.getUserId());
	}
}
