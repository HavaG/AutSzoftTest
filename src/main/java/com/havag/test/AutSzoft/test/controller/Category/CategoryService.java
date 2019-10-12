package com.havag.test.AutSzoft.test.controller.Category;

import com.havag.test.AutSzoft.test.modules.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(null);
    }

    @Override
    public boolean addCategory(Category category) {
        for (Category iter : categoryRepository.findAll()) {
            if(iter.getName().equals(category.getName())) {
                return false;
            }
        }
        List<String> tmp = category.getLabels();

        for(int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).length() < 3 || tmp.get(i).length() > 10) {
                tmp.remove(i);
            }
        }

        category.setLabel(tmp);
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Category updateCategory(Category category) {
        //check if exist in db
        Optional<Category> tmp = categoryRepository.findById(category.getId());
        if(tmp.isPresent()) {
            Category tmpCategory = tmp.get();
            if(category.getName() == null)
                category.setName(tmpCategory.getName());

            if(category.getLabels() == null) {
                category.setLabel(tmpCategory.getLabels());
            } else {
                for(int i = 0; i < category.getLabels().size(); i++) {
                    if (category.getLabels().get(i).length() < 3 || category.getLabels().get(i).length() > 10) {
                        category.getLabels().remove(i);
                    }
                }
                category.getLabels().addAll(tmpCategory.getLabels());
            }


            categoryRepository.save(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        if(categoryRepository.existsById(categoryId)) {
            if (categoryRepository.findById(categoryId).isPresent()) {
                Category cat = categoryRepository.findById(categoryId).get();
                if (cat.getArticles().isEmpty()) {
                    categoryRepository.delete(getCategoryById(categoryId));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        for (Category iter : categoryRepository.findAll()) {
            if(iter.getName().equals(categoryName)) {
                return iter;
            }
        }
        return null;
    }
}
