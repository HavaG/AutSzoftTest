package com.havag.test.AutSzoft.test;


import com.havag.test.AutSzoft.test.controller.Category.CategoryRepository;
import com.havag.test.AutSzoft.test.controller.Article.ArticleRepository;
import com.havag.test.AutSzoft.test.modules.Article;
import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    public DbSeeder(ArticleRepository _articleRepository, CategoryRepository _categoryRepository) {
        articleRepository = _articleRepository;
        categoryRepository = _categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //example data for testing only
        this.articleRepository.deleteAll();
        this.categoryRepository.deleteAll();

        Article a1 = new Article("title", "Text");
        Article a2 = new Article();

        Category c1 = new Category();
        Category c2 = new Category();

        c1.setLabel("label");


        a2.setText("asdasddsadsasdds");
        c1.setName("elso");
        c2.setName("masodik");

        a1.addCategory(c1);
        c1.addArticle(a1);

        List<Article> articles = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        articles.add(a1);
        articles.add(a2);
        categories.add(c1);
        categories.add(c2);

        this.articleRepository.saveAll(articles);
        this.categoryRepository.saveAll(categories);
        System.out.println(" -- Database has been initialized");
    }
}
