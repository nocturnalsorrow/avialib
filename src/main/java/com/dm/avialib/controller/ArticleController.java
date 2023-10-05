package com.dm.avialib.controller;

import com.dm.avialib.entity.Article;
import com.dm.avialib.service.ArticleService;
import com.dm.avialib.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    @Autowired
    public ArticleController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/article/{articleId}")
    public String getArticle(@PathVariable Long articleId, Model model) {
        model.addAttribute("article", articleService.getArticleById(articleId));

        return "article";
    }

    @GetMapping("/articles")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticlesByDate());
        
        return "articles";
    }

    @GetMapping("/article/update/{articleId}")
    public String getArticleToUpdate(@PathVariable Long articleId, Model model) {
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article", article);
        return "articleToEdit";
    }

    @PostMapping("/article/update")
    public String updateArticle(@ModelAttribute Article updatedArticle) {
        articleService.updateArticle(updatedArticle);

        return "redirect:/articles";
    }

    @GetMapping ("/article")
    public String getArticleToCreate(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "createArticle";
    }

    @PostMapping("/article")
    public String createArticle(@ModelAttribute Article article) {
        articleService.createArticle(article);

        return "redirect:/articles";
    }

    @GetMapping("/article/delete/{articleId}")
    public String deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticleById(articleId);

        return "redirect:/articles";
    }

    @GetMapping("/search")
    public String searchArticles(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isEmpty()) {
            List<Article> searchResults = articleService.getArticlesByTitle(keyword);
            model.addAttribute("searchResults", searchResults);
        } else {
            // Если поисковой запрос пустой или отсутствует, можно предпринять действие по умолчанию или показать сообщение
            // Например, можно перенаправить пользователя на страницу со всеми статьями.
            return "redirect:/categoryArticles";
        }

        return "searchResults"; // Возвращаем имя HTML шаблона для отображения результатов
    }

}
