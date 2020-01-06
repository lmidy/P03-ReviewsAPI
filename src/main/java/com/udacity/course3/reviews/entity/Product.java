package com.udacity.course3.reviews.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    @NotNull
    private String productName;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {

        return "Product{" +
                "id=" + id +
                ", name=" + productName + '\'' +
                '}';
    }
}
