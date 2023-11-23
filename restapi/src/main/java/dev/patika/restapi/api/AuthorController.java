package dev.patika.restapi.api;

import dev.patika.restapi.Entities.Author;
import dev.patika.restapi.business.abs.IAuthorService;
import dev.patika.restapi.dto.AuthorResponse;
import dev.patika.restapi.dto.AuthorSaveRequest;
import dev.patika.restapi.dto.AuthorUpdateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> findAll(){
        List<AuthorResponse> authorResponseList = this.authorService.findAll().stream().map(
                author -> this.modelMapper.map(author,AuthorResponse.class)
        ).collect(Collectors.toList());
        return authorResponseList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody AuthorSaveRequest authorSaveRequest){
        Author newAuthor = this.modelMapper.map(authorSaveRequest,Author.class);
        newAuthor.setBirthday(LocalDate.now());
        return this.authorService.save(newAuthor);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@RequestBody AuthorUpdateRequest authorUpdateRequest){
        Author updatedAuthor = this.authorService.getByID(authorUpdateRequest.getId());
        updatedAuthor.setName(authorUpdateRequest.getName());
        updatedAuthor.setBirthday(authorUpdateRequest.getBirthday());
        updatedAuthor.setCountry(authorUpdateRequest.getCountry());
        return this.authorService.update(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.authorService.delete(id);
    }

    @GetMapping("/{id}")
    public AuthorResponse getByID(@PathVariable("id") int id){
        return this.modelMapper.map(this.authorService.getByID(id),AuthorResponse.class);
    }
}
