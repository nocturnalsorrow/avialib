package com.dm.avialib.service;

import com.dm.avialib.entity.Article;
import com.dm.avialib.entity.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    List<Article> getAllArticlesByCategory(Long id);
    List<Article> getAllArticlesByDate();

    Article getArticleById(Long id);

    Article createArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticleById(Long id);

    User signUpUser(User user);

    List<List<Article>> getChunkList(List<Article> list);
}
