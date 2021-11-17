package hu.me.iit.webalk.bicycle.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webalk.bicycle.service.Bicycle;
import hu.me.iit.webalk.bicycle.service.BicycleService;

@RestController
@RequestMapping("/bicycle")
public class BicycleController {

	private final BicycleService bicycleService;

	public BicycleController(BicycleService bicycleService) {
		super();
		this.bicycleService = bicycleService;
	}
	
	@GetMapping("/{id}")
	public BicycleDto getBicycleById(@PathVariable Long id) {
		return new BicycleDto(bicycleService.getById(id));
	}
	
	@GetMapping
	public Iterable<BicycleDto> getAllBicycle(){
		List<BicycleDto> bicycleDtos = new ArrayList<BicycleDto>();
		
		for (Bicycle bicycle : bicycleService.getAllBicycles()) {
			bicycleDtos.add(new BicycleDto(bicycle));
		}
		
		return bicycleDtos;
	}
	
	@PostMapping(consumes = "application/json")
	public BicycleDto save(@RequestBody @Valid BicycleCreateDto bicycleCreateDto) {
		return new BicycleDto(bicycleService.create(bicycleCreateDto.toBicycle()));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		bicycleService.deleteById(id);
	}
	
	@PutMapping
	public void save(@RequestBody @Valid BicycleDto bicycleDto) {
		bicycleService.save(bicycleDto.toByBicycle());
	}
}
