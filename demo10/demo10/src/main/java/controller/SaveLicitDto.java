package controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import service.Licit;

public class SaveLicitDto {

	@NotNull
	@Min(1)
	private Integer licit;
	
	@NotNull
	@Min(1)
	private Integer userId;

	public SaveLicitDto() {
		super();
	}
	
	public SaveLicitDto(Integer licit, Integer userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}

	public SaveLicitDto(Licit licit) {
		super();
		this.licit = licit.getLicit();
		this.userId = licit.getUserId();
	}
	
	public Licit toLicit() {
		return new Licit(licit, userId);
	}


	public Integer getLicit() {
		return licit;
	}

	public void setLicit(Integer licit) {
		this.licit = licit;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
