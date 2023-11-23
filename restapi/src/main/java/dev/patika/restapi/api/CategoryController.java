package dev.patika.restapi.api;

import dev.patika.restapi.Entities.Book;
import dev.patika.restapi.Entities.Category;
import dev.patika.restapi.business.abs.IBookService;
import dev.patika.restapi.business.abs.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll(){
        List<Category> categoryList = categoryService.findAll();
        return categoryList;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return this.categoryService.save(category);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category){
        Category updatedCategory = this.categoryService.getByID(category.getId());
        updatedCategory.setDescription(category.getDescription());
        updatedCategory.setName(category.getDescription());
        return this.categoryService.update(updatedCategory);
    }

    @Query("SELECT book2category_book_id FROM book2category b WHERE b.book2category_category_id = ?1")
    Integer findIn(Integer book2category_category_id){
        return book2category_category_id;
    };

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) throws Exception {
        if (findIn(id)== null){
            this.categoryService.delete(id);
        }else {
            throw new Exception("This category contains book or books ! You can't delete it !");
        }

    }

}
