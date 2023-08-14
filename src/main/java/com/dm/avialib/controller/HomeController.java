package com.dm.avialib.controller;

import com.dm.avialib.entity.Article;
import com.dm.avialib.service.ArticleService;
import com.dm.avialib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "html/index";
    }

    @GetMapping("/article/{articleId}")
    public String getArticle(@PathVariable Long articleId, Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "html/article";
    }

//    @GetMapping("/category/{categoryId}")
//    public String getCategoryArticles(@PathVariable Long categoryId, Model model){
//        List<Article> articles = articleService.getAllArticlesByCategory(categoryId);
//        model.addAttribute("articles", articles);
//        return "html/categoryArticles";
//    }

    @GetMapping("/category/{categoryId}")
    public String getCategoryArticles(@PathVariable Long categoryId, Model model) {
        List<List<Article>> chunkedArticles = articleService.getChunkList(articleService.getAllArticlesByCategory(categoryId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("chunkedArticles", chunkedArticles);
        return "html/categoryArticles";
    }


}
