package product.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import product.entity.Product;
import utils.PageBean;
import utils.PageHibernateCallBack;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class ProductDao extends HibernateDaoSupport {
    public List<Product> getHot() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        //注意下面的eq方法的列名属性要和hibernate中的hbm.xml相同
        criteria.add(Restrictions.eq("isHot", 1));
        criteria.addOrder(Order.desc("pdate"));
        List<Product> list = this.getHibernateTemplate().
                findByCriteria(criteria, 0, 10);
        return list;
    }

    public List<Product> getNewest() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        criteria.addOrder(Order.desc("pdate"));
        List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
        return list;
    }

    public Product getById(Integer pid) {
        return this.getHibernateTemplate().get(Product.class, pid);
    }

    //根据一级分类查看所有的商品数
    public int getProductCount(int cid) {
        String hql = "select count(p.pid) from Product p where p.categorysecond.category.cid=?";
        List<Long> list = this.getHibernateTemplate().find(hql, cid);
        return list.get(0).intValue();
    }

    //通过封装的pageBean传入分页查询的条件
    public List getProductByCategory(int cid, int limit, int start) {
        Object[] params = new Object[1];

        String hql = "select p from Product p join p.categorysecond cs join cs.category c where c.cid=?";
        params[0] = cid;
        List<Product> list = this.getHibernateTemplate().execute(
                new PageHibernateCallBack(hql, limit, params, start));
        return list;
    }


}
