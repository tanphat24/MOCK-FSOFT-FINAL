package com.mockproject.ManagerRestaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
//@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_PRICE")
	private Double productPrice;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name = "PRODUCT_IMAGE")
	private String productImage;
	
	@Column(name = "TYPE_PRODUCT_ID")
	private int typeProductId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "productId")
	List<DetailOrder> detailes_p = new ArrayList<>();

	public List<DetailOrder> getDetailes() {
		return detailes_p;
	}

	public void setDetailes(List<DetailOrder> detailes) {
		this.detailes_p = detailes;
	}

	public Product(int productId, String productName, Double productPrice, String productDescription,
			String productImage, int typeProductId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.typeProductId = typeProductId;
	}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getTypeProductId() {
		return typeProductId;
	}

	public void setTypeProductId(int typeProductId) {
		this.typeProductId = typeProductId;
	}
}
