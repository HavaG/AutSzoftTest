package com.havag.test.AutSzoft.test.Category;

import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //TODO: létrehozás, frissítés, törlés

    @PostMapping()
    public void create(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping()
    public void refresh(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
    }
}
