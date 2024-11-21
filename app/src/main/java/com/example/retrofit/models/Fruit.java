package com.example.retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.sql.Array;

public class Fruit {
    @SerializedName("_id")
    private String id;
    private String name;
    private Number quantity;
    private Number price;
    private Number status;
    private String image;
    private String description;
    private String createdAt;
    private String updatedAt;
    @SerializedName("id_distributor")
    private Distributor distributor;


    public Fruit(String id, String name, Number quantity, Number price, Number status, String image, String description, String createdAt, String updatedAt, Distributor distributor) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.image = image;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.distributor = distributor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
}
