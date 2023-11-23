package dev.patika.restapi.business.concrete;

import dev.patika.restapi.Entities.Book;
import dev.patika.restapi.business.abs.IBookService;
import dev.patika.restapi.dao.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book getByID(int id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
            this.bookRepo.delete(getByID(id));
    }

    @Override
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }
}
