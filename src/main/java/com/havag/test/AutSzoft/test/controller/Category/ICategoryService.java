package com.havag.test.AutSzoft.test.controller.Category;

import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
    Category getCategoryById(long categoryId);
    boolean addCategory(Category category);
    Category updateCategory(Category category);
    boolean deleteCategory(long categoryId);
    Category getCategoryByName(String categoryName);
}