package com.dm.avialib.controller;

import com.dm.avialib.entity.Article;
import com.dm.avialib.service.ArticleService;
import com.dm.avialib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final ArticleService articleService;

    @Autowired
    public CategoryController(ArticleService articleService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }

    @GetMapping("/category/{categoryId}")
    public String getCategoryArticles(@PathVariable Long categoryId, Model model) {
        List<List<Article>> chunkedArticles = articleService.getChunkList(articleService.getAllArticlesByCategory(categoryId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("chunkedArticles", chunkedArticles);
        return "categoryArticles";
    }
}
