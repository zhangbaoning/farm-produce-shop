package user.service;

import org.springframework.transaction.annotation.Transactional;
import user.dao.UserDao;
import user.entity.User;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/5/23.
 */
@Transactional
public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void register(User user) {
        userDao.regiter(user);
    }

    public User findByCode(String code) {
        return userDao.findByCode(code);
    }

    public void update(User user) {
        userDao.update(user);
    }
    public void adminUpdate(Integer uid){
        User user = this.userDao.getByUid(uid);
        userDao.update(user);
    }

    public User findBylogin(String username, String password) {
        return userDao.findBylogin(username, password);
    }

    public List getAll() {
        return userDao.getAll();
    }
    public User getByUid(Integer uid){
        return this.userDao.getByUid(uid);
    }

    /**
     * 通过用户的Id得到对象，删除这个对象
     * @param uid
     */
    public void del(Integer uid){
        User user = userDao.getByUid(uid);
        userDao.del(user);
    }
}
