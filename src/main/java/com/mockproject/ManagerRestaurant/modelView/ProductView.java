package com.mockproject.ManagerRestaurant.modelView;

public class ProductView {
	private int productId;
	private String productName;
	private String productPrice;
	private String productDescription;
	private String productImage;
	private int typeProductId;
	public ProductView(int productId, String productName, String productPrice, String productDescription,
			String productImage, int typeProductId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.typeProductId = typeProductId;
	}
	public ProductView() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getTypeProductId() {
		return typeProductId;
	}
	public void setTypeProductId(int typeProductId) {
		this.typeProductId = typeProductId;
	}
	
	
}
