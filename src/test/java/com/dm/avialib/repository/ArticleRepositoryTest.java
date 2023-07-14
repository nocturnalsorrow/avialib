package com.dm.avialib.repository;

import com.dm.avialib.entity.Article;
import com.dm.avialib.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleRepositoryTest {
    @Mock
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllArticles() {
        // Создание и настройка тестовых данных
        List<Article> expectedArticles = new ArrayList<>();
        expectedArticles.add(new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link"));
        expectedArticles.add(new Article(2L, "Title 2", "Content 2", new Category(), Date.valueOf("2020-10-10"), "link"));

        // Настройка мок-объекта для articleRepository.getAllArticles()
        when(articleRepository.getAllArticles()).thenReturn(expectedArticles);

        // Вызов метода для тестирования
        List<Article> actualArticles = articleRepository.getAllArticles();

        // Проверка результатов
        assertEquals(expectedArticles.size(), actualArticles.size());
        assertEquals(expectedArticles, actualArticles);
    }

    @Test
    void getArticleById() {
        Article expectedArticle = new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link");

        // Настройка мок-объекта для articleRepository.getArticleById()
        when(articleRepository.getArticleById(1L)).thenReturn(expectedArticle);

        // Вызов метода для тестирования
        Article actualArticle = articleRepository.getArticleById(1L);

        // Проверка результатов
        assertEquals(expectedArticle, actualArticle);
    }

    @Test
    void createArticle() {
        Article expectedArticle = new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link");

        when(articleRepository.createArticle(new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link"))).thenReturn(expectedArticle);

        Article actualArticle = articleRepository.createArticle(new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link"));

        assertEquals(expectedArticle, actualArticle);
    }

    @Test
    void updateArticle() {
        // Создание тестовой статьи для обновления
        Article articleToUpdate = new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link");

        // Настройка мок-объекта для articleRepository.updateArticle()
        when(articleRepository.updateArticle(articleToUpdate)).thenReturn(articleToUpdate);

        // Изменение данных статьи
        articleToUpdate.setArticleId(2L);
        articleToUpdate.setTitle("Updated Title");
        articleToUpdate.setContent("Updated Content");
        articleToUpdate.setCategoryByCategoryId(new Category());
        articleToUpdate.setPublicationDate(Date.valueOf("2023-07-09"));
        articleToUpdate.setPhoto("updated link");

        // Вызов метода для тестирования
        Article updatedArticle = articleRepository.updateArticle(articleToUpdate);

        // Проверка результатов
        assertEquals(2L, updatedArticle.getArticleId());
        assertEquals("Updated Title", updatedArticle.getTitle());
        assertEquals("Updated Content", updatedArticle.getContent());
        assertEquals(new Category(), updatedArticle.getCategoryByCategoryId());
        assertEquals(Date.valueOf("2023-07-09"), updatedArticle.getPublicationDate());
        assertEquals(articleToUpdate, updatedArticle);
        // Можно также проверить, что не было вызова других методов внутри articleRepository, если это требуется
        verify(articleRepository, times(1)).updateArticle(articleToUpdate);
    }

    @Test
    void deleteArticleById() {
        // Создание тестовых данных
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(new Article(1L, "Title 1", "Content 1", new Category(), Date.valueOf("2020-10-10"), "link"));
        articles.add((new Article(2L, "Title 2", "Content 2", new Category(), Date.valueOf("2020-10-10"), "link")));

        // Настройка мок-объекта для articleRepository.getArticleById()
        when(articleRepository.getArticleById(1L)).thenReturn(articles.get(0));

        // Вызов метода для тестирования
        articleRepository.deleteArticleById(1L);

        // Проверка результатов
        verify(articleRepository, times(1)).deleteArticleById(1L);
    }
}