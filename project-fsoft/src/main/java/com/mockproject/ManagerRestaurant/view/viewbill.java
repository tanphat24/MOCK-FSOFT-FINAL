package com.mockproject.ManagerRestaurant.view;

import java.sql.Date;

public class viewbill {
	private int ID;
	private String Name;
	private Date BillUpdate;
	private Double BillTotal;
	private String BillStatus;
	private int Promotion;
	private Date BillCreate;
	private int MethodPayId;
	private int OrderTId;
	
	public viewbill(int iD, String name, Date billUpdate, Double billTotal, String billStatus, int promotion, Date billDatepayment, int methodPayId,
			int orderTId) {
		super();
		ID = iD;
		Name = name;
		BillUpdate = billUpdate;
		BillTotal = billTotal;
		BillStatus = billStatus;
		Promotion = promotion;
		BillCreate = billDatepayment;
		MethodPayId = methodPayId;
		OrderTId = orderTId;
	}
	public viewbill() {
		super();
	}
	
	public int getPromotion() {
		return Promotion;
	}
	public void setPromotion(int promotion) {
		Promotion = promotion;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getBillUpdate() {
		return BillUpdate;
	}
	public void setBillUpdate(Date billUpdate) {
		BillUpdate = billUpdate;
	}
	public Double getBillTotal() {
		return BillTotal;
	}
	public void setBillTotal(Double billTotal) {
		BillTotal = billTotal;
	}
	public String getBillStatus() {
		return BillStatus;
	}
	public void setBillStatus(String billStatus) {
		BillStatus = billStatus;
	}
	public Date getBillCreate() {
		return BillCreate;
	}
	public void setBillCreate(Date billCreate) {
		BillCreate = billCreate;
	}
	public int getOrderTId() {
		return OrderTId;
	}
	public void setOrderTId(int orderTId) {
		OrderTId = orderTId;
	}
	public int getMethodPayId() {
		return MethodPayId;
	}
	public void setMethodPayId(int methodPayId) {
		MethodPayId = methodPayId;
	}

}
