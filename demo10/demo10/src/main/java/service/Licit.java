package service;

import controller.SaveLicitDto;
import repository.LicitEntity;

public class Licit {
	
	private Integer licit;
	
	private Integer userId;
	
	public Licit() {
		super();
	}

	public Licit(Integer licit, Integer userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}

	public Licit(LicitEntity licitEntity) {
		super();
		this.licit = licitEntity.getLicit();
		this.userId = licitEntity.getUserId();
	}
	
	public LicitEntity toLicitEntity() {
		return new LicitEntity(licit, userId);
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
