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
        //TODO: ráér minden egyedhez új id-t generál
        //check if exist in db
        Optional<Category> tmp = categoryRepository.findById(category.getId());
        if(tmp.isPresent()) {
            Category tmpCategory = tmp.get();
            if(category.getName() == null)
                category.setName(tmpCategory.getName());

            //delete old
            categoryRepository.deleteById(tmp.get().getId());
            //save new
            categoryRepository.save(category);
        }
    }

    @Override
    public boolean deleteCategory(long categoryId) {
        if(categoryRepository.existsById(categoryId)){
            categoryRepository.delete(getCategoryById(categoryId));
            return true;
        } else
            return false;
    }
}
