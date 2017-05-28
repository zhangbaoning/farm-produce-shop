package category.service;

import product.dao.ProductDao;
import product.entity.Product;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class CategorysercondService {
    ProductDao productDao;
    PageBean pageBean;
    int start = 0;
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public PageBean getProductByCs(int csid,int page){
        pageBean = new PageBean();
        pageBean.setPage(page);
        start = (pageBean.getPage()-1)*pageBean.getLimit();
        pageBean.setTotalCount(productDao.getProductCountByCs(csid));
        List<Product> list = productDao.getProductByCategorysecond(csid,pageBean.getLimit(),start);
        pageBean.setTotalPage((int) Math.ceil(pageBean.getTotalCount()*1.0/pageBean.getLimit()));
        pageBean.setList(list);
        System.out.println(pageBean.toString());
        return pageBean;
    }
}
