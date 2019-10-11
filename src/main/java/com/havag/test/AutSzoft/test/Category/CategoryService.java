package com.havag.test.AutSzoft.test.Category;

import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            list.add(category);
        }
        return list;
    }

    @Override
    public Category getCategoryById(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(null);
    }

    @Override
    public boolean addCategory(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public void updateCategory(Category category) {
        //TODO updateCategory
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.delete(getCategoryById(categoryId));
    }
}
