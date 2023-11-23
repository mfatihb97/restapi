package dev.patika.restapi.dto;

import jakarta.persistence.Column;

public class BookUpdateRequest {
    private int id;
    private String name;
    private int public_year;
    private int stock;

    public BookUpdateRequest(int id, String name, int public_year, int stock) {
        this.id = id;
        this.name = name;
        this.public_year = public_year;
        this.stock = stock;
    }

    public BookUpdateRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublic_year() {
        return public_year;
    }

    public void setPublic_year(int public_year) {
        this.public_year = public_year;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
