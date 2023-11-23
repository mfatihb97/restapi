package dev.patika.restapi.business.abs;

import dev.patika.restapi.Entities.Author;
import dev.patika.restapi.Entities.Book;

import java.util.List;

public interface IBookService {

    Book getByID(int id);
    Book save(Book book);
    void delete(int id);
    Book update(Book book);
    List<Book> findAll();
}
