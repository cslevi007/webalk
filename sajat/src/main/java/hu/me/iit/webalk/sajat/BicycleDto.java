package hu.me.iit.webalk.sajat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BicycleDto {

	@NotNull
	private Long id;
	
	@NotBlank
	private String brand;
	
	@NotNull
	private String model;

	@Min(24)
	@Max(29)
	private Double wheelSize;
	
	private Double weight; 
	
	private Category category;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BicycleDto [id=" + id + ", brand=" + brand + ", model=" + model + ", wheelSize=" + wheelSize
				+ ", weight=" + weight + ", category=" + category + "]";
	}
}
