package com.ufabc.ufabcsnack.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@Column (name="sellerID")
	private String sellerID;
	
	@Column (name="productPrice")
	private Float productPrice;
	
	@Column (name="productQty")
	private Integer productQty;
		
	@Column (name="productID")
	private Integer productID;

}
