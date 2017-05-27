package category.action;

import category.entity.Category;
import category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class CategoryAction extends ActionSupport{
    private int cid;
    private int page_number;

    CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }


    @Override
    public String execute() throws Exception {
        List<Category> list = categoryService.getAll();
        ActionContext.getContext().getSession().put("all_category",list);
        return SUCCESS;
    }
    public String menueDetails(){
        PageBean pageBean = categoryService.menueDetails(cid,page_number);
        System.out.println(pageBean.toString());
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "menueDetails";
    }


}
