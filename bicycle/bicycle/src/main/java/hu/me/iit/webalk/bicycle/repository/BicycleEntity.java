package hu.me.iit.webalk.bicycle.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BicycleEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String brand;
	private String model;
	private Double wheelSize;
	private Double weight;
	
	
	
	public BicycleEntity() {
		
	}

	public BicycleEntity(Long id, String brand, String model, Double wheelSize, Double weight) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.wheelSize = wheelSize;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getWheelSize() {
		return wheelSize;
	}

	public void setWheelSize(Double wheelSize) {
		this.wheelSize = wheelSize;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	} 
	
}
