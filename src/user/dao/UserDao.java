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
}
