package hu.me.iit.webalk.bicycle.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hu.me.iit.webalk.bicycle.service.Bicycle;

public class BicycleDto {
	
	private Long id;
	
	@NotBlank
	private String brand;
	@NotNull
	private String model;
	@Min(26)
	private Double wheelSize;
	@NotNull
	private Double weight;
	
	public BicycleDto() {
		super();
	}

	public BicycleDto(Long id, String brand, String model, Double wheelSize, Double weight) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.wheelSize = wheelSize;
		this.weight = weight;
	}

	public BicycleDto(Bicycle bicycle) {
		super();
		this.id = bicycle.getId();
		this.brand = bicycle.getBrand();
		this.model = bicycle.getModel();
		this.wheelSize = bicycle.getWheelSize();
		this.weight = bicycle.getWeight();
	}
	
	
	public Bicycle toByBicycle() {
		return new Bicycle(id, brand, model, wheelSize, weight);
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
