package product.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import product.entity.Product;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class ProductDao extends HibernateDaoSupport {
    public List<Product> getHot(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        //注意下面的eq方法的列名属性要和hibernate中的hbm.xml相同
        criteria.add(Restrictions.eq("isHot",1));
        criteria.addOrder(Order.desc("pdate"));
        List<Product> list = this.getHibernateTemplate().
                findByCriteria(criteria,0,10);
        return list;
    }
    public List<Product> getNewest(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        criteria.addOrder(Order.desc("pdate"));
        List<Product> list = this.getHibernateTemplate().findByCriteria(criteria,0,10);
        return list;
    }
}
