package dev.patika.restapi.dto;

import jdk.jfr.Name;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class AuthorSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private LocalDate birthday;
    @NotNull
    private String country;

    public AuthorSaveRequest(String name, LocalDate birthday, String country) {
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }

    public AuthorSaveRequest() {
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
