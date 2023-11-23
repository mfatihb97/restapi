package dev.patika.restapi.business.abs;

import dev.patika.restapi.Entities.Author;

import java.util.List;

public interface IAuthorService {

    Author getByID(int id);
    Author save(Author author);
    void delete(int id);
    Author update(Author author);
    List<Author> findAll();
}
