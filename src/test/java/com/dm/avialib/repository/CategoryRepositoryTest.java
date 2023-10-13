package com.dm.avialib.repository;

import com.dm.avialib.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryRepositoryTest {
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCategories() {
        List<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(new Category(1L, "Topic 1","url", new ArrayList<>()));
        expectedCategories.add(new Category(2L, "Topic 2","url", new ArrayList<>()));

        when(categoryRepository.getAllCategories()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryRepository.getAllCategories();

        assertEquals(expectedCategories.size(), actualCategories.size());
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void getCategoryById() {
        Category expectedCategory = new Category(1L, "Topic 1","url", new ArrayList<>());

        when(categoryRepository.getCategoryById(1L)).thenReturn(expectedCategory);

        Category actualCategory = categoryRepository.getCategoryById(1L);

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    void createCategory() {
        Category expectedCategory = new Category(1L, "Topic 1","url", new ArrayList<>());

        when(categoryRepository.createCategory(new Category(1L, "Topic 1","url", new ArrayList<>()))).thenReturn(expectedCategory);

        Category actualCategory = categoryRepository.createCategory(new Category(1L, "Topic 1","url", new ArrayList<>()));

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    void updateCategory() {
        Category categoryToUpdate = new Category(1L, "Topic 1","url", new ArrayList<>());

        when(categoryRepository.updateCategory(categoryToUpdate)).thenReturn(categoryToUpdate);

        categoryToUpdate.setCategoryId(2L);
        categoryToUpdate.setName("Updated Topic 1");
        categoryToUpdate.setPhotoUrl("Updated url");
        categoryToUpdate.setArticlesByCategoryId(new ArrayList<>());

        Category updatedCategory = categoryRepository.updateCategory(categoryToUpdate);

        assertEquals(2L, updatedCategory.getCategoryId());
        assertEquals("Updated Topic 1", updatedCategory.getName());
        assertEquals("Updated url", updatedCategory.getPhotoUrl());
        assertEquals(new ArrayList<>(), updatedCategory.getArticlesByCategoryId());
        assertEquals(categoryToUpdate, updatedCategory);

        verify(categoryRepository, times(1)).updateCategory(categoryToUpdate);
    }

    @Test
    void deleteCategoryById() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Topic 1", "url",new ArrayList<>()));
        categories.add(new Category(2L, "Topic 2","url", new ArrayList<>()));

        categoryRepository.deleteCategoryById(1L);

        verify(categoryRepository, times(1)).deleteCategoryById(1L);
    }
}