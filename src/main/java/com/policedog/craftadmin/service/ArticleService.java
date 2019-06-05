package com.policedog.craftadmin.service;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Article;
import java.util.List;

public interface ArticleService {

    List<Article> selectAll();

    Article getById(Long id);

    void update(Article article);

    void deleteMulti(String[] ids);

    BaseResult save(Article article);

    List<Article> search(String keyword);

    void deleteMultiByStudentId(String[] ids);
}
