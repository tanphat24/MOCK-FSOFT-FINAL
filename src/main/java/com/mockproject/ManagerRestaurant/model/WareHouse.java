package com.mockproject.ManagerRestaurant.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class WareHouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WAREHOUSE_ID")
	private int id;
	
	@Column(name = "WAREHOUSE_IMPORT_DATE")
	private Date importDate;
	
	@Column(name = "WAREHOUSE_DEADLINE_DATE")
	private Date deadlineDate;
	
	public WareHouse() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", importDate=" + importDate + ", deadlineDate=" + deadlineDate + "]";
	}
	
}
