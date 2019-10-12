package com.havag.test.AutSzoft.test.controller.Article;

import com.havag.test.AutSzoft.test.modules.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

}
