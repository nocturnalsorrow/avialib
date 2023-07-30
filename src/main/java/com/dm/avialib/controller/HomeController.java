package com.dm.avialib.controller;

import com.dm.avialib.service.ArticleService;
import com.dm.avialib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

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

    @GetMapping("/category/{category}")
    public String categoryArticles(@PathVariable Long category, Model model){
        model.addAttribute("articles", articleService.getAllArticlesByCategory(category));

        return "html/categoryArticles";
    }
    @GetMapping("/article/{article}")
    public String article(@PathVariable Long article, Model model){
        model.addAttribute("articles", articleService.getArticleById(article));

        return "html/article";
    }
}
