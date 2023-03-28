package com.example.taywebapplication.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "typeproduct")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeProductId")
    private Integer typeProductId;
    @Column(name = "typeProductName")
    private String typeProductName;
    @OneToMany(mappedBy = "typeProduct")
    private Set<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(Integer typeProductId, String typeProductName, Set<Product> products) {
        this.typeProductId = typeProductId;
        this.typeProductName = typeProductName;
        this.products = products;
    }

    public Integer getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Integer typeProductId) {
        this.typeProductId = typeProductId;
    }

    public String getTypeProductName() {
        return typeProductName;
    }

    public void setTypeProductName(String typeProductName) {
        this.typeProductName = typeProductName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
