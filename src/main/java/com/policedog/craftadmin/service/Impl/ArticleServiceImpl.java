package com.policedog.craftadmin.service.Impl;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.dao.ArticleDAO;
import com.policedog.craftadmin.domain.Article;
import com.policedog.craftadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;
    @Override
    public List<Article> selectAll() {
        return articleDAO.selectAll();
    }

    @Override
    public Article getById(Long id) {
        return articleDAO.getById(id);
    }

    @Override
    public void update(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void deleteMulti(String[] ids) {
        articleDAO.deleteMulti(ids);
    }

    @Override
    public BaseResult save(Article article) {
        BaseResult baseResult = BaseResult.success();
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){

            //成功
            article.setUpdated(new Date());
            if (article.getId()==null){

                article.setCreated(new Date());
                articleDAO.insert(article);
            }else{
                //update用户
                articleDAO.update(article);
            }

            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public List<Article> search(String keyword) {
        Article article = new Article();
        article.setTitle(keyword);
        article.setContent(keyword);
        return articleDAO.search(article);
    }

    @Override
    public void deleteMultiByStudentId(String[] ids) {
        articleDAO.deleteMultiByStudentId(ids);
    }
}
