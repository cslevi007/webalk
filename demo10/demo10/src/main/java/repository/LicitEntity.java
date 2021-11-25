package repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import service.Licit;

@Entity
public class LicitEntity {
	
	private Integer licit;
	
	private Integer userId;
	
	@Id
	@GeneratedValue
	private Long id;

	
	public LicitEntity() {
		super();
	}


	public LicitEntity(Integer licit, Integer userId) {
		super();
		this.licit = licit;
		this.userId = userId;
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
