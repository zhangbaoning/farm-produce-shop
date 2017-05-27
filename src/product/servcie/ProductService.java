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

}
