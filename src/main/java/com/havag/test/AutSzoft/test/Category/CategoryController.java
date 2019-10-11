package com.havag.test.AutSzoft.test.Category;


import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //TODO: ráér mindegyik random status coddal tér vissza

    @GetMapping("/{id}")
    public ResponseEntity<Category> getArticleById(@PathVariable("id") Integer id) {
        Category article = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(article, HttpStatus.OK);
    }

    @PostMapping("/create")
    public void create(@RequestBody Category category) {
        //TODO: csak akkor lehet létrehozni ha még nincs ilyen nevő
        categoryService.addCategory(category);
    }

    @PutMapping("/refresh")
    public void refresh(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return categoryService.deleteCategory(id);
    }
}
