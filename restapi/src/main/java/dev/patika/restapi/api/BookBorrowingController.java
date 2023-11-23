package dev.patika.restapi.api;
import dev.patika.restapi.Entities.BookBorrowing;
import dev.patika.restapi.business.abs.IBookBorrowingService;
import dev.patika.restapi.business.abs.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/book-borrow")
public class BookBorrowingController {
    @Autowired
    private IBookBorrowingService iBookBorrowing;
    @Autowired
    private IBookService bookService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowing> findAll(){
        List<BookBorrowing> bookBorrowingList = this.iBookBorrowing.findAll().stream().map(
                bookBorrowing -> this.modelMapper.map(bookBorrowing,BookBorrowing.class)
        ).collect(Collectors.toList());
        return bookBorrowingList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing){
       if (bookService.getByID(bookBorrowing.getId()).getStock()<0){
           throw new RuntimeException("This book out of stock !");
       }else{
           BookBorrowing newBorrow = this.modelMapper.map(bookBorrowing,BookBorrowing.class);
           return this.iBookBorrowing.save(newBorrow);
       }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing update(@RequestBody BookBorrowing bookBorrowing){
        BookBorrowing updatedBorrow = this.iBookBorrowing.getByID(bookBorrowing.getId());
        updatedBorrow.setName(bookBorrowing.getName());
        updatedBorrow.setBorrow_date(bookBorrowing.getBorrow_date());
        updatedBorrow.setReturn_date(bookBorrowing.getReturn_date());
        return this.iBookBorrowing.update(updatedBorrow);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.iBookBorrowing.delete(id);
    }

    @GetMapping("/{id}")
    public BookBorrowing getByID(@PathVariable("id") int id){
        return this.iBookBorrowing.getByID(id);
    }

}
