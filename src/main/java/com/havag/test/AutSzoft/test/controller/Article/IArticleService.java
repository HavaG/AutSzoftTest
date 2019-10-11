package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
    List<Article> getAllArticles();
    Article getArticleById(long articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    boolean deleteArticle(long articleId);
}