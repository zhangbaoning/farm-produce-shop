package category.service;

import category.dao.CategoryDao;
import category.dao.CategorysecondDao;
import category.entity.Category;
import category.entity.Categorysecond;
import product.dao.ProductDao;
import product.entity.Product;
import utils.PageBean;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/26.
 */
public class CategorysercondService {
    CategorysecondDao categorysecondDao;
    CategoryDao categoryDao;

    public void setCategorysecondDao(CategorysecondDao categorysecondDao) {
        this.categorysecondDao = categorysecondDao;
    }

    ProductDao productDao;
    PageBean pageBean;
    int start = 0;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public PageBean getProductByCs(int csid, int page) {
        pageBean = new PageBean();
        pageBean.setPage(page);
        start = (pageBean.getPage() - 1) * pageBean.getLimit();
        pageBean.setTotalCount(productDao.getProductCountByCs(csid));
        List<Product> list = productDao.getProductByCategorysecond(csid, pageBean.getLimit(), start);
        pageBean.setTotalPage((int) Math.ceil(pageBean.getTotalCount() * 1.0 / pageBean.getLimit()));
        pageBean.setList(list);
        System.out.println(pageBean.toString());
        return pageBean;
    }

    /**
     * @param page 要查询的第几页
     * @return 那页查询到的数据
     */
    public PageBean getAllByPage(Integer page) {
        PageBean pageBean = new PageBean();
        int count = categorysecondDao.getCount();
        pageBean.setTotalCount(count);
        pageBean.setPage(page);
        pageBean.setTotalPage((int) Math.ceil(count * 1.0 / pageBean.getLimit()));
        List list = categorysecondDao.getAll(pageBean);
        pageBean.setList(list);
        return pageBean;
    }

    public void add(Categorysecond categorysecond) {
        categorysecondDao.add(categorysecond);
    }

    /**
     *
     * @return 返回得到所有的一级目录，添加二级目录要选择父目录
     */
    public List getAllCategory() {
        return categoryDao.getAll();
    }
    public Categorysecond get(Integer csid) {
        return categorysecondDao.get(csid);
    }

    /**
     *
     */
    public void update(Categorysecond categorysecond){
        categorysecondDao.update(categorysecond);
    }

    /**
     * 二级目录添加父目录的时候需要得到一级目录的对象
     * @param cid 一级目录id
     * @return 一级目录对象
     */
    public Category getCategory(Integer cid){
        return categoryDao.get(cid);
    }
    public void del(Integer csid){
        Categorysecond categorysecond = categorysecondDao.get(csid);
        categorysecondDao.del(categorysecond);
    }
    public List getAllCategorysecond(){
        return categorysecondDao.getAllCategorysecond();
    }
}
