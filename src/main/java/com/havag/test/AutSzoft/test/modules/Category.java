package com.havag.test.AutSzoft.test.modules;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) long id;

    private String name;

    @ElementCollection
    private List<String> labels = new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Article> articles = new HashSet<>();

    public Set<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    public Long getId() {
        return id;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabel(String label) {
        if(label.length() >= 3 && label.length() <= 10)
            this.labels.add(label);
    }

    public void setLabel(List<String> labels) {
            this.labels = labels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
