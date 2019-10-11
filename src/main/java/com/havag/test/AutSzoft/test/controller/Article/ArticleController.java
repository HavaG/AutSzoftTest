package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    //TODO: létrehozás, frissítés, törlés

    @PostMapping()
    public Boolean create(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping()
    public void refresh(@RequestBody Article article) {
        articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        articleService.deleteArticle(id);
    }
}
