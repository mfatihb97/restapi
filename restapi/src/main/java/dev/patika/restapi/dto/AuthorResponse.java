package dev.patika.restapi.dto;


import java.time.LocalDate;

public class AuthorResponse {
    private int id;
    private String name;
    private LocalDate birthday;
    private String country;

    public AuthorResponse(int id, String name, LocalDate birthday, String country) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }

    public AuthorResponse() {
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
