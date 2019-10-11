package com.havag.test.AutSzoft.test.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) long id;
    String name;
    //TODO: length min 3 max 10
    List<String> label = new ArrayList<>();
}
