package com.dm.avialib.service;

import com.dm.avialib.entity.Article;
import com.dm.avialib.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
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
}
