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

}
