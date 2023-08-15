package com.dm.avialib.controller;

import com.dm.avialib.entity.Article;
import com.dm.avialib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{articleId}")
    public String getArticle(@PathVariable Long articleId, Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "html/article";
    }
}
