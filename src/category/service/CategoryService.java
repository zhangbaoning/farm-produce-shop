package category.service;

import category.dao.CategoryDao;
import category.entity.Category;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class CategoryService {
    CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
