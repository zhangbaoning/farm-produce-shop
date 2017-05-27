package utils;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/27.
 */
public class PageHibernateCallBack implements HibernateCallback<List> {
    private String hql;
    private int limit;  //每页的限制
    private Object[] params; //传入的？
    private int start; //开始的序号

    public PageHibernateCallBack(String hql, int limit, Object[] params, int start) {
        super();
        this.hql = hql;
        this.limit = limit;
        this.params = params;
        this.start = start;
    }

    @Override

    public List  doInHibernate(Session session) throws HibernateException, SQLException {
        Query query = session.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i,params[i]);
            }
        }
        //分页
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.list();
    }
}
