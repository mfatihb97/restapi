package dev.patika.restapi.business.abs;
import dev.patika.restapi.Entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getByID(int id);
    BookBorrowing save(BookBorrowing borrowing);
    void delete(int id);
    BookBorrowing update(BookBorrowing borrowing);
    List<BookBorrowing> findAll();
}
