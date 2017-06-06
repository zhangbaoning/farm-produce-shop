package admin.service;

import admin.dao.AdminDao;
import admin.entity.Adminuser;

import java.util.List;

/**
 * Created by zhangbaoning on 2017/6/3.
 */

public class AdminService {
    AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Boolean login(Adminuser adminuser){
        List list = adminDao.login(adminuser);
            if (list.size()>0&&list!=null){
                return true;
            }
            return false;
    }
    public Adminuser getAdmin(Integer uid){
        return adminDao.getAdmin(uid);
    }
    public Adminuser getAdminByName(String username){
        return adminDao.getAdminByName(username);
    }

}
