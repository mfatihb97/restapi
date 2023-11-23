package dev.patika.restapi.business.concrete;

import dev.patika.restapi.Entities.BookBorrowing;
import dev.patika.restapi.business.abs.IBookBorrowingService;
import dev.patika.restapi.dao.BookBorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    @Autowired
    public BookBorrowingRepo borrowingRepo;
    @Override
    public BookBorrowing getByID(int id) {
        return this.borrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public BookBorrowing save(BookBorrowing borrowing) {
        return this.borrowingRepo.save(borrowing);
    }

    @Override
    public void delete(int id) {
        this.borrowingRepo.delete(getByID(id));
    }

    @Override
    public BookBorrowing update(BookBorrowing borrowing) {
        return this.borrowingRepo.save(borrowing);
    }

    @Override
    public List<BookBorrowing> findAll() {
        return this.borrowingRepo.findAll();
    }
}
