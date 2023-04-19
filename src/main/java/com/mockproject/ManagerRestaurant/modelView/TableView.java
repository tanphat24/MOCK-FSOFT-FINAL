package com.mockproject.ManagerRestaurant.modelView;

public class TableView {
	private int tableId;
	private String tableName;
	private String tableStatus;
	private String total;
	private String dateStart;
	private int quantity;
	public TableView(int tableId, String tableName, String tableStatus, String total) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.total = total;
	}

	public TableView(int tableId, String tableName, String tableStatus, String total, String dateStart, int quantity) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.total = total;
		this.dateStart = dateStart;
		this.quantity = quantity;
	}


	
	public TableView(int tableId, String tableName, String tableStatus, String total, int quantity) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.total = total;
		this.quantity = quantity;
	}

	public TableView() {
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
	public String getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
