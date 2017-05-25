package category.action;

import category.entity.Category;
import category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class CategoryAction extends ActionSupport{
    CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public String execute() throws Exception {
        List<Category> list = categoryService.getAll();
        ActionContext.getContext().getSession().put("all_category",list);
        return SUCCESS;
    }
}
