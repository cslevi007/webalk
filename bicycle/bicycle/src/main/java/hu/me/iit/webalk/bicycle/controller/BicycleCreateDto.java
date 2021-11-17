package hu.me.iit.webalk.bicycle.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hu.me.iit.webalk.bicycle.service.Bicycle;

public class BicycleCreateDto {	
	@NotBlank
	private String brand;
	@NotNull
	private String model;
	@Min(26)
	private Double wheelSize;
	@NotNull
	private Double weight;
	
	public BicycleCreateDto() {
		super();
	}

	public BicycleCreateDto(String brand, String model, Double wheelSize, Double weight) {
		super();
		this.brand = brand;
		this.model = model;
		this.wheelSize = wheelSize;
		this.weight = weight;
	}

	public BicycleCreateDto(Bicycle bicycle) {
		super();
		this.brand = bicycle.getBrand();
		this.model = bicycle.getModel();
		this.wheelSize = bicycle.getWheelSize();
		this.weight = bicycle.getWeight();
	}
	
	
	public Bicycle toBicycle() {
		return new Bicycle(null, brand, model, wheelSize, weight);
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
