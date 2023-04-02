package com.mockproject.ManagerRestaurant.view;

public class DSmon {
	private int stt;
	private String name;
	private int soluong;
	private Double price;
	public DSmon(int stt, String name, int soluong, Double price) {
		super();
		this.stt = stt;
		this.name = name;
		this.soluong = soluong;
		this.price = price;
	}
	public DSmon() {
		super();
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "DSmon [name=" + name + ", soluong=" + soluong + ", price=" + price + "]";
	}
	
}
