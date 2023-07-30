package com.dm.avialib.repository;

import com.dm.avialib.entity.Article;
import com.dm.avialib.entity.Category;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ArticleRepository {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Article> getAllArticles() {
        List<Article> articles;
        try (final Session session = factory.openSession()) {
            session.beginTransaction();

            articles = session.createQuery("from Article ", Article.class).getResultList();

            session.getTransaction().commit();
        }
        return articles;
    }
    public List<Article> getAllArticlesByCategory(Category category) {
        List<Article> articles;
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            articles = session.createQuery("from Article where categoryByCategoryId = :categoryId", Article.class)
                    .setParameter("categoryId", category)
                    .getResultList();

            session.getTransaction().commit();
        }
        return articles;
    }

    public Article getArticleById(Long id) {
        try (final Session session = factory.openSession()) {

            Article result = session.get(Article.class, id);

            return result != null ? result : new Article();
        }
    }

    public Article createArticle(Article article) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(article);

            session.getTransaction().commit();
        }
        return article;
    }

    public Article updateArticle(Article article) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(article);

            session.getTransaction().commit();
        }
        return article;
    }

    public void deleteArticleById(Long id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(getArticleById(id));

            session.getTransaction().commit();
        }
    }
}
