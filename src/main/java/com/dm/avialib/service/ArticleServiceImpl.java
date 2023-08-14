package com.dm.avialib.service;

import com.dm.avialib.entity.Article;
import com.dm.avialib.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryService categoryService) {
        this.articleRepository = articleRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }

    @Override
    public List<Article> getAllArticlesByCategory(Long id) {
        return articleRepository.getAllArticlesByCategory(categoryService.getCategoryById(id));
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.createArticle(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleRepository.updateArticle(article);
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteArticleById(id);
    }

    @Override
    public List<List<Article>> getChunkList(List<Article> list) {
        List<List<Article>> chunkedList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 4) {
            chunkedList.add(list.subList(i, Math.min(i + 4, list.size())));
        }
        return chunkedList;
    }
}
