package com.havag.test.AutSzoft.test.Category;

import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(long categoryId);
    boolean addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
}