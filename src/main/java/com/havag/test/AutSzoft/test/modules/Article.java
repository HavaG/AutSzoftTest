package com.havag.test.AutSzoft.test.modules;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) long id;
    private String title;
    private String text;
    private Date addDate;
    private Date editDate;


    @ManyToMany (cascade=CascadeType.ALL)
    @JoinTable(
            name = "connect_table",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        if(categories.size() < 5){
            this.categories.add(category);
        }
    }

    public long getId() {
        return id;
    }

    public Article() {
        addDate = new Date(System.currentTimeMillis());
        editDate = new Date(System.currentTimeMillis());
        categories = new HashSet<>();
    }

    public Article(String text, String title) {
        this.title = title;
        this.text = text;
        addDate = new Date(System.currentTimeMillis());
        editDate = new Date(System.currentTimeMillis());
        categories = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}
