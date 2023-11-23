package dev.patika.restapi.business.concrete;

import dev.patika.restapi.Entities.BookBorrowing;
import dev.patika.restapi.Entities.Category;
import dev.patika.restapi.business.abs.ICategoryService;
import dev.patika.restapi.dao.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category getByID(int id) {
        return this.categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepo.delete(getByID(id));
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }

}
