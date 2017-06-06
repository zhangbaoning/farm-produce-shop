package admin.dao;

import admin.entity.Adminuser;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/6/3.
 */
public class AdminDao extends HibernateDaoSupport {
    public Adminuser getAdmin(Integer uid){
        return this.getHibernateTemplate().get(Adminuser.class,uid);
    }
    public Adminuser getAdminByName(String username){
        String hql = "from Adminuser admin where admin.username=?";
        List<Adminuser> list =  this.getHibernateTemplate().find(hql,username);
        if (list.size()>0&&list!=null){
            return list.get(0);
        }
        return null;
    }
    public List login(Adminuser adminuser){
        String hql ="from Adminuser admin where admin.username=? and admin.password=?";
        List list = this.getHibernateTemplate().find(hql,adminuser.getUsername(),adminuser.getPassword());
        return list;
    }


}
