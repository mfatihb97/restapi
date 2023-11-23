package dev.patika.restapi.dto;
import org.antlr.v4.runtime.misc.NotNull;

public class BookSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private int public_year;
    @NotNull
    private int stock;

    public BookSaveRequest(String name, int public_year, int stock) {
        this.name = name;
        this.public_year = public_year;
        this.stock = stock;
    }

    public BookSaveRequest() {
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
