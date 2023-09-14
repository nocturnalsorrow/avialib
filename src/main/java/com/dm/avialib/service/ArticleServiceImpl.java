package com.dm.avialib.service;

import com.dm.avialib.entity.Article;
import com.dm.avialib.entity.Category;
import com.dm.avialib.entity.User;
import com.dm.avialib.repository.ArticleRepository;
import com.dm.avialib.repository.CategoryRepository;
import com.dm.avialib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAllArticles();
    }

    @Override
    public List<Article> getAllArticlesByCategory(Long id) {
        return articleRepository.getAllArticlesByCategory(categoryRepository.getCategoryById(id));
    }

    @Override
    public List<Article> getAllArticlesByDate() {
        return articleRepository.getAllArticlesByDate();
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
        Article oldArticle = articleRepository.getArticleById(article.getArticleId());
        oldArticle.setTitle(article.getTitle());
        oldArticle.setContent(article.getContent());
        oldArticle.setPublicationDate(article.getPublicationDate());
        oldArticle.setPhoto(article.getPhoto());
        return articleRepository.updateArticle(oldArticle);
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
