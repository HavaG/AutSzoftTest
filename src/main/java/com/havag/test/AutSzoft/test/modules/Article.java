package com.havag.test.AutSzoft.test.modules;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) long id;
    private String title;
    private String text;
    private Date addDate;
    private Date editDate;
    //TODO: max 5 category List<Category> categories = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Article() {
        addDate = new Date(System.currentTimeMillis());
        editDate = new Date(System.currentTimeMillis());
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /*
    public void removeCategory(Category category) {
        categoryIdList.remove(category.getId());
    }


    public void addCategory(Category category) {
        if(categoryIdList.size() < 5) {
            categoryIdList.add(category.getId());
        }
    }

     */
}
