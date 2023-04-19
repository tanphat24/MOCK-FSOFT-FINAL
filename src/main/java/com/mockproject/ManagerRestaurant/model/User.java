//package com.mockproject.ManagerRestaurant.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Entity
//@Table(name = "user")
//@Data
//public class User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userId;
//	
//	@Column(name = "USER_NAME")
//	private String userName;
//	
//	@Column(name = "USER_PHONE")
//	private String userPhone;
//	
//	@Column(name = "USER_EMAIL")
//	private String userEmail;
//	
//	@Column(name = "USER_ADDRESS")
//	private String userAddress;
//	
//	@Column(name = "USER_PASSWORD")
//	private String userPassword;
//
//	public User(int userId, String userName, String userPhone, String userEmail, String userAddress,
//			String userPassword) {
//		this.userId = userId;
//		this.userName = userName;
//		this.userPhone = userPhone;
//		this.userEmail = userEmail;
//		this.userAddress = userAddress;
//		this.userPassword = userPassword;
//	}
//
//	public User() {
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getUserPhone() {
//		return userPhone;
//	}
//
//	public void setUserPhone(String userPhone) {
//		this.userPhone = userPhone;
//	}
//
//	public String getUserEmail() {
//		return userEmail;
//	}
//
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//
//	public String getUserAddress() {
//		return userAddress;
//	}
//
//	public void setUserAddress(String userAddress) {
//		this.userAddress = userAddress;
//	}
//
//	public String getUserPassword() {
//		return userPassword;
//	}
//
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//}
