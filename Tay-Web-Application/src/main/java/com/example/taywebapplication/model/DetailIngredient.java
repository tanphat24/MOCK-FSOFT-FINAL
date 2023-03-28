package com.example.taywebapplication.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity(name="detailIngredient")
public class DetailIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IngredientId;
    @Column(name="detail_ingredient_quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;
    @ManyToOne
    @JoinColumn(name = "unit")
    Unit unit;

    public DetailIngredient() {
    }

    public DetailIngredient(Integer ingredientId, int quantity, Product product, Unit unit) {
        IngredientId = ingredientId;
        this.quantity = quantity;
        this.product = product;
        this.unit = unit;
    }

    public Integer getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        IngredientId = ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
