package com.mockproject.ManagerRestaurant.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bill")
@Data
public class Bill{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BILL_ID")
	private int BillId;
	@Column(name = "BILL_UPDATE")
	private Date BillUpdate;
	@Column(name = "BILL_TOTAL")
	private Double BillTotal;
	@Column(name = "PROMOTION_ID")
	private int PromotionId;
	@Column(name = "METHOD_PAYMENT_ID")
	private int MethodPayId;
	@Column(name = "ORDER_TABLE_B_ID")
	private int OrderTId;
	@Column(name = "BILL_STATUS")
	private String BillStatus;
	@Column(name = "BILL_CREATE")
	private Date billCreate;
	
	public Bill(int billId, Date billUpdate, Double billTotal, String billStatus, Date billDatepayment, int promotionId,
			int methodPayId, int orderTId) {
		super();
		BillId = billId;
		BillUpdate = billUpdate;
		BillTotal = billTotal;
		BillStatus = billStatus;
		billCreate = billDatepayment;
		PromotionId = promotionId;
		MethodPayId = methodPayId;
		OrderTId = orderTId;
	}
	public Bill() {
		super();
	}
	@Override
	public String toString() {
		return "Bill [BillId=" + BillId + ", BillUpdate=" + BillUpdate + ", BillTotal=" + BillTotal + ", BillStatus="
				+ BillStatus + ", BillDatepayment=" + billCreate + ", PromotionId=" + PromotionId
				+ ", MethodPayId=" + MethodPayId + ", OrderTId=" + OrderTId + "]";
	}
	public int getBillId() {
		return BillId;
	}
	public void setBillId(int billId) {
		BillId = billId;
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
		return billCreate;
	}
	public void setBillCreate(Date billCreate) {
		this.billCreate = billCreate;
	}
	public int getPromotionId() {
		return PromotionId;
	}
	public void setPromotionId(int promotionId) {
		PromotionId = promotionId;
	}
	public int getMethodPayId() {
		return MethodPayId;
	}
	public void setMethodPayId(int methodPayId) {
		MethodPayId = methodPayId;
	}
	public int getOrderTId() {
		return OrderTId;
	}
	public void setOrderTId(int orderTId) {
		OrderTId = orderTId;
	}
}
