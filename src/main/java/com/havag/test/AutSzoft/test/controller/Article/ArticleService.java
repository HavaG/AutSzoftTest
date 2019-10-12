package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.controller.Category.CategoryRepository;
import com.havag.test.AutSzoft.test.modules.Article;
import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Article getArticleById(long articleId) {
        return articleRepository.findById(articleId).get();
    }


    @Override
    public boolean addArticle(Article article) {
        articleRepository.save(article);
        return true;
    }

    @Override
    public Article updateArticle(Article article) {
        //check if exist in db
        Optional<Article> tmp = articleRepository.findById(article.getId());
        if(tmp.isPresent()) {
            Article tmpArticle = tmp.get();
            Set<Category> categorySet = tmp.get().getCategories();
            tmpArticle.setCategories(categorySet);
            if(article.getText() == null)
                article.setText(tmpArticle.getText());
            if(article.getTitle() == null)
                article.setTitle(tmpArticle.getTitle());
            article.setEditDate(new Date(System.currentTimeMillis()));
            article.setCategories(tmpArticle.getCategories());
            articleRepository.save(article);
            return article;
        }
        return null;
    }

    @Override
    public boolean deleteArticle(long articleId) {
        if(articleRepository.existsById(articleId)) {
                articleRepository.delete(getArticleById(articleId));
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean removeCategory(long articleId, Category category) {
        Optional<Article> tmp = articleRepository.findById(articleId);
        if(tmp.isPresent() && category != null) {
            Article temporal = tmp.get();
            if(temporal.getCategories().contains(category)) {
                temporal.getCategories().remove(category);
                temporal.setEditDate(new Date(System.currentTimeMillis()));


                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addCategoryToArticle(long articleId, Category category) {
        Optional<Article> tmp = articleRepository.findById(articleId);
        if(tmp.isPresent() && category != null) {
            Article temporal = tmp.get();
            //if more then 4 or already contain
            if(temporal.getCategories().size() >= 5 || temporal.getCategories().contains(category)) {
                return false;
            }
            temporal.addCategory(category);
            temporal.setEditDate(new Date(System.currentTimeMillis()));

            categoryRepository.findById(category.getId());
            categoryRepository.delete(category);
            category.addArticle(temporal);
            categoryRepository.save(category);

            return true;
        }

        return false;
    }
}