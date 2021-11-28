package hu.me.u678mf.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import hu.me.u678mf.service.Trip;

public class TripDto {
	private Long id;
	
	@NotEmpty
	private String destination;
	
	@NotNull
	private Double distance;
	
	@NotNull
	@Min(1)
	private Integer difficulty;

	public TripDto() {
		super();
	}
	
	public TripDto(Long id, String destination, Double distance, Integer difficulty) {
		super();
		this.id = id;
		this.destination = destination;
		this.distance = distance;
		this.difficulty = difficulty;
	}

	public TripDto(Trip trip) {
		super();
		this.id = trip.getId();
		this.destination = trip.getDestination();
		this.distance = trip.getDistance();
		this.difficulty = trip.getDifficulty();
	}
	
	public Trip toTrip() {
		return new Trip(id, destination, distance, difficulty);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
