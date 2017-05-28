package category.service;

import category.dao.CategoryDao;
import category.entity.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import product.dao.ProductDao;
import product.entity.Product;
import user.entity.User;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class CategoryService {
    CategoryDao categoryDao;
    ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    public PageBean menueDetails(int cid, int page_number) {
        PageBean pageBean = new PageBean();
        pageBean.setTotalCount(productDao.getProductCount(cid));
        pageBean.setTotalPage((int) Math.ceil(pageBean.getTotalCount() / pageBean.getLimit()));
        int start = (page_number-1) * pageBean.getLimit() + 1;
        //将得到商品分页返回
        //默认是第一页
        //如果跳页，需要将第几页传入
        List<Product> list = productDao.getProductByCategory(cid, pageBean.getLimit(), start);
        pageBean.setPage(page_number);
        pageBean.setList(list);
        return pageBean;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        CategoryService service = (CategoryService) context.getBean("categoryService");
        PageBean pageBean = service.menueDetails(1,1);
        System.out.println(pageBean.getList().size());
        System.out.println(pageBean.toString());
    }
}
