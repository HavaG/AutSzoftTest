package com.havag.test.AutSzoft.test.modules;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) long id;
    String title;
    String text;
    Date addDate;
    Date editDate;
    //TODO: max 5 category

    List<Integer> categoryList = new ArrayList<>();
}
