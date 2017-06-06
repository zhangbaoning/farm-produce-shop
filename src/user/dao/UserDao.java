package user.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import user.entity.User;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/23.
 */
public class UserDao extends HibernateDaoSupport {
    public User findByUsername(String username) {
        String hql = "from User where username=?";
        List<User> list = this.getHibernateTemplate().find(hql, username);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }
    public void regiter(User user){
        this.getHibernateTemplate().save(user);
    }
    public User findByCode(String code){
        String hql="from User where state=0 and code=?";
        List<User> list = this.getHibernateTemplate().find(hql,code);
        if (list!=null&&list.size()>0){
            return list.get(0);
        }else
            return null;
    }
    public void update(User user){
        this.getHibernateTemplate().update(user);
    }
    public User findBylogin(String username,String password){
        String hql = "from User where username=? and password=?";
        List<User> list = this.getHibernateTemplate().find(hql,username,password);
        if (list!=null&& list.size()>0){
            return list.get(0);
        }else
        return null;
    }
    public List getAll(){
        String hql = "from User ";
        List list = this.getHibernateTemplate().find(hql);
        return list;
    }
    public User getByUid(Integer uid){
        return this.getHibernateTemplate().get(User.class,uid);
    }
    public void del(User user){
        this.getHibernateTemplate().delete(user);
    }

}
