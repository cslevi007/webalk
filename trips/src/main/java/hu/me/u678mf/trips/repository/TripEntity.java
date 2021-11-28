package hu.me.u678mf.trips.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TripEntity {
	@GeneratedValue
	@Id
	private Long id;
	private String destination;
	private Double distance;
	private Integer difficulty;
	
	public TripEntity() {
		super();
	}

	public TripEntity(Long id, String destination, Double distance, Integer difficulty) {
		super();
		this.id = id;
		this.destination = destination;
		this.distance = distance;
		this.difficulty = difficulty;
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
