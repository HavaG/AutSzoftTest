package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        Article article = articleRepository.findById(articleId).get();
        return article;
    }


    @Override
    public boolean addArticle(Article article) {
        articleRepository.save(article);
        return true;
    }

    @Override
    public void updateArticle(Article article) {
        //TODO: ráér minden egyedhez új id-t generál
        //check if exist in db
        Optional<Article> tmp = articleRepository.findById(article.getId());
        if(tmp.isPresent()) {
            Article tmpArticle = tmp.get();
            if(article.getText() == null)
                article.setText(tmpArticle.getText());
            if(article.getTitle() == null)
                article.setTitle(tmpArticle.getTitle());
            article.setEditDate(new Date(System.currentTimeMillis()));
            //delete old
            articleRepository.deleteById(tmp.get().getId());
            //save new
            articleRepository.save(article);
        }
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
}