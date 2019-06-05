package com.policedog.craftadmin.dao;

import com.policedog.craftadmin.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO {

    List<Article> selectAll();

    void insert(Article article);

    void delete(Long id);

    Article getById(Long id);

    void update(Article article);

    List<Article> search(Article article);

    void deleteMulti(String[] ids);

    void deleteMultiByStudentId(String[] ids);

}
