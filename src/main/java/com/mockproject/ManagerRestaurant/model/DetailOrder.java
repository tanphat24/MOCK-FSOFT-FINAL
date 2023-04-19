package com.mockproject.ManagerRestaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_order")
public class DetailOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAIL_ORDER_ID")
	private Integer orderDetailId;
	
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Column(name = "ORDER_TABLE_ID")
	private Integer orderTableId;
	
	@Column(name = "DETAIL_ORDER_QUANTITY")
	private int detailOrderQuantity;
	
	@Column(name = "DETAIL_ORDER_NOTE")
	private String detailOrderNote;
	
	@Column(name = "STATUS")
	private int status;

	public DetailOrder(Integer orderDetailId, Integer productId, Integer orderTableId, int detailOrderQuantity,
			String detailOrderNote, int status) {
		super();
		this.orderDetailId = orderDetailId;
		this.productId = productId;
		this.orderTableId = orderTableId;
		this.detailOrderQuantity = detailOrderQuantity;
		this.detailOrderNote = detailOrderNote;
		this.status = status;
	}

	

	public DetailOrder() {
		super();
	}

	

	public Integer getOrderDetailId() {
		return orderDetailId;
	}



	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}



	public Integer getProductId() {
		return productId;
	}



	public void setProductId(Integer productId) {
		this.productId = productId;
	}



	public Integer getOrderTableId() {
		return orderTableId;
	}



	public void setOrderTableId(Integer orderTableId) {
		this.orderTableId = orderTableId;
	}



	public int getDetailOrderQuantity() {
		return detailOrderQuantity;
	}



	public void setDetailOrderQuantity(int detailOrderQuantity) {
		this.detailOrderQuantity = detailOrderQuantity;
	}



	public String getDetailOrderNote() {
		return detailOrderNote;
	}

	public void setDetailOrderNote(String detailOrderNote) {
		this.detailOrderNote = detailOrderNote;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DetailOrder [orderDetailId=" + orderDetailId + ", productId=" + productId + ", orderTableId="
				+ orderTableId + ", detailOrderQuantity=" + detailOrderQuantity + ", detailOrderNote=" + detailOrderNote
				+ "]";
	}
	
}
