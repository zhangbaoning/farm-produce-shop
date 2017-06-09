package category.action;

import category.entity.Category;
import category.entity.Categorysecond;
import category.service.CategorysercondService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class CateGorysecondAction extends ActionSupport implements ModelDriven<Categorysecond>  {
//    int csid;
    int page = 1; //默认第一页
    int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    Categorysecond categorysecond = new Categorysecond();


    @Override
    public Categorysecond getModel() {
        return categorysecond;
    }

//    public int getCsid() {
//        return csid;
//    }
//
//    public void setCsid(int csid) {
//        this.csid = csid;
//    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    CategorysercondService categorysercondService;

    public void setCategorysercondService(CategorysercondService categorysercondService) {
        this.categorysercondService = categorysercondService;
    }

    public String getProductByCs() {
        PageBean pageBean = categorysercondService.getProductByCs(categorysecond.getCsid(), page);
        System.out.println(categorysecond.getCsid());
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        ActionContext.getContext().getValueStack().set("csid", categorysecond.getCsid());
        return "menueDetails";
    }

    /**
     * 后台查询到所有的二级目录
     *
     * @return
     */
    public String adminGetCsList() {
        PageBean pageBean = categorysercondService.getAllByPage(page);
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "adminGetCsList";
    }

    public String addPage() {
        List<Category> categories = categorysercondService.getAllCategory();
        ActionContext.getContext().getValueStack().set("category_list",categories);
        return "adminAddPage";
    }

    public String add() {
        Category category = categorysercondService.getCategory(cid);
        categorysecond.setCategory(category);
        System.out.println(categorysecond);
        categorysercondService.add(categorysecond);
        System.out.println(cid);
        return SUCCESS;
    }
    public String editPage(){
        List<Category> categories = categorysercondService.getAllCategory();
        ActionContext.getContext().getValueStack().set("category_list",categories);
        categorysecond = categorysercondService.get(categorysecond.getCsid());
        return "editPage";
    }
    public String update(){
        System.out.println(categorysecond.toString());
        categorysercondService.update(categorysecond);
        return SUCCESS;
    }
    @Test
    public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        CateGorysecondAction action = (CateGorysecondAction) context.getBean("cateGorysecondAction");
        action.update();
    }
    public String delete(){
        categorysercondService.del(categorysecond.getCsid());
        return SUCCESS;
    }
}
