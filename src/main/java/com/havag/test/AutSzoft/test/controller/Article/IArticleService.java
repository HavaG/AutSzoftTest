package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.stereotype.Service;


@Service
public interface IArticleService {
    Article getArticleById(long articleId);
    boolean addArticle(Article article);
    Article updateArticle(Article article);
    boolean deleteArticle(long articleId);
    boolean removeCategory(long articleId, Category category);
    boolean addCategoryToArticle(long articleId, Category category);
}