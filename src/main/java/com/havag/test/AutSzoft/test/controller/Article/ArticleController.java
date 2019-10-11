package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    //TODO: ráér mindegyik random status coddal tér vissza

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

    @PostMapping("/create")
    public Boolean create(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping("/refresh")
    public void refresh(@RequestBody Article article) {
        articleService.updateArticle(article);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        articleService.deleteArticle(id);
    }

    @PutMapping("/removeCategory/{id}/{categoryName}")
    public void removeCategory(@PathVariable("id") long articleId, @PathVariable("categoryName") String name) {
        //TODO: removeCategory
    }

    @PutMapping("/addCategory/{id}/{categoryName}")
    public void addCategory(@PathVariable("id") long articleId, @PathVariable("categoryName") String name) {
        //TODO: addCategory, only if less than 5
    }
}
