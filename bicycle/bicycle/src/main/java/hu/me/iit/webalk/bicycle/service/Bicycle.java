package hu.me.iit.webalk.bicycle.service;

import hu.me.iit.webalk.bicycle.repository.BicycleEntity;

public class Bicycle {
	
	private Long id;
	
	private String brand;
	private String model;
	private Double wheelSize;
	private Double weight;
	
	public Bicycle() {
		
	}

	public Bicycle(Long id, String brand, String model, Double wheelSize, Double weight) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.wheelSize = wheelSize;
		this.weight = weight;
	}
	
	//Constructor to create Bicycle from BicycleEntity
	//aka convert BicicyleEntity to Bicycle
	public Bicycle(BicycleEntity bicycleEntity) {
		this.id = bicycleEntity.getId();
		this.brand = bicycleEntity.getBrand();
		this.model = bicycleEntity.getModel();
		this.wheelSize = bicycleEntity.getWheelSize();
		this.weight = bicycleEntity.getWeight();
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
	
	//Converts Bicycle to BicycleEntity
	public BicycleEntity toEntity() {
		return new BicycleEntity(id, brand, model, wheelSize, weight);
	}
}
