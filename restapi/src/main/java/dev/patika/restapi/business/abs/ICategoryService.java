package dev.patika.restapi.business.abs;

import dev.patika.restapi.Entities.Book;
import dev.patika.restapi.Entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getByID(int id);
    Category save(Category category);
    void delete(int id);
    Category update(Category category);
    List<Category> findAll();
}
