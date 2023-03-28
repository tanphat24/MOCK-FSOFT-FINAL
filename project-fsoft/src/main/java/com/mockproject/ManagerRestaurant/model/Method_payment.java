package com.mockproject.ManagerRestaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="method_payment")
@Data
public class Method_payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "METHOD_PAYMENT_ID")
	private int MethodPayId;
	@Column(name = "METHOD_PAYMENT_NAME")
	private String MethodPayName;
	@Column(name = "METHOD_PAYMENT_DESCRIPTION")
	private String MethodPayDesc;
	
	@Override
	public String toString() {
		return "Method_payment [MethodPayId=" + MethodPayId + ", MethodPayName=" + MethodPayName + ", MethodPayDesc="
				+ MethodPayDesc + "]";
	}
	public int getMethodPayId() {
		return MethodPayId;
	}
	public void setMethodPayId(int methodPayId) {
		MethodPayId = methodPayId;
	}
	public String getMethodPayName() {
		return MethodPayName;
	}
	public void setMethodPayName(String methodPayName) {
		MethodPayName = methodPayName;
	}
	public String getMethodPayDesc() {
		return MethodPayDesc;
	}
	public void setMethodPayDesc(String methodPayDesc) {
		MethodPayDesc = methodPayDesc;
	}
	public Method_payment(int methodPayId, String methodPayName, String methodPayDesc) {
		super();
		MethodPayId = methodPayId;
		MethodPayName = methodPayName;
		MethodPayDesc = methodPayDesc;
	}
	public Method_payment() {
		super();
	}

	
}
