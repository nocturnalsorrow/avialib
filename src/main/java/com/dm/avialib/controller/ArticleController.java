package com.dm.avialib.controller;

import com.dm.avialib.entity.Article;
import com.dm.avialib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{articleId}")
    public String getArticle(@PathVariable Long articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "html/article";
    }

    @GetMapping("/articles")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());

        return "html/articles";
    }

    @GetMapping("/article/update/{articleId}")
    public String getArticleToUpdate(@PathVariable Long articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "html/articleToEdit";
    }

    @PostMapping("/article/update")
    public String updateArticle(@ModelAttribute Article updatedArticle) {
        articleService.updateArticle(updatedArticle);

        return "redirect:/articles";
    }

    @GetMapping ("/article")
    public String getArticleToCreate(Model model) {
        model.addAttribute("article", new Article());

        return "html/createArticle";
    }

    @PostMapping("/article")
    public String createArticle(@ModelAttribute Article article) {
        articleService.createArticle(article);

        return "redirect:/categoryArticles";
    }
}
