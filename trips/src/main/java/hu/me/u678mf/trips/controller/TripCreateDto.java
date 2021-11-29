package hu.me.u678mf.trips.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import hu.me.u678mf.trips.service.Trip;

public class TripCreateDto {
	@NotEmpty
	private String destination;
	
	@NotNull
	private Double distance;
	
	@NotNull
	@Min(1)
	private Integer difficulty;

	public TripCreateDto() {
		super();
	}
	
	public TripCreateDto(Long id, String destination, Double distance, Integer difficulty) {
		super();
		this.destination = destination;
		this.distance = distance;
		this.difficulty = difficulty;
	}

	public TripCreateDto(Trip trip) {
		super();
		this.destination = trip.getDestination();
		this.distance = trip.getDistance();
		this.difficulty = trip.getDifficulty();
	}
	
	public Trip toTrip() {
		return new Trip(null, destination, distance, difficulty);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
}
