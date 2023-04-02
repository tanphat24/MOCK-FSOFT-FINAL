package com.example.taywebapplication.model;

import javax.persistence.*;

@Entity(name = "detail_order")
public class DetailOrder {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Integer detailOrderId;
    @Column(name = "detail_order_quantity")
    private int quantity;
    @Column(name = "detail_order_note" )
    private String note;
    @ManyToOne
    @JoinColumn(name="productId")
    Product product;

    public DetailOrder() {
    }

    public DetailOrder(Integer detailOrderId, int quantity, String note, Product product) {
        this.detailOrderId = detailOrderId;
        this.quantity = quantity;
        this.note = note;
        this.product = product;
    }

    public Integer getDetailOrderId() {
        return detailOrderId;
    }

    public void setDetailOrderId(Integer detailOrderId) {
        this.detailOrderId = detailOrderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
