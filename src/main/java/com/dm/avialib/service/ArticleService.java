package com.dm.avialib.service;

import com.dm.avialib.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    List<Article> getAllArticlesByCategory(Long id);
    List<Article> getAllArticlesByDate();
    List<Article> getRecentArticles();

    Article getArticleById(Long id);

    Article createArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticleById(Long id);

    List<List<Article>> getChunkList(List<Article> list);
}
