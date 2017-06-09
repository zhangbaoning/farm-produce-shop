package product.servcie;

import product.dao.ProductDao;
import product.entity.Product;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class ProductService {
    ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getHot() {
        return productDao.getHot();
    }

    public List<Product> getNewest() {
        return productDao.getNewest();
    }

    public Product getById(Integer pid) {
        return productDao.getById(pid);
    }
    public PageBean getByPage(int page){
        PageBean pageBean = new PageBean();
        pageBean.setPage(page);     //显示第几页
        int total = productDao.getAll();
        pageBean.setTotalCount(total);   //总的记录数
        int start = (page-1)*pageBean.getLimit();
        pageBean.setTotalPage((int) Math.ceil(total*1.0/pageBean.getLimit()));
        List list = productDao.getAllByPage(pageBean,start);
        pageBean.setList(list);
        return pageBean;
    }
    public void del(int pid){
        Product product = productDao.getById(pid);
        productDao.del(product);
    }
    public void save(Product product){
        productDao.save(product);
    }
    public void update(Product product){
        productDao.update(product);
    }

}
