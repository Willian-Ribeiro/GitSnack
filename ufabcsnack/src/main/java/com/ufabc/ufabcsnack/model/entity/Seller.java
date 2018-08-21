package com.ufabc.ufabcsnack.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Seller")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	
	@Column (name="sellerDesc")
	private String sellerDesc;
	
	@Column (name="sellerName")
	private String sellerName;
	
	@Column (name="positionX")
	private float positionX;
	
	@Column (name="positionY")
	private float positionY;
		
	@Column (name="status")
	private int status;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getSellerDesc() {
		return sellerDesc;
	}

	public void setSellerDesc(String sellerDesc) {
		this.sellerDesc = sellerDesc;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	

}
