package category.dao;

import category.entity.Categorysecond;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import utils.PageBean;
import utils.PageHibernateCallBack;

import java.util.List;

/**
 * 二级目录的dao
 * Created by zhangbaoning on 2017/6/7.
 */
public class CategorysecondDao extends HibernateDaoSupport {
    /**
     *
     * @return 二级目录的数量
     */
    public int getCount(){
        String hql = "select count (cs.csid) from Categorysecond cs";
        List<Long> list = this.getHibernateTemplate().find(hql);
        return list.get(0).intValue();
    }
    public List getAll(PageBean pageBean){
        String hql ="from Categorysecond";
        int start = (pageBean.getPage()-1)*pageBean.getLimit();
        List list = this.getHibernateTemplate().executeFind(new PageHibernateCallBack(
                hql,pageBean.getLimit(),null,start
        ));
        return list;
    }
    public void add(Categorysecond categorysecond){
        this.getHibernateTemplate().save(categorysecond);
    }
    public Categorysecond get(Integer csid){
        return this.getHibernateTemplate().get(Categorysecond.class,csid);
    }
    public void update(Categorysecond categorysecond){
        this.getHibernateTemplate().update(categorysecond);
    }
    public void del(Categorysecond categorysecond){
        this.getHibernateTemplate().delete(categorysecond);
    }
    public List getAllCategorysecond(){
        String hql = "from Categorysecond ";
        return this.getHibernateTemplate().find(hql);
    }

}
