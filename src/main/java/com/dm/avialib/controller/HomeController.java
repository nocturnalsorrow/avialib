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
public class HomeController {
    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("articles", articleService.getAllArticlesByDate());

        return "html/index";
    }
}
