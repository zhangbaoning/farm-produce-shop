package admin.action;

import admin.entity.Adminuser;
import admin.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by zhangbaoning on 2017/6/3.
 */
public class AdminAction extends ActionSupport implements ModelDriven<Adminuser>{
    AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    Adminuser adminuser = new Adminuser();
    @Override
    public Adminuser getModel() {
        return adminuser;
    }
    public String login(){
        if (adminService.login(adminuser)){
            Adminuser admin = this.adminService.getAdminByName(adminuser.getUsername());
            System.out.println(admin.toString());
            ActionContext.getContext().getSession().put("admin",admin);
            return SUCCESS;
        }else {
            return LOGIN;
        }
    }
    public String adminPage(){
        return "adminPage";
    }
}
