package dev.patika.restapi.business.concrete;

import dev.patika.restapi.Entities.Author;
import dev.patika.restapi.business.abs.IAuthorService;
import dev.patika.restapi.dao.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements IAuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author getByID(int id) {
        return this.authorRepo.findById(id).orElseThrow();
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public void delete(int id) {
        this.authorRepo.delete(this.getByID(id));
    }

    @Override
    public Author update(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepo.findAll();
    }
}
