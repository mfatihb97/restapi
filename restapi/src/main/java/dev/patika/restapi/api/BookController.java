package dev.patika.restapi.api;

import dev.patika.restapi.Entities.Author;
import dev.patika.restapi.Entities.Book;
import dev.patika.restapi.business.abs.IAuthorService;
import dev.patika.restapi.business.abs.IBookService;
import dev.patika.restapi.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> findAll(){
        List<BookResponse> bookResponseList = this.bookService.findAll().stream().map(
                book ->  this.modelMapper.map(book,BookResponse.class)
        ).collect(Collectors.toList());
        return bookResponseList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody BookSaveRequest bookSaveRequest){
        Book newBook = this.modelMapper.map(bookSaveRequest,Book.class);
        return this.bookService.save(newBook);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody BookUpdateRequest bookUpdateRequest){
        Book updatedBook = this.bookService.getByID(bookUpdateRequest.getId());
        updatedBook.setName(bookUpdateRequest.getName());
        updatedBook.setPublic_year(bookUpdateRequest.getPublic_year());
        updatedBook.setStock(bookUpdateRequest.getStock());
        return this.bookService.update(updatedBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.bookService.delete(id);
    }

    @GetMapping("/{id}")
    public BookResponse getByID(@PathVariable("id") int id){
        return this.modelMapper.map(this.bookService.getByID(id),BookResponse.class);
    }
}
