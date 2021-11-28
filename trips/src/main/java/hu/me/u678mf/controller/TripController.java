package hu.me.u678mf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.u678mf.service.Trip;
import hu.me.u678mf.service.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {
	
	private final TripService tripService;

	public TripController(TripService tripService) {
		super();
		this.tripService = tripService;
	}
	
	@GetMapping
	public Iterable<TripDto> getAllTrips(){
		List<TripDto> list = new ArrayList<>();
		
		for (Trip trip : tripService.findAll()) {
			list.add(new TripDto(trip));
		}
		
		return list;
	}
	
	@GetMapping("/{id}")
	public TripDto getTripById(@PathVariable Long id) {
		return new TripDto(tripService.findById(id));
	}
	
	@PostMapping(consumes = "application/json")
	public TripDto createTrip(@RequestBody @Valid TripCreateDto tripCreateDto) {
		return new TripDto(tripService.create(tripCreateDto.toTrip()));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTrip(@PathVariable Long id) {
		tripService.deleteTripById(id);
	}
	
	@PutMapping
	public TripDto updateTrip(@RequestBody @Valid TripDto tripDto) {
		return new TripDto(tripService.updateTrip(tripDto.toTrip()));
	}
	
	@PatchMapping
	public TripDto patchTrip(@RequestBody TripDto tripDto) {
		return new TripDto(tripService.patchTrip(tripDto.toTrip()));
	}
}
