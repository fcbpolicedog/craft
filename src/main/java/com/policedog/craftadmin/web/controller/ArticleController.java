package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Article;
import com.policedog.craftadmin.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ModelAttribute
    public Article getStudent(Long id){
        Article article = null;
        //id不为空，则从数据库获取
        if (id!=null){
            article = articleService.getById(id);
        }else {
            article = new Article();
        }
        return article;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<Article> articleList = articleService.selectAll();
        model.addAttribute("articleList",articleList);
        return "article_list";
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(String keyword,Model model){

        List<Article> articleList = articleService.search(keyword);
        model.addAttribute("articleList",articleList);
        return "article_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "article_form";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Article article, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = articleService.save(article);
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/article/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "article_form";
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            articleService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
