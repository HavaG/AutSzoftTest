package com.havag.test.AutSzoft.test;


import com.havag.test.AutSzoft.test.controller.Article.ArticleRepository;
import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    ArticleRepository articleRepository;

    public DbSeeder(ArticleRepository _articleRepository) {
        articleRepository = _articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.articleRepository.deleteAll();

        //TODO elements create, add to list

        List<Article> articles = new ArrayList<>();

        this.articleRepository.saveAll(articles);
        System.out.println(" -- Database has been initialized");
    }
}
