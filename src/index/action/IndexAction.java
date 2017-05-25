package index.action;

import category.entity.Category;
import category.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import product.entity.Product;
import product.servcie.ProductService;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/23.
 */

public class IndexAction extends ActionSupport {
    CategoryService categoryService; //主页显示一级分类
    ProductService productService;   //主页显示最热商品

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //执行主页的时候加载一级菜单
    @Override
    public String execute() throws Exception {
        List<Category> all_category_list = categoryService.getAll();
        //将一级菜单存在menu.jsp中，会多个页面使用到，所以使用session保存
        ActionContext.getContext().getSession().put("all_category",all_category_list);
        //最热门商品
        List<Product> hot_list = productService.getHot();
        ActionContext.getContext().getValueStack().set("hot_list",hot_list);
        //最新商品
        List<Product> newest_list = productService.getNewest();
        ActionContext.getContext().getValueStack().set("newest_list",newest_list);
        return SUCCESS;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        List<Product> hot_list = productService.getHot();
        System.out.println("dsjifjsdidf"+hot_list.size());

    }
}
