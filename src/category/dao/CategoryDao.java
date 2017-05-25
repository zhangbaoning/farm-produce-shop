package category.dao;

import category.entity.Category;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/25.
 */
public class CategoryDao extends HibernateDaoSupport {
    public List<Category> getAll(){
        String hql = "from Category";
        List<Category> list = this.getHibernateTemplate().find(hql);
        return list;
    }
}
