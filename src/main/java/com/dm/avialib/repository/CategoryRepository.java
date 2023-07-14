package com.dm.avialib.repository;

import com.dm.avialib.entity.Category;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CategoryRepository {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Category> getAllCategories() {
        List<Category> categories;
        try (final Session session = factory.openSession()) {
            session.beginTransaction();

            categories = session.createQuery("from Category ", Category.class).getResultList();

            session.getTransaction().commit();
        }
        return categories;
    }

    public Category getCategoryById(Long id) {
        try (final Session session = factory.openSession()) {

            Category result = session.get(Category.class, id);

            return result != null ? result : new Category();
        }
    }

    public Category createCategory(Category category) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(category);

            session.getTransaction().commit();
        }
        return category;
    }

    public Category updateCategory(Category category) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(category);

            session.getTransaction().commit();
        }
        return category;
    }

    public void deleteCategoryById(Long id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(getCategoryById(id));

            session.getTransaction().commit();
        }
    }
}
