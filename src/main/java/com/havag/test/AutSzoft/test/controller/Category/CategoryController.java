package com.havag.test.AutSzoft.test.controller.Category;


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

    @GetMapping("/{id}")
    public ResponseEntity<Category> getArticleById(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping("/create") //create category with the labels in json (minimum 3 max 10 characters)
    public ResponseEntity<Boolean> create(@RequestBody Category category) {
        return new ResponseEntity<Boolean>(categoryService.addCategory(category), HttpStatus.OK);
    }

    @PutMapping("/refresh") //refresh the name and the correct labels
    public ResponseEntity<Category> refresh(@RequestBody Category category) {
        Category tmp = categoryService.updateCategory(category);
        return new ResponseEntity<Category>(tmp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}") //delete category by id if it does not belong to any article
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        boolean tmp = categoryService.deleteCategory(id);
        return new ResponseEntity<Boolean>(tmp, HttpStatus.OK);
    }
}
