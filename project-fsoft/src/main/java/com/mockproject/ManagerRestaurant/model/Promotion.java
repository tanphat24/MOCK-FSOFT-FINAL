package com.mockproject.ManagerRestaurant.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "promotion")
@Data
public class Promotion  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7578644627696020968L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROMOTION_ID")
	private int PromoId;
	@Column(name = "PROMOTION_NAME")
	private String PromoName;
	@Column(name = "PROMOTION_DAYSTART")
	private Date DayStart;
	@Column(name = "PROMOTION_DAYEND")
	private Date DayEnd;
	@Column(name = "PROMOTION_DISCOUNT")
	private Double Discount;
	
	public Promotion(int promoId, String promoName, Date dayStart, Date dayEnd, Double discount) {
		super();
		PromoId = promoId;
		PromoName = promoName;
		DayStart = dayStart;
		DayEnd = dayEnd;
		Discount = discount;
	}
	public Promotion() {
		super();
	}
	public int getPromoId() {
		return PromoId;
	}
	public void setPromoId(int promoId) {
		PromoId = promoId;
	}
	public String getPromoName() {
		return PromoName;
	}
	public void setPromoName(String promoName) {
		PromoName = promoName;
	}
	public Date getDayStart() {
		return DayStart;
	}
	public void setDayStart(Date dayStart) {
		DayStart = dayStart;
	}
	public Date getDayEnd() {
		return DayEnd;
	}
	public void setDayEnd(Date dayEnd) {
		DayEnd = dayEnd;
	}
	public Double getDiscount() {
		return Discount;
	}
	public void setDiscount(Double discount) {
		Discount = discount;
	}
	@Override
	public String toString() {
		return "Promotion [PromoId=" + PromoId + ", PromoName=" + PromoName + ", DayStart=" + DayStart + ", DayEnd="
				+ DayEnd + ", Discount=" + Discount + "]";
	}
	
	
}
