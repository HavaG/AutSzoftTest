package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.controller.Category.ICategoryService;
import com.havag.test.AutSzoft.test.modules.Article;
import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller //true means success, false means fail (no entity found etc...)
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

    @PostMapping("/create") //only title and text in json
    public ResponseEntity<Boolean> create(@RequestBody Article article) {
        return new ResponseEntity<Boolean>(articleService.addArticle(article), HttpStatus.OK);
    }

    @PutMapping("/refresh") //only title and text refresh in json (and id...)
    public ResponseEntity<Article> refresh(@RequestBody Article article) {
        return new ResponseEntity<Article>(articleService.updateArticle(article), HttpStatus.OK);
    }

    //TODO: it deletes all the belonging categories...
    @DeleteMapping("/delete/{id}") //no json
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        boolean tmp = articleService.deleteArticle(id);
        return new ResponseEntity<Boolean>(tmp, HttpStatus.OK);
    }

    //TODO: remove more than it should...
    @PutMapping("/removeCategory/{articleId}/{categoryName}")
    public ResponseEntity<Boolean> removeCategory(@PathVariable("articleId") long articleId,
                                                 @PathVariable("categoryName") String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return new ResponseEntity<Boolean>(articleService.removeCategory(articleId, category), HttpStatus.OK);
    }


    @PutMapping("/addCategory/{articleId}/{categoryName}") //article id + category name
    public ResponseEntity<Boolean> addCategory(@PathVariable("articleId") long articleId,
                                              @PathVariable("categoryName") String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return new ResponseEntity<Boolean>(articleService.addCategoryToArticle(articleId, category), HttpStatus.OK);
    }

    //TODO: implement
    @GetMapping("/find/{label}")
    public ResponseEntity<List<Article>> findByLabel(@PathVariable("label") String label) {
        return new ResponseEntity<List<Article>>(new ArrayList<Article>(), HttpStatus.OK);
    }
}
