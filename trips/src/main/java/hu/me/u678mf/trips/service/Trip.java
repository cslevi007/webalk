package hu.me.u678mf.trips.service;

import hu.me.u678mf.trips.repository.TripEntity;

public class Trip {
	
	private Long id;
	private String destination;
	private Double distance;
	private Integer difficulty;
	
	public Trip() {
		super();
	}

	public Trip(Long id, String destination, Double distance, Integer difficulty) {
		super();
		this.id = id;
		this.destination = destination;
		this.distance = distance;
		this.difficulty = difficulty;
	}
	
	public Trip(TripEntity tripEntity) {
		super();
		this.id = tripEntity.getId();
		this.destination = tripEntity.getDestination();
		this.distance = tripEntity.getDistance();
		this.difficulty = tripEntity.getDifficulty();
	}
	
	public TripEntity toEntity() {
		return new TripEntity(id, destination, distance, difficulty);
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
