package com.mockproject.ManagerRestaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tabble")
@Data
public class Tabble {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableId;
	
	@Column(name = "TABLE_NAME")
	private String tableName;
	
	@Column(name = "TABLE_QUANTITY")
	private int tableQuantity;
	
	@Column(name = "TABLE_STATUS")
	private String tableStatus;
	
	@Column(name = "TB_SCHEDULE_ID")
	private Integer scheduleId;
	
	@Column(name = "ORDER_TABLE_ID")
	private Integer orderTableId;

	public Tabble(int tableId, String tableName, int tableQuantity, String tableStatus, Integer scheduleId,
			Integer orderTableId) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableQuantity = tableQuantity;
		this.tableStatus = tableStatus;
		this.scheduleId = scheduleId;
		this.orderTableId = orderTableId;
	}

	public Tabble() {
		super();
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableQuantity() {
		return tableQuantity;
	}

	public void setTableQuantity(int tableQuantity) {
		this.tableQuantity = tableQuantity;
	}

	public String getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getOrderTableId() {
		return orderTableId;
	}

	public void setOrderTableId(Integer orderTableId) {
		this.orderTableId = orderTableId;
	}

	@Override
	public String toString() {
		return "Tabble [tableId=" + tableId + ", tableName=" + tableName + ", tableQuantity=" + tableQuantity
				+ ", tableStatus=" + tableStatus + ", scheduleId=" + scheduleId + ", orderTableId=" + orderTableId
				+ "]";
	}

	
	

	
}
