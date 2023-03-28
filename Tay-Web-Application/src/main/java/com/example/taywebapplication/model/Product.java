package com.example.taywebapplication.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "productName")
    private String productName;
    @Column(name="productPrice")
    private double productPrice;
    @Column(name = "productDescription")
    private String productDescription;
    @ManyToOne
    @JoinColumn(name = "typeProductId")
    TypeProduct typeProduct;
    @Column(name = "image")
    private String image;
    private int quantity;
    @OneToMany(mappedBy = "product")
    private Set<DetailOrder> detailOrders;

    @OneToMany(mappedBy = "product")
    private Set<DetailIngredient> detailIngredients;
    public Product() {
    }

    public Product(Integer productId, String productName, double productPrice, String productDescription, TypeProduct typeProduct, String image, int quantity, Set<DetailOrder> detailOrders, Set<DetailIngredient> detailIngredients) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.typeProduct = typeProduct;
        this.image = image;
        this.quantity = quantity;
        this.detailOrders = detailOrders;
        this.detailIngredients = detailIngredients;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<DetailIngredient> getDetailIngredients() {
        return detailIngredients;
    }

    public void setDetailIngredients(Set<DetailIngredient> detailIngredients) {
        this.detailIngredients = detailIngredients;
    }

    public Set<DetailOrder> getDetailOrders() {
        return detailOrders;
    }

    public void setDetailOrders(Set<DetailOrder> detailOrders) {
        this.detailOrders = detailOrders;
    }
}
