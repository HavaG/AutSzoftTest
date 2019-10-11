package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        List<Article> list = new ArrayList<>();
        for (Article article : articleRepository.findAll()) {
            list.add(article);
        }
        return list;
    }

    @Override
    public Article getArticleById(long articleId) {
        Optional<Article> article = articleRepository.findById(articleId);
        return article.orElse(null);
    }

    @Override
    public boolean addArticle(Article article) {
        articleRepository.save(article);
        return true;
    }

    @Override
    public void updateArticle(Article article) {
        //TODO updateArticle
    }

    @Override
    public void deleteArticle(int articleId) {
        articleRepository.delete(getArticleById(articleId));
    }
}
