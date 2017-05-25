package user.service;

import org.springframework.transaction.annotation.Transactional;
import user.dao.UserDao;
import user.entity.User;

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

    public User findBylogin(String username, String password) {
        return userDao.findBylogin(username, password);
    }
}
