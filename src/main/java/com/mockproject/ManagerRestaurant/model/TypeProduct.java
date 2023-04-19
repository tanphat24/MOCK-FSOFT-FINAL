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
@Table(name = "type_product")
@Data
public class TypeProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int type_product_id;
	
	@Column(name = "TYPE_PRODUCT_NAME")
	private String type_product_name;

	public TypeProduct(int type_product_id, String type_product_name) {
		super();
		this.type_product_id = type_product_id;
		this.type_product_name = type_product_name;
	}

	public TypeProduct() {
		super();
	}

	public int getType_product_id() {
		return type_product_id;
	}

	public void setType_product_id(int type_product_id) {
		this.type_product_id = type_product_id;
	}

	public String getType_product_name() {
		return type_product_name;
	}

	public void setType_product_name(String type_product_name) {
		this.type_product_name = type_product_name;
	}
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "type_product_id", referencedColumnName = "type_product_id")
//    List < Product > products = new ArrayList < > ();
	
}
