package dev.patika.restapi.dto;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public class AuthorUpdateRequest {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private String country;

    public AuthorUpdateRequest(int id, String name, LocalDate birthday, String country) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }

    public AuthorUpdateRequest() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
