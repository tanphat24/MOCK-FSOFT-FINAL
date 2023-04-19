package com.mockproject.ManagerRestaurant.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "order_table")
@Data
public class OrderTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderTableId;

	@Column(name = "ORDER_TABLE_DATE")
	private Date orderTableDate;

	@Column(name = "ORDER_TABLE_NOTE")
	private String orderTableNote;

	@Column(name = "NUMBER_OF_PEOPLE")
	private int numberOfPeople;
	
	@Column(name = "CUSTOMER_ID")
	private Integer userId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_TABLE_ID", referencedColumnName = "orderTableId")
	List<DetailOrder> detailes_o = new ArrayList<>();
	
	public List<DetailOrder> getDetailes_o() {
		return detailes_o;
	}

	public void setDetailes_o(List<DetailOrder> detailes_o) {
		this.detailes_o = detailes_o;
	}

	public OrderTable(int orderTableId, Date orderTableDate, String orderTableNote, int numberOfPeople, int userId) {
		super();
		this.orderTableId = orderTableId;
		this.orderTableDate = orderTableDate;
		this.orderTableNote = orderTableNote;
		this.numberOfPeople = numberOfPeople;
		this.userId = userId;
	}

	public OrderTable() {
		super();
	}

	public int getOrderTableId() {
		return orderTableId;
	}

	public void setOrderTableId(int orderTableId) {
		this.orderTableId = orderTableId;
	}

	public Date getOrderTableDate() {
		return orderTableDate;
	}

	public void setOrderTableDate(Date orderTableDate) {
		this.orderTableDate = orderTableDate;
	}

	public String getOrderTableNote() {
		return orderTableNote;
	}

	public void setOrderTableNote(String orderTableNote) {
		this.orderTableNote = orderTableNote;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderTable [orderTableId=" + orderTableId + ", orderTableDate=" + orderTableDate + ", orderTableNote="
				+ orderTableNote + ", numberOfPeople=" + numberOfPeople + ", userId=" + userId + ", detailes_o="
				+ detailes_o + "]";
	}

}