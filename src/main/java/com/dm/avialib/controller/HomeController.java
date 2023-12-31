package com.dm.avialib.controller;

import com.dm.avialib.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("articles", articleService.getRecentArticles());

        return "index";
    }
}
