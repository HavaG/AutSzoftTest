package com.havag.test.AutSzoft.test.modules;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) long id;

    private String name;

    public long getId() {
        return id;
    }

    //TODO: length min 3 max 10

    @ElementCollection
    List<String> labels = new ArrayList<>();

    public List<String> getLabels() {
        return labels;
    }

    public void setLabel(String label) {
        if(label.length() >= 3 && label.length() <= 10)
            this.labels.add(label);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
