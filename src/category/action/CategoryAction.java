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
    private int page=1;    //初始化在第一页

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String execute() throws Exception {
        List<Category> list = categoryService.getAll();
        ActionContext.getContext().getSession().put("all_category",list);
        return SUCCESS;
    }
    public String menueDetails(){
        PageBean pageBean = categoryService.menueDetails(cid,page);
        System.out.println(pageBean.toString());
        //将cid也保存在值栈中,保证切换页数时有当前参数可传
        ActionContext.getContext().getValueStack().set("cid",cid);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return "menueDetails";
    }


}
